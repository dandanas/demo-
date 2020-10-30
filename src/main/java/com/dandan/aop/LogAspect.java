package com.dandan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @date：2020/10/27
 * @author：suchao
 * 日志打印切面类
 */
@Aspect
@Component
public class LogAspect {

    /**
     *抽取公共的切入点表达式
     *
     */
    @Pointcut("execution(public int com.dandan.aop.MathCalculator.*(..))")
    public void pointCut(){

    }

    //@Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取方法名和参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"除法运行。。参数列表{"+ Arrays.asList(args)+"} ");
    }

    //@After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    //@AfterReturning(value = "pointCut()",returning = "result")//return封装返回结果
    public void logReturn(JoinPoint joinPoint,Object result){//JoinPoint放在参数首位
        System.out.println(joinPoint.getSignature().getName()+"除法正常返回。。。运行结果：{"+result+"} ");
    }

    //@AfterThrowing(value = "pointCut()",throwing ="exception" )
    public void logException(Exception exception){
        System.out.println("除法发生异常。。。运行异常：{"+exception+"}  ");
    }

    /**
     * 环绕通知是Spring中最强大的通知，手写版的动态代理
     * 环绕通知中有一个参数
     */
    @Around("pointCut()")
    public Object myAround(ProceedingJoinPoint pdp) throws Throwable {

        Object[] args = pdp.getArgs();

        //利用反射调用目标方法即可,就是method.invoke()
        Object proceed = null;
        try {
            System.out.println(""+pdp.getSignature().getName()+"除法运行。。参数列表{"+ Arrays.asList(args)+"} ");
            proceed = pdp.proceed(args);
            System.out.println(pdp.getSignature().getName()+"除法正常返回。。。运行结果：{"+proceed+"} ");
        } catch (Throwable throwable) {
            System.out.println("除法发生异常。。。运行异常：{"+throwable+"}  ");
            throwable.printStackTrace();
        } finally {
            System.out.println("除法结束");
        }


        System.out.println("环绕 ");

        //调用方法后的返回值
        return proceed;

    }

}
