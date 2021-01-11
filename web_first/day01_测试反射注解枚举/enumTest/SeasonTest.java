package web_first.day01_测试反射注解枚举.enumTest;

/**
 * 枚举类的测试——季节枚举
 */
public class SeasonTest {

    public static void main(String[] args) {

        //测试枚举类
        Season spring = Season.SPRING;
        spring.toString();
    }
}

//自定义一个季节的枚举类
class Season {

    //定义私有属性
    private final String seasonName;
    private final String seasonDesc;

    //定义私有的构造器,并给对象属性赋初值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //提供当前枚举类的所有对象
    public static final Season SPRING = new Season( "春天", "万物复苏");
    public static final Season SUMMER = new Season( "夏天", "酷暑炎热");
    public static final Season AUTUMN = new Season( "秋天", "秋风习习");
    public static final Season WINTER = new Season( "冬天", "冰天雪地");

    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    // 提供toString方法
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}