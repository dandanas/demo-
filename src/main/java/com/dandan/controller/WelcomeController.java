package com.dandan.controller;

import com.dandan.aop.aopFrameImpl.User;
import com.dandan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author: dandan
 * @Date: 2020/10/25 21:23
 */
@RestController
@RequiredArgsConstructor
public class WelcomeController extends UserBaseController{

    private final UserService userService;


    @RequestMapping(value = "/queryUserById")
    public User queryUserById(@RequestParam(value = "id") Long id) {
        return userService.queryUserById(id);
    }


    /**
     * 内部类不能被切面切到，是Spring  内部实现用的是Method.invoke()  而不是Method.superInvoke()
     * @param haha
     * @return
     */
//    //@TimeConsuming(fullMsg = true})
//    public String printDate(String haha){
//        System.out.println(haha);
//        for (int i = 0; i <100 ; i++) {
//            System.out.println(i);
//        }
//        return "计算成功";
//    }

}
