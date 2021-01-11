package web_first.day01_测试反射注解枚举.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 17:46
 */
// 反射操作注解
public class Test12 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class<?> c1 = Class.forName("web_first.day01_测试反射注解枚举.reflection.Student2");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解的value值
        TableAnnotation tableAnnotation = c1.getAnnotation(TableAnnotation.class);
        String value = tableAnnotation.value();
        System.out.println(value);

        // 获得类指定的注解
        Field f = c1.getDeclaredField("id");
        FieldAnnotation annotation = f.getAnnotation(FieldAnnotation.class);
        System.out.println(annotation.type());
        System.out.println(annotation.length());
        System.out.println(annotation.columnName());
    }
}

@TableAnnotation(value = "db_student")
class Student2 {

    @FieldAnnotation(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldAnnotation(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldAnnotation(columnName = "db_name", type = "varchar", length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

// 定义注解
// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableAnnotation {
    String value();
}
// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldAnnotation {
    String columnName();
    String type();
    int length();
}