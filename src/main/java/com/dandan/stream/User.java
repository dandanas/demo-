package com.dandan.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @date：2020/10/27
 * @author：suchao
 */
@Data
@AllArgsConstructor
public class User {

    private String name;

    private Integer age;

    private List<Integer> test;
}
