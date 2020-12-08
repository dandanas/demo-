package com.dandan.config;


import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.*;

/**
 * @date：2020/10/26
 * @author：suchao
 * 自动装配配置类
 *
 * 自动装配：
 *          Spring利用依赖注入（DI）完成IOC容器中各个组件的依赖关系赋值
 * 1.Autowired 自动注入：
 *         1.默认优先按照类型来去容器中找对应的组件，applicationContexts.getBean(BookController.class);找到就赋值
 *         2.如果找到多个相同类型的组件，将属性名称作为属性id去容器中查找
 *         3.@Qualifier("bookService")使用@Qualifier指定需要装配的组件id
 *             BookController{
 *             @Autowired
 *             BookService bookService;
 *             }
 *          4.使用Autowired(required = false),找不到组件也不报错
 *          5.@Primary 让Spring在自动装配时使用首选的bean
 * 2.Spring 还支持使用@Resource和@Inject(java规范注解）
 *          1.可以和Autowired一样实现自动装配，默认是按照组件名进行装配的；没有支持Autowired(required = false),@Primary
 *          2.@Inject 需要导包，和Autowired 功能一样，没有支持Autowired(required = false)
 * 3.@Autowired 标注在构造器（构造器要用的组件，都是从容器中获取，如果组件只有一个有参构造器，@Autowired可以省略），方法（@Bean+方法参数，参数从容器中获取，默认不写Autowired），参数上
 *
 */

@Configuration
@ComponentScan({"com.dandan.controller","com.dandan.service","com.dandan.logAop"})
@EnableAspectJAutoProxy
public class MainConfigOfAutowired {


//    @Test
//    public void test01(){
//        AnnotationConfigApplicationContext applicationContexts = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookController bean = applicationContexts.getBean(BookController.class);
//        bean.print();
//       boolean b = applicationContexts.containsBean("bookService");
//        System.out.println(b);
//        BookService service = applicationContexts.getBean(BookService.class);
//        System.out.println(service);
//        applicationContexts.close();
//    }




}
