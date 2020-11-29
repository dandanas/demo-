package com.dandan.Patterns.structural.adapterPatterns;

/**
 * @date：2020/11/20
 * @author：suchao
 * 适配器模式：将一个接口转换为客户需要的另外一个接口，使那些不兼容的类能够一起工作
 *
 * 对象适配器模式包含如下角色
 * Target（目标抽象类）：定义客户所需接口，可以是接口、抽象类或者具体类
 * Adapter（适配器）：继承实现Target关联Adaptee，完成接口的转换
 * Adaptee（适配者）：定义存在的接口被适配器适配
 * 对象适配器的核心是适配器继承或者实现目标类委派适配者（关联关系）完成任务
 * 一个适配器能够适配多个适配者
 * 类适配器角色与对象适配器角色一样，区别是类适配器继承适配者
 *
 * 适配器类
 */
public class AdapterPatterns implements Target {

    private AdapteeA adapteeA = new AdapteeA();
    private AdapteeB adapteeB = new AdapteeB();

    @Override
    public void play(String flag) {
        if ("a".equals(flag)) {
            adapteeA.play();
        } else if ("b".equals(flag)) {
            adapteeB.play();
        }
    }
}
