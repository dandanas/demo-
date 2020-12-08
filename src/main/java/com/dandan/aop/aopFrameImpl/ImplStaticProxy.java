package com.dandan.aop.aopFrameImpl;

import com.dandan.service.UserService;
import com.dandan.service.UserServiceImpl;
import lombok.AllArgsConstructor;

/**
 * @date：2020/12/8
 * @author：suchao
 * 静态代理
 */
@AllArgsConstructor
public class ImplStaticProxy implements UserService {

    private UserService userService;

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
        ImplStaticProxy implStaticProxy = new ImplStaticProxy(userService);
        implStaticProxy.queryUserById(-1L);
    }
}


