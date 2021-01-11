package web_first.day01_测试反射注解枚举.reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 15:38
 */
public class Test04 {

    public static void main(String[] args) {
        Class<Object> c1 = Object.class;// 类
        Class<Comparable> c2 = Comparable.class;// 接口
        Class<String[]> c3 = String[].class;// 一维数组
        Class<int[][]> c4 = int[][].class;// 二维数组
        Class<Annotation> c5 = Annotation.class;// 注解
        Class<ElementType> c6 = ElementType.class;// 枚举
        Class<Integer> c7 = Integer.class;// 基本数据类型
        Class<Void> c8 = void.class;// void
        Class<Class> c9 = Class.class;// class

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        // 只要元素数据类型与维度一样，就是同一个Class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());

    }
}
