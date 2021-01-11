package web_first.day01_测试反射注解枚举.reflection;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 15:47
 */
public class Test05 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        // 输出：
        // A类的静态代码块初始化
        // A类的无参构造初始化
        // 100

        /*
        * 1.加载到内存：会产生一个类对应的Class对象
        * 2.链接：链接结束后 m = 0
        * 3.初始化：
        *           <clinit>() {
        *                    System.out.println("A类的静态代码块初始化");
        *                    m = 356;
        *                    m = 100;
        *           }
        *
        *           m = 100
        * */
    }
}

class A {
    // 静态代码块
    static {
        System.out.println("A类静态代码块初始化");
        m = 356;
    }
    /*
    * m = 356
    * m = 100;
    * */

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}