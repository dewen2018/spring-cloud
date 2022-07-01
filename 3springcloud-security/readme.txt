OAuth2.0、JWT()


JWT由三部分组成：
    Header（头部）：头部描述了该JWT的最基本信息，如类型、签名算法等。
    Payload（负载）：载荷存放了令牌有效信息。
    Signature（签名）：将头部和载荷使用Base 64编码后，通过所使用的加密方法进行签名，签名后的结果放在这部分内容中。
    表现形式为：Header.Payload.Signature


1.Header
    Header 部分是一个 JSON 对象，描述 JWT 的元数据，通常是下面的样子:
    {
      "alg": "HS256",
      "typ": "JWT"
    }
    上面代码中，alg属性表示签名的算法（algorithm），默认是 HMAC SHA256（写成 HS256）；typ属性表示这个令牌（token）的类型（type），JWT 令牌统一写为JWT。
    上面的 JSON 对象使用 Base64URL 算法转成字符串

Payload
    Payload 部分也是一个 JSON 对象，用来存放实际需要传递的数据。JWT 规定了7个官方字段:

    iss (issuer)：签发人

    exp (expiration time)：过期时间

    sub (subject)：主题

    aud (audience)：受众

    nbf (Not Before)：生效时间

    iat (Issued At)：签发时间

    jti (JWT ID)：编号

    当然，用户也可以定义私有字段。

    这个 JSON 对象也要使用 Base64URL 算法转成字符串

Signature
    Signature 部分是对前两部分的签名，防止数据篡改

签名算法如下：

    HMACSHA256(
      base64UrlEncode(header) + "." +
      base64UrlEncode(payload),
      your-256-bit-secret
    )
算出签名以后，把 Header、Payload、Signature 三个部分拼成一个字符串，每个部分之间用"."分隔

JWT认证和授权
Security是基于AOP和Servlet过滤器的安全框架，为了实现JWT要重写那些方法、自定义那些过滤器需要首先了解security自带的过滤器。security默认过滤器链如下：

org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter
org.springframework.security.web.context.SecurityContextPersistenceFilter
org.springframework.security.web.header.HeaderWriterFilter
org.springframework.security.web.authentication.logout.LogoutFilter
org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
org.springframework.security.web.savedrequest.RequestCacheAwareFilter
org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter
org.springframework.security.web.authentication.AnonymousAuthenticationFilter
org.springframework.security.web.session.SessionManagementFilter
org.springframework.security.web.access.ExceptionTranslationFilter
org.springframework.security.web.access.intercept.FilterSecurityInterceptor

SecurityContextPersistenceFilter
    这个过滤器有两个作用：

    用户发送请求时，从session对象提取用户信息，保存到SecurityContextHolder的securitycontext中
    当前请求响应结束时，把SecurityContextHolder的securitycontext保存的用户信息放到session，便于下次请求时共享数据；同时将SecurityContextHolder的securitycontext清空
    由于禁用session功能，所以该过滤器只剩一个作用即把SecurityContextHolder的securitycontext清空。举例来说明为何要清空securitycontext：用户1发送一个请求，由线程M处理，
    当响应完成线程M放回线程池；用户2发送一个请求，本次请求同样由线程M处理，由于securitycontext没有清空，理应储存用户2的信息但此时储存的是用户1的信息，造成用户信息不符

UsernamePasswordAuthenticationFilter
    UsernamePasswordAuthenticationFilter继承自AbstractAuthenticationProcessingFilter,处理逻辑在doFilter方法中：

    当请求被UsernamePasswordAuthenticationFilter拦截时，判断请求路径是否匹配登录URL，若不匹配继续执行下个过滤器；否则，执行步骤2
    调用attemptAuthentication方法进行认证。UsernamePasswordAuthenticationFilter重写了attemptAuthentication方法,负责读取表单登录参数，委托AuthenticationManager进行认证，返回一个认证过的token（null表示认证失败）
    判断token是否为null，非null表示认证成功，null表示认证失败
    若认证成功，调用successfulAuthentication。该方法把认证过的token放入securitycontext供后续请求授权，同时该方法预留一个扩展点（AuthenticationSuccessHandler.onAuthenticationSuccess方法），进行认证成功后的处理
    若认证失败，同样可以扩展uthenticationFailureHandler.onAuthenticationFailure进行认证失败后的处理
    只要当前请求路径匹配登录URL，那么无论认证成功还是失败，当前请求都会响应完成，不再执行过滤器链
    UsernamePasswordAuthenticationFilter的attemptAuthentication方法，执行逻辑如下：

    从请求中获取表单参数。因为使用HttpServletRequest.getParameter方法获取参数，它只能处理Content-Type为application/x-www-form-urlencoded或multipart/form-data的请求，若是application/json则无法获取值
    把步骤1获取的账号、密码封装成UsernamePasswordAuthenticationToken对象，创建未认证的token。UsernamePasswordAuthenticationToken有两个重载的构造方法，其中public UsernamePasswordAuthenticationToken(Object principal, Object credentials)创建未经认证的token,public UsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities)创建已认证的token
    获取认证管理器AuthenticationManager，其缺省实现为ProviderManager，调用其authenticate进行认证
    ProviderManager的authenticate是个模板方法，它遍历所有AuthenticationProvider，直至找到支持认证某类型token的AuthenticationProvider，调用AuthenticationProvider.authenticate方法认证，AuthenticationProvider.authenticate加载正确的账号、密码进行比较验证
    AuthenticationManager.authenticate方法返回一个已认证的token
    AnonymousAuthenticationFilter
    AnonymousAuthenticationFilter负责创建匿名token：

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                SecurityContextHolder.getContext().setAuthentication(this.createAuthentication((HttpServletRequest)req));
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(LogMessage.of(() -> {
                        return "Set SecurityContextHolder to " + SecurityContextHolder.getContext().getAuthentication();
                    }));
                } else {
                    this.logger.debug("Set SecurityContextHolder to anonymous SecurityContext");
                }
            } else if (this.logger.isTraceEnabled()) {
                this.logger.trace(LogMessage.of(() -> {
                    return "Did not set SecurityContextHolder since already authenticated " + SecurityContextHolder.getContext().getAuthentication();
                }));
            }

            chain.doFilter(req, res);
        }
    如果当前用户没有认证，会创建一个匿名token，用户是否能读取资源交由FilterSecurityInterceptor过滤器委托给决策管理器判断是否有权限读取

实现思路
JWT认证思路：

利用Security原生的表单认证过滤器验证用户名、密码
验证通过后自定义AuthenticationSuccessHandler认证成功处理器，由该处理器生成token令牌
JWT授权思路:

使用JWT目的是让服务器变成无状态，不用session共享数据，所以要禁用security的session功能（http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)）
token令牌数据结构设计时，payload部分要储存用户名、角色信息
token令牌有两个作用：
认证， 用户发送的token合法即代表认证成功
授权，令牌验证成功后提取角色信息，构造认证过的token，将其放到securitycontext，具体权限判断交给security框架处理
自己实现一个过滤器，拦截用户请求，实现（3）中所说的功能




公共声明：该部分一般是用户相关信息或业务需要的其他信息，对于该部分的信息没有限制，但不建议将敏感信息放在该部分，因为客户端可以对该部分进行解密。

私有声明：该部分是提供者和消费者所共同定义的声明，也是使用Base 64进行加/解密，因此也不建议存放敏感信息。



（1）客户端调用认证服务器的登录接口/获取Token接口，传入用户名密码。（2）认证服务器确认用户名密码，并创建JWT返回给客户端；（3）客户端获取到JWT后进行缓存。（4）客户端请求资源服务器，并在请求的HTTP头部中附加JWT。（5）资源服务端对JWT进行校验，校验通过后，向客户端返回相关的资源和数据。

使用JWT进行认证处理具有以下优点：
·JWT是基于令牌的，将用户状态分散到了客户端中，服务器端无状态，减轻了服务器的压力，提升了性能；
·JWT具有严格的结构化，其自身就包含了关于认证用户的相关消息，一旦校验成功那么资源服务器就无须再去认证服务器验证信息的有效性；
·JWT中的载荷可以支持定制化，因此开发者可以根据业务需要进行扩展定义，如添加用户是否是管理员、用户所在分桶等信息，从而满足业务需要；
·JWT体积小，便于传输，并且在传输方式可以支持URL/POST参数或者HTTP头部等方式传输，因而可以支持多种客户端，不仅仅是Web；
·JWT使用JSON格式，对跨语言的支持非常好；
·JWT支持跨域，使单点登录的开发更容易。



    /**
     * 这里我们设置了一个JWT加密所使用的密钥。对于JWT的加密，支持对称加密和非对称加密，
     * 非对称加密需要在服务端生成一个密钥对（公钥和私钥），每一个需要使用JWT的客户端都可以获取到公钥，
     * 并可以使用公钥对JWT进行解密和认证。对于公钥和私钥的生成需要一个证书，
     * 相对来说比较麻烦，本项目直接采用对称加密的方式
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }

实施JWT安全方案缺点:
·JWT令牌注销：由于JWT令牌存储在客户端，当用户注销时可能由于有效时间还没有到，造成客户端还会存储，这时候需要开发者能够有效防止注销后令牌的访问，开发者可以借助API网关来实现。另外，采用短期令牌也是一个不错的解决方案。
·JWT令牌超长：
·避免成为系统新瓶颈：由于API网关服务会对认证服务器进行访问及鉴权处理，有可能会形成系统的新瓶颈。
·需有效防范XSS攻击：由于JWT存储在客户端，最有可能引发XSS攻击，因此当使用JWT时必须做出有效的防范。



    @EnableGlobalMethodSecurity(
            securedEnabled = true,
            jsr250Enabled = true,
            prePostEnabled = true
    )

    /**
     * 老师权限或学生权限
     */
    @GetMapping("/grade")
    ** prePostEnabled:**它可以使用@PreAuthorize和@PostAuthorize注解，基于表达式构造更复杂的访问控制语法
    @PreAuthorize("hasAnyAuthority('teacher','student')")
    securityEnable: 它的作用是使 @Secured注解可以保护你的Controller/Service层方法。
    @Secured("ROLE_ADMIN")
    jsr250Enabled:它可以让@RolesAllowed可以像这样使用
    @RolesAllowed("ROLE_ADMIN")
    public Object rs(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("张三", 100);
        return map;
    }
