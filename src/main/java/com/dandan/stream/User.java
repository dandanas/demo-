package com.dandan.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @date：2020/10/27
 * @author：suchao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private Integer age;

    private List<Integer> test;

//    public Optional<Integer> getAge() {
//        return Optional.ofNullable(age);
//    }

    public Optional<List<Integer>> getTest(){
        return Optional.ofNullable(test);
    }
}
