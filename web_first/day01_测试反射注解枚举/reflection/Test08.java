package web_first.day01_测试反射注解枚举.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 16:31
 */
public class Test08 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        Class<?> c1 = Class.forName("web_first.day01_测试反射注解枚举.reflection.User");

        // 获得类的名字
        System.out.println(c1.getName());// 获得包名+类名
        System.out.println(c1.getSimpleName());// 获得类名
        System.out.println("===================================");

        // 获得类的属性
        Field[] fields = c1.getFields();// 只能得到public的属性
        fields = c1.getDeclaredFields();// 能得到全部的属性public + private
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===================================");

        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        System.out.println("===================================");

        // 获得类的方法
        Method[] methods = c1.getMethods();// 获得本类及其父类的全部public方法
        methods = c1.getDeclaredMethods();// 获得本类所有的方法 public + private
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("===================================");

        // 获得指定的方法
        // 重载
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        System.out.println("===================================");

        // 获得指定的构造器
        Constructor<?>[] constructors = c1.getConstructors();
        constructors = c1.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("===================================");

        // 获得指定的构造器
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
        System.out.println(declaredConstructor);
    }
}
