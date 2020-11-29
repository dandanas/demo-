package com.dandan.enumTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @date：2020/11/19
 * @author：suchao
 */
public class TestEnum {

    @Test
    public void test() {
        Pizza testPz = new Pizza();

        testPz.setStatus(Pizza.PizzaStatus.DELIVERED);

        System.out.println(testPz);
        System.out.println(testPz.isDelivered());
        testPz.printTimeToDeliver();
    }

}
