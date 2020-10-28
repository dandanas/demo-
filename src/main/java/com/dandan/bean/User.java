package com.dandan.bean;

import lombok.Data;

import java.util.Optional;

/**
 * @date：2020/10/28
 * @author：suchao
 */
public class User {
    private Address address;

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public class Address {
        private Country country;

        public Optional<Country> getCountry() {
            return Optional.ofNullable(country);
        }

    }

    @Data
    public class Country {
        private String isocode;




    }

}




