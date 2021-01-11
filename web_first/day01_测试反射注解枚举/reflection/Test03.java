package web_first.day01_测试反射注解枚举.reflection;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 15:24
 */
// 测试Class类的获取方式
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是：" + person.name);

        // 方式一：通过对象获得
        Class<? extends Person> c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 方式二：通过Class类的静态方法forName()获取
        Class<?> c2 = Class.forName("web_first.day01_测试反射注解枚举.reflection.Student");
        System.out.println(c2.hashCode());

        // 方式三：通过类的class属性获取
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

        // 方式四：内置基本数据类型可以直接使用类名.Type
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);// int

        // 获得父类类型
        Class<?> c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person {
    int id;
    String name;
    int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "教师";
    }
}