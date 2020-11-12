package com.dandan.Thread.ThreadLocal;



import java.util.ArrayList;
import java.util.List;

/**
 * @date：2020/11/10
 * @author：suchao
 */
public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();

    //采用Lambda方式传入实现了 Supplier 函数接口的参数
    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    //public static final ThreadLocal<ThreadLocalTest> holder=new ThreadLocal<>();


    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("一枝花算不算浪漫");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}

