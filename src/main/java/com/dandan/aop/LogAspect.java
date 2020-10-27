package com.dandan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @date：2020/10/27
 * @author：suchao
 * 日志打印切面类
 */
@Aspect
public class LogAspect {

    /**
     *抽取公共的切入点表达式
     *
     */
    @Pointcut("execution(public int com.dandan.aop.MathCalculator.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取方法名和参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"除法运行。。参数列表{"+ Arrays.asList(args)+"} ");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    @AfterReturning(value = "pointCut())",returning = "result")//return封装返回结果
    public void logReturn(JoinPoint joinPoint,Object result){//JoinPoint放在参数首位
        System.out.println(joinPoint.getSignature().getName()+"除法正常返回。。。运行结果：{"+result+"} ");
    }

    @AfterThrowing(value = "pointCut()",throwing ="exception" )
    public void logException(Exception exception){
        System.out.println("除法发生异常。。。运行异常：{"+exception+"}  ");
    }

}
