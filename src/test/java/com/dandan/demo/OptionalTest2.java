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
 */
@Slf4j
public class OptionalTest2 {

    public void whenChaining_beforek() {
        User user = new User();
       // String isocode = user.getAddress().getCountry().getIsocode();

//        if (user != null) {
//            Address address = user.getAddress();
//            if (address != null) {
//                Country country = address.getCountry();
//                if (country != null) {
//                    String isocode = country.getIsocode();
//                    if (isocode != null) {
//                        isocode = isocode.toUpperCase();
//                    }
//                }
//            }
//        }
    }

    @Test
    public void whenChaining_thenOk() {
        User user = new User();
        String result = Optional.ofNullable(user)
                .flatMap(u -> u.getAddress())
                .flatMap(a -> a.getCountry())
                .map(c -> c.getIsocode())
                .orElse("default");

        assertEquals(result, "default");

        //进一步精简
        String result1 = Optional.ofNullable(user)
                .flatMap(User::getAddress)
                .flatMap(User.Address::getCountry)
                .map(User.Country::getIsocode)
                .orElse("default");
        assertEquals(result1, "default");
    }
}
