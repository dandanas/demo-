package com.dandan.service;

import com.dandan.aop.aopFrameImpl.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @date：2020/12/8
 * @author：suchao
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Override
    public User queryUserById(Long id) {
        if (id > 0) {
            User user = new User(1L, "苏超");
            System.out.println(user);
            return user;
        } else {
            int i = 1 / 0;
            return null;
        }
    }
}
