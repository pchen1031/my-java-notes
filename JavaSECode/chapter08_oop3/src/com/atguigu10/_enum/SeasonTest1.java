package com.atguigu10._enum;

/**
 * ClassName: SeasonTest1
 * Package: com.atguigu10._enum
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/27 20:10
 * @Version 1.0
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        // 1.toString() 若没有重写toString()方法则打印对象名
        System.out.println(Season1.SPRING);
        // 2.name() 打印对象名
        System.out.println(Season1.SPRING.name());
        // 3.vlaues() 把枚举类里所有的对象按照声明顺序的先后存在数组里
        Season1[] season1s = Season1.values();
        for (int i = 0; i < season1s.length; i++) {
            System.out.println(season1s[i]);
        }
        //4. valueOf(String objName):返回当前枚举类中名称为objName的枚举类对象。
        //如果枚举类中不存在objName名称的对象，则报错。
        String objName = "WINTER";
//        objName = "WINTER1";
        Season1 season1 = Season1.valueOf(objName);
        System.out.println(season1);

        //5.ordinal()
        System.out.println(Season1.AUTUMN.ordinal());//打印这个对象是第几个声明的对象

        //通过枚举类的对象调用重写接口中的方法
        Season1.SUMMER.show();
    }
}
//jdk5.0定义枚举类
interface Info{
    void show();
}
enum Season1 implements Info{
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","白雪皑皑");
    final String seasonName;
    final String seasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }



    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
