package web_first.day01_测试反射注解枚举.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/11 17:35
 */
public class Test11 {

    public void test01(Map<String, User> map, List<User>list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type val1 : genericParameterTypes) {
            System.out.println("#" + val1);
            if (val1 instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) val1).getActualTypeArguments();
                for (Type val2 : actualTypeArguments) {
                    System.out.println(val2);
                }
            }
        }



        method = Test11.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type value : actualTypeArguments) {
                System.out.println(value);
            }
        }
    }
}
