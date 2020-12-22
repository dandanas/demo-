package com.dandan.controller;

import com.dandan.logAop.TimeConsuming;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dandan
 * @Date: 2020/10/25 21:23
 */
@RestController
@RequiredArgsConstructor
public class WelcomeController extends UserBaseController{

    @Autowired
    private  WelcomeController welcomeController ;


    @RequestMapping(value = "/queryUserById")
    public String queryUserById() {
        return welcomeController.printDate("haha");
    }


    /**
     * 内部类不能被切面切到，是Spring  内部实现用的是Method.invoke()  而不是Method.superInvoke()
     * @param haha
     * @return
     */
    @TimeConsuming()
    public String printDate(String haha){
        System.out.println(haha);
        for (int i = 0; i <100 ; i++) {
            System.out.println(i);
        }
        return "计算成功";
    }

}
