package com.dandan.reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @date：2020/10/29
 * @author：suchao
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2 由系统类加载器加载自定义的类

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@5e9f23b4 扩展类加载器

        ClassLoader parent = classLoader1.getParent();
        System.out.println(parent); //null 获取不到引导类加载器，引导类加载器主要加载Java的核心类库
    }

    /**
     * 用反射加载配置类
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("test.properties");
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        System.out.println(user);

    }
}
