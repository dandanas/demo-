package com.dandan.controller;

import com.dandan.logAop.TimeConsuming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: dandan
 * @Date: 2020/10/25 21:23
 */
@RestController
public class WelcomeController {

    @Autowired
    private TestAnnoation testAnnoation;

    @Resource
    private WelcomeController welcomeController;

    @RequestMapping(value = "/queryProvinceInfo")
    public String queryProvinceInfo(@RequestParam(value = "provinceCode") String haha) {
        //return testAnnoation.printDate();
        return welcomeController.printDate(haha);
    }


    @TimeConsuming(fullMsg = true, properties = {"haha"})
    public String printDate(String haha){
        System.out.println(haha);
        for (int i = 0; i <100 ; i++) {
            System.out.println(i);
        }
        return "计算成功";
    }

}
