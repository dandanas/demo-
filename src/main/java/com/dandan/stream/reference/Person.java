package com.dandan.stream.reference;

import lombok.Data;

/**
 * @date：2020/11/16
 * @author：suchao
 */
@Data
public class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
