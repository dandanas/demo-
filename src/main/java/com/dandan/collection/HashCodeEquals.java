package com.dandan.collection;

import java.util.HashSet;

/**
 * @date：2020/11/19
 * @author：suchao
 */
public class HashCodeEquals {
    public static void main(String[] args) {
        HashSet<EqualsObject> equalsObjects = new HashSet<>();

        EqualsObject a = new EqualsObject(1, "ha");
        EqualsObject b = new EqualsObject(1, "ha");
        EqualsObject c = new EqualsObject(1, "ha");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        equalsObjects.add(a);
        equalsObjects.add(b);
        equalsObjects.add(c);

        System.out.println(equalsObjects.size());
    }
}
