package com.dewen.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/test")
    public String test(@RequestParam String name){
        System.out.println(8011);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",8011);
        jsonObject.put("msg","你好"+name);
        return jsonObject.toJSONString();
    }
}
