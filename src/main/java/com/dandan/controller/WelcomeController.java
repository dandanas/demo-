package com.dandan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: dandan
 * @Date: 2020/10/25 21:23
 */
@RestController
public class WelcomeController {

    @RequestMapping("/test")
    public String welcome(){
        return new Date().toString();
    }
}
