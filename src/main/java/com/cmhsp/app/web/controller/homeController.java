package com.cmhsp.app.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @RequestMapping("/home")
    public String index() {
        return "心理健康综合服务平台";
    }
}
