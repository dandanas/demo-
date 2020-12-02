package com.dandan.demo;

import com.dandan.DemoApplication;
import com.dandan.controller.WelcomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @date：2020/12/2
 * @author：suchao
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class TimeConsumingMonitorTest {
    @Autowired
    private TestClassBaseMonitor testClassBaseMonitor;

    @Autowired
    private TestMethodBaseMonitor testMethodBaseMonitor;

    @Autowired
    private Review review;

    @Autowired
    private WelcomeController welcomeController;


    @Test
    public void testClass() throws InterruptedException {
        testClassBaseMonitor.testTimeConsuming("run");
        testClassBaseMonitor.testTimeConsumingWithAnno("haha", "heyhey");
        testClassBaseMonitor.testPackagePrivateMethod("you know");
    }

    @Test
    public void testMethod(){
        testMethodBaseMonitor.testTimeConsuming("run run run！", "here we go");
        testMethodBaseMonitor.testDebugLevel("debug test", "sourceClass");
        testMethodBaseMonitor.hh("a","b");
    }

    @Test
    public void testReview(){
        //welcomeController.printDate();
    }
}