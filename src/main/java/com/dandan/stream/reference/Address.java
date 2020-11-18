package com.dandan.stream.reference;

/**
 * @date：2020/11/18
 * @author：suchao
 */
public class Address {
    private String address;

    public Address(String address) {
        super();
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address [address=" + address + "]";
    }


}