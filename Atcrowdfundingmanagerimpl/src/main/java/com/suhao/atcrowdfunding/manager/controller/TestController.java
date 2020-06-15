package com.suhao.atcrowdfunding.manager.controller;

import com.suhao.atcrowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suhao
 * @create_date 2020-05-13 14:10
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){

        System.out.println("TestController");
        testService.insert();
        return "success";
    }
}
