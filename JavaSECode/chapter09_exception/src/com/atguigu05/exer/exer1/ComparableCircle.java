package com.atguigu05.exer.exer1;

/**
 * ClassName: ComparableCircle
 * Package: com.atguigu08._interface.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/23 16:31
 * @Version 1.0
 */
public class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if (o instanceof ComparableCircle){
            ComparableCircle comparableCircle = (ComparableCircle) o;
//            if (this.getRadius() > comparableCircle.getRadius()){
//                return 1;
//            } else if (this.getRadius() < comparableCircle.getRadius()) {
//                return -1;
//            }else {
//                return 0;
//            }
            return Double.compare(this.getRadius(),comparableCircle.getRadius());
        }else {
            return  2;
        }

    }
}
