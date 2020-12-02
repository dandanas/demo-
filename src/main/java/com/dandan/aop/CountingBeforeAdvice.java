package com.dandan.aop;

import org.springframework.aop.MethodBeforeAdvice;
import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.oops.MethodCounters;

import java.lang.reflect.Method;

/**
 * @date：2020/11/30
 * @author：suchao
 */
public class CountingBeforeAdvice extends MethodCounters implements MethodBeforeAdvice {

    public CountingBeforeAdvice(Address addr) {
        super(addr);
    }

    /**
     *
     * @param method 目标方法的反射对象
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        count(method);
    }

    private void count(Method method) {

    }


}
