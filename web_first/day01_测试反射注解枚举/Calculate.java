package web_first.day01_测试反射注解枚举;

public class Calculate {

    //编写一个方法，计算两数的和
    public int add(int a, int b) {
        return a + b;
    }

    //编写一个方法，计算两数的差
    public int sub(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Calculate c = new Calculate();
        int value = c.add(1, 2);
        System.out.println(value);
        int res = c.sub(1, 2);
        System.out.println(res);
    }
}
