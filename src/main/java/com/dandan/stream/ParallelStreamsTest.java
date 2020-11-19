package com.dandan.stream;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @date：2020/11/18
 * @author：suchao
 */
public class ParallelStreamsTest {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }


        ParallelStreamsTest parallelStreamsTest = new ParallelStreamsTest();
        parallelStreamsTest.sortT(values);
        parallelStreamsTest.paSortT(values);


    }

    private void sortT(List<String> list) {
        //非串行排序
        long t0 = System.nanoTime();

        long count = list.stream().filter(x -> x.compareTo("Z") > 0).count();

        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    private void paSortT(List<String> list) {
        //串行排序
        long t0 = System.nanoTime();

        long count = list.parallelStream().filter(x -> x.compareTo("Z") > 0).count();

        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

}
