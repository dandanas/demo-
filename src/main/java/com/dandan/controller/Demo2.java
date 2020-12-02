//package com.dandan.controller;
//
///**
// * @date：2020/11/29
// * @author：suchao
// */
//
//import com.dandan.bean.Demo;
//import com.dandan.bean.DemoModel;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.validator.constraints.Range;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Valid;
//import javax.validation.Validator;
//import java.util.Set;
//
//@RequestMapping("/demo2")
//@RestController
//@Slf4j
//@Validated
//@AllArgsConstructor
//public class Demo2 {
//
//
//    private final Validator validator;
//
//    /**
//     *验证请求参数时，在@RequestBody DemoModel demo之间加注解 @Valid，然后后面加BindResult即可；多个参数的，可以加多个@Valid和BindingResult
//     * @param demo
//     * @param result
//
//
//     */
//    @RequestMapping("/demo2")
//    public void demo2(@RequestBody @Valid DemoModel demo, BindingResult result){
//        if(result.hasErrors()){
//            for (ObjectError error : result.getAllErrors()) {
//                System.out.println(error.getDefaultMessage());
//            }
//        }
//    }
//
//    /**
//     * 使用@Valid注解，对RequestParam对应的参数进行注解，是无效的，需要使用@Validated注解来使得验证生效。
//     * 如果不符合规范，会抛出javax.validation.ConstraintViolationException异常
//     */
//    @GetMapping("/getDemo")
//    public Integer getDemo(@Range(min = 1, max = 9, message = "年级只能从1-9")
//            @RequestParam(name = "gradle", required = true) int  gradle){
//        return gradle;
//    }
//
//
//    @RequestMapping("/demo4")
//    public void demo4(){
//        Demo demo = new Demo();
//        demo.setUserName("userName");
//        Set<ConstraintViolation<Demo>> validate = validator.validate(demo);
//        for (ConstraintViolation<Demo> dem : validate) {
//            System.out.println(dem.getMessage());
//        }
//    }
//}