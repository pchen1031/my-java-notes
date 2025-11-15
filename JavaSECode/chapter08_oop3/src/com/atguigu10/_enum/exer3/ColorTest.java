package com.atguigu10._enum.exer3;

/**
 * ClassName: ColorTest
 * Package: com.atguigu10._enum.exer3
 * Description:
 * 红：(255,0,0)
 * 橙：(255,128,0)
 * 黄：(255,255,0)
 * 绿：(0,255,0)
 * 青：(0,255,255)
 * 蓝：(0,0,255)
 * 紫：(128,0,255)
 * @Author 彭晨
 * @Create 2025/3/28 17:06
 * @Version 1.0
 */
public class ColorTest {
    public static void main(String[] args) {
        System.out.println(Color.RED.toString());
    }
}
enum Color{
    RED(255,0,0,"红色"),
    ORANGE(255,0,0,"橙色"),
    YELLO(255,0,0,"黄色"),
    GREEN(255,0,0,"绿色"),
    CYAN(255,0,0,"青色"),
    BLUE(255,0,0,"蓝色"),
    PURPLE(255,0,0,"红色");
    private final int red;
    private final int green;
    private final int blue;
    private final String description;

    Color(int red, int green, int blue, String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + this.red + "," + this.green + "," + this.blue + ")" + "-->" + this.description;
    }
}