package com.dandan.demo;

import com.dandan.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @date：2020/10/28
 * @author：suchao
 * 链式操作
 * //TODO flatMap换成map也是可以的，为什么还要有flatMap ，使用flatMap还要将User实体类中的get方法改写，繁？
 */
@Slf4j
public class OptionalTest2 {

    @Test
    public void whenChaining_beforek() {
        User user = new User();
        //会报无数个空指针
      //String isocode = user.getAddress().getCountry().getIsocode();
        //代码繁琐，需要加很多个if/else
        if (user != null) {
            User.Address address = user.getAddress();
            if (address != null) {
                User.Country country = address.getCountry();
                if (country != null) {
                    String isocode = country.getIsocode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                        log.info("{}",isocode);
                    }
                }
            }
        }
    }

    @Test
    public void whenChaining_thenOk() {
        User user = new User();
//        String result = Optional.ofNullable(user)
//                .flatMap(u -> u.getAddress())
//                .flatMap(a -> a.getCountry())
//                .map(c -> c.getIsocode())
//                .orElse("default");

        String result2 = Optional.ofNullable(user)
                .map(u -> u.getAddress())
                .map(a -> a.getCountry())
                .map(c -> c.getIsocode())
                .orElse("default");

        assertEquals(result2, "default");

        //进一步精简
        String result1 = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(User.Address::getCountry)
                .map(User.Country::getIsocode)
                .orElse("default");
        assertEquals(result1, "default");
    }
}
