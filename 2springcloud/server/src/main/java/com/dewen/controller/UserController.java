package com.dewen.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：dewen
 */
@RefreshScope
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private static final String USER_NAME = "dewen";

    @Value("${userName}")
    private String userName;
    @Value("${server.port}")
    private String port;

    /**
     * 获取用户名
     *
     * @param userId
     * @return userName
     */
    @GetMapping("/getUserName/{userId}")
    public String getUserName(@PathVariable String userId) {
        if (USER_NAME.equals(userId)) {
            return userName;
        } else {
            return "佚名";
        }
    }

    /**
     * 获取用户年龄
     *
     * @param userId
     */
    @GetMapping("getUserAge")
    public String getUserAge(@RequestParam("userId") String userId) {
        if (USER_NAME.equals(userId)) {
            return "18";
        } else {
            return "24";
        }
    }

    /**
     * 使用代码编写流控规则，项目中不推荐使用，这是硬编码方式
     * 注解 @PostConstruct 的含义是：本类构造方法执行结束后执行
     */
//    PostConstruct
//    public void initFlowRule() {
//        /* 1.创建存放限流规则的集合 */
//        List<FlowRule> rules = new ArrayList<>();
//        /* 2.创建限流规则 */
//        FlowRule rule = new FlowRule();
//        /* 定义资源，表示 Sentinel 会对哪个资源生效 */
//        rule.setResource("Hello");
//        /* 定义限流的类型(此处使用 QPS 作为限流类型) */
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        /* 定义 QPS 每秒通过的请求数 */
//        rule.setCount(2);
//        /* 3.将限流规则存放到集合中 */
//        rules.add(rule);
//        /* 4.加载限流规则 */
//        FlowRuleManager.loadRules(rules);
//    }
}