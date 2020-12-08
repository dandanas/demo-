package com.dandan.service;

import com.dandan.aop.aopFrameImpl.User;

/**
 * @date：2020/12/8
 * @author：suchao
 */
public interface UserService {

    User queryUserById(Long id);
}
