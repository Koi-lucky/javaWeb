package web_first.day01_测试反射注解枚举.reflection;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 16:10
 */
public class Test06 {

    static {
        System.out.println("Main类型被加载！！");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.主动加载
        //Son son = new Son();

        // 反射也会产生主动引用
        //Class.forName("web_first.day01_测试反射注解枚举.reflection.Son");

        // 不会产生类的引用的方法
        //System.out.println(Son.b);

        //Son[] arr = new Son[5];

        System.out.println(Son.M);

    }
}

class Father {

    static int b = 2;

    static {
        System.out.println("父类被加载~~");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}