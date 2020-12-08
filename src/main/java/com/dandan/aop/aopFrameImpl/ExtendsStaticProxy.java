package com.dandan.aop.aopFrameImpl;

import com.dandan.service.UserServiceImpl;

/**
 * @date：2020/12/9
 * @author：suchao
 */
public class ExtendsStaticProxy extends UserServiceImpl {

    public UserServiceImpl userService;

    public ExtendsStaticProxy(UserServiceImpl userServiceImpl){
        this.userService = userServiceImpl;
    }

    @Override
    public User queryUserById(Long id) {

        try {
            System.out.println("方法开始执行了哦");
            User user = userService.queryUserById(id);
            System.out.println("方法执行结果是这个哦"+user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("方法抛出异常了哦");
        }finally {
            System.out.println("方法执行finally了哦");
        }
        return null;
    }


    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ExtendsStaticProxy extendsStaticProxy = new ExtendsStaticProxy(userService);
        extendsStaticProxy.queryUserById(1L);
        extendsStaticProxy.queryUserById(-1L);
    }
}
