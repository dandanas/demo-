package com.dandan.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        List<String> strings = new ArrayList<>();
        strings.add("dandan");
//        List<Object> objects = strings;
//        System.out.println(objects);
    }

}
