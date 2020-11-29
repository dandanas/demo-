package com.dandan.Patterns.structural.adapterPatterns;

/**
 * @date：2020/11/20
 * @author：suchao
 */
public interface Client {

    public static void main(String[] args) {
        AdapterPatterns adapterPatterns = new AdapterPatterns();
        adapterPatterns.play("a");
        adapterPatterns.play("b");
    }
}
