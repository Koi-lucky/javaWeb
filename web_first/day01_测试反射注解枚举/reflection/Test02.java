package web_first.day01_测试反射注解枚举.reflection;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 9:35
 */
public class Test02 extends Object {

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的Class对象
        Class<?> c1 = Class.forName("web_first.day01_测试反射注解枚举.reflection.User");
        System.out.println(c1);

        // 一个类在内存中中只有一个Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中
        Class<?> c2 = Class.forName("web_first.day01_测试反射注解枚举.reflection.User");
        Class<?> c3 = Class.forName("web_first.day01_测试反射注解枚举.reflection.User");
        Class<?> c4 = Class.forName("web_first.day01_测试反射注解枚举.reflection.User");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}


// 定义实体类
class User {
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}