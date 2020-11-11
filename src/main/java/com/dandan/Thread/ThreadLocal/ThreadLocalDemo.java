package com.dandan.Thread.ThreadLocal;

import java.lang.reflect.Field;

/**
 * 既然是Map结构，那么ThreadLocalMap当然也要实现自己的hash算法来解决散列表数组冲突问题。
 *
 * int i = key.threadLocalHashCode & (len-1);
 * ThreadLocalMap中hash算法很简单，这里i就是当前key在散列表中对应的数组下标位置。
 *
 * 这里最关键的就是threadLocalHashCode值的计算，ThreadLocal中有一个属性为HASH_INCREMENT = 0x61c88647
 * 每当创建一个ThreadLocal对象，这个ThreadLocal.nextHashCode 这个值就会增长 0x61c88647
 * 这个值很特殊，它是斐波那契数 也叫 黄金分割数。hash增量为 这个数字，带来的好处就是 hash 分布非常均匀。
 */
public class ThreadLocalDemo {

   private static final int HASH_INCREMENT=0x61c88647;

    public static void main(String[] args) {
        int hashCode = 0;
        for (int i = 0; i <16 ; i++) {
            hashCode = i*HASH_INCREMENT+HASH_INCREMENT;
            int bucket = hashCode & 15;
            System.out.println(i+"在数桶中的位置"+bucket);
            //可以看到产生的哈希码分布很均匀
        }
    }
}

