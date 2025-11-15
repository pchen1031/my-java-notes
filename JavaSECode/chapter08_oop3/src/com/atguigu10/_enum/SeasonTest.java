package com.atguigu10._enum;

/**
 * ClassName: SeasonTest
 * Package: com.atguigu10._enum
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/26 17:07
 * @Version 1.0
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SUMMER.getSeasonName());
        System.out.println(Season.SPRING.toString());
    }
}
//jdk5.0以前的枚举类定义方法
class Season{
    final String seasonName;
    final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public final static Season SPRING = new Season("春天","春暖花开");
    public final static Season SUMMER = new Season("夏天","夏日炎炎");
    public final static Season AUTUMN = new Season("秋天","秋高气爽");
    public final static Season WINTER = new Season("冬天","白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

}
