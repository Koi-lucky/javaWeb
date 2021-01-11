package web_first.day01_测试反射注解枚举.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 17:04
 */
// 动态的创建对象，通过反射
public class Test09 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获得Class对象
        Class<?> c1 = Class.forName("web_first.day01_测试反射注解枚举.reflection.User");

        // 构造一个对象
        User user = (User) c1.newInstance();// 本质是调用了类的无参构造
        System.out.println(user);

        // 通过构造器创建对象
        Constructor<?> constructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
        User user2 = (User) constructor.newInstance(10, "张三", 25);
        System.out.println(user2);

        // 通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke ：激活的意思
        // 参数为：（对象，“方法的值”）
        setName.invoke(user3, "Java");
        System.out.println(user3.getName());
        System.out.println("=============================");

        // 通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        // 不能直接操作私有的属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);// true是关闭安全检测
        name.set(user4, "C#和java");
        System.out.println(user4.getName());
    }
}
