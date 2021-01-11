package web_first.day01_测试反射注解枚举.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 17:22
 */
// 分析性能问题
public class Test10 {

    // 普通方法调用
    public static void test01() {
        User user = new User();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方法调用耗时为：" + (startTime - endTime) + "ms");
    }
    // 反射方法调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("反射方式调用方法耗时为：" + (startTime - endTime) + "ms");
    }
    // 关闭检测的反射方法调用
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("关闭检测的反射方式调用方法耗时为：" + (startTime - endTime) + "ms");
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
