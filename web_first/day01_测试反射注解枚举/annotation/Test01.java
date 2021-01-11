package web_first.day01_测试反射注解枚举.annotation;

import java.lang.annotation.*;


/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 9:18
 */

public class Test01 {

    // 注解可以显示赋值，如果没有默认值，就必须要显示赋值
    @MyAnnotation2(name = "清华", age = 1)
    public void test01() {

    }
}

/**
 * @author Chen
 */ // 定义一个注解
// Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.ANNOTATION_TYPE})

//Retention 表示我们的注解在什么地方有效
// runtime > class > source
@Retention(value = RetentionPolicy.RUNTIME)

// @Inherited 表示子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}


/**
 * @author Chen
 */
@Target(value = {ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数：参数类型 + 参数名（）
    String name() default "";
    int age();
    int id() default -1;// 如果默认值为-1，代表不存在

    String[] schools() default {"北大", "清华大学"};

    // 如果注解里面只有一个参数，参数名默认为value
    // String value();
}