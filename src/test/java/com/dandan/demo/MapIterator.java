package com.dandan.demo;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @date：2020/10/28
 * @author：suchao
 * 遍历类
 */
public class MapIterator {

    @Test
    public void test() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }
    }

    /**
     * 只需要key 或者只需要set
     */
    @Test
    public void test02() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        //key
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        //value
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    /**
     * 通过Iterator遍历
     */
    @Test
    public void test03() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    /**
     * 通过键找值遍历，这种方式的效率比较低，因为本身从键取值是耗时的操作
     */
    @Test
    public void test04() {
        Map<String, String> map = new HashMap<>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key+":"+value);
        } }

    @Test
    public void test05() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.print("foEach模式：");
        set.forEach(integer -> {System.out.print(integer);});
        System.out.print("迭代模式：");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.print("for循环：");
        for(Integer i : set){
            System.out.println(i);
        }
    }

    @Test
    public void test06() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        System.out.print("foEach模式：");
        set.forEach(integer -> {System.out.print(integer);});
        System.out.print("迭代模式：");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.print("for循环：");
        for(Integer i : set){
            System.out.println(i);
        }
    }

    @Test
    public void test07(){

        Calendar calendarEnd=Calendar.getInstance();
        int month=calendarEnd.get(Calendar.MONTH);

        calendarEnd.set(Calendar.MONTH, month-1);

        calendarEnd.set(Calendar.DAY_OF_MONTH, calendarEnd.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endTime = calendarEnd.getTime();
        System.out.println(endTime);

        int actualMaximum = calendarEnd.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);

    }

    @Test
    public void test5() {
        TestA testA = Mockito.mock(TestA.class);
        when(testA.getNameByCode(anyInt())).thenReturn(anyInt()+1);


        System.out.println(testA.getNameByCode(1));

        Student mock1 = mock(Student.class);
        System.out.println(mock1.getAge());
        //when(mock1.getAge()).thenReturn(10);
       // System.out.println(mock1.getAge());

        mock1.setAge(10);
        System.out.println(mock1.getAge());
        Student mock = mock(Student.class);
        mock.setAge(10);
        System.out.println(mock.getAge());


        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("10");

        //verification
        verify(mockedList).add("10");
        System.out.println(mockedList.get(0));


    }


    @Test
    public void test9(){
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        //System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList).get(0);

        when(mockedList.get(anyInt())).thenReturn("element");


        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList,times(2)).get(999);



    }
}