package com.dandan.stream.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date：2020/11/18
 * @author：suchao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;

    private int age;

    private String name;

    private Address address;

    @Override
    public String toString() {
        return "Student [id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + "]";
    }


}