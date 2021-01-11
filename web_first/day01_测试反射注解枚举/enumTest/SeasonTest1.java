package web_first.day01_测试反射注解枚举.enumTest;

/**
 * 枚举类的测试——季节枚举
 */
public class SeasonTest1 {

    public static void main(String[] args) {

        //测试枚举类
        Season1 summer = Season1.SUMMER;

        //测试toString方法
        summer.toString();//默认的toString方法是输出对象名称
        //测试values方法
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        // 测试valueOf方法
        Season1 values1 = Season1.valueOf("WINTER1");//如果所输入的对象名称找不到，则会报错，不会返回null
        System.out.println(values1);
    }
}

//自定义一个季节的枚举类
enum  Season1 implements info{

    //提供当前枚举类的所有对象多个对象之间用“,”隔开，最后一个对象用“;”结尾
    SPRING( "春天", "万物复苏") {//枚举类实现接口
        @Override
        public void show() {
            System.out.println("春天在哪里~~");
        }
    },
    SUMMER( "夏天", "酷暑炎热") {
        @Override
        public void show() {
            System.out.println("夏天夏天悄悄过去~~~");
        }
    },
    AUTUMN( "秋天", "秋风习习") {
        @Override
        public void show() {
            System.out.println("秋天一去不回来~~");
        }
    },
    WINTER( "冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季！！");
        }
    };

    //定义私有属性
    private final String seasonName;
    private final String seasonDesc;

    //定义私有的构造器,并给对象属性赋初值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }



    // 提供toString方法
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

//    //枚举类实现接口（方法一）
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");//不管那个对象调用，都只会出现这一句话
//    }

    //枚举类实现接口（方法二）
    //在每个对象定义的后面添一对大括号，里面写接口要实现的功能
}

interface info {
    void show();
}