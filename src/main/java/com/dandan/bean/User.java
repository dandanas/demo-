package com.dandan.bean;

import lombok.Data;

import java.util.Optional;

/**
 * @date：2020/10/28
 * @author：suchao
 */
@Data
public class User {
    private Address address;


    @Data
    public class Address {
        private Country country;



    }

    @Data
    public class Country {
        private String isocode;




    }

}




