package com.dandan.stream;

import java.util.ArrayList;

/**
 * for最接近原生操作，所以for的性能要比stream快
 * @date：2020/11/18
 * @author：suchao
 */
public class StreamPerformanceTest {

    public static void main(String[] args) {

        ArrayList<String> arrayList =  new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(String.valueOf(i));
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
              if (arrayList.get(i).startsWith("1")){
                  System.out.println(arrayList.get(i));
              }
        }
        long end = System.currentTimeMillis();
        System.out.println("ForIterator：" + (end - start) + " ms");
        long start1 = System.currentTimeMillis();
        // 测试 Filter(过滤)
        arrayList
                .stream()
                .filter((s) -> s.startsWith("1"))
                .forEach(System.out::println);//
        long end1 = System.currentTimeMillis();
        System.out.println("StreamIterator：" + (end1 - start1) + " ms");

    }

}
