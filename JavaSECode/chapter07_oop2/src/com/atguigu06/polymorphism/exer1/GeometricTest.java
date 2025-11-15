package com.atguigu06.polymorphism.exer1;

/**
 * ClassName: GeometricTest
 * Package: com.atguigu06.polymorphism.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/7 21:47
 * @Version 1.0
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest geometricTest =new GeometricTest();
        geometricTest.displayGeometricObject(new Circle("绿色",12,3));
        geometricTest.displayGeometricObject(new Circle("绿色",12,2.3));
        geometricTest.displayGeometricObject(new Circle("绿色",12,3.3));
        System.out.println(3.14*3.3*3.3);
        System.out.println(geometricTest.equalsArea(new Circle("绿色", 12, 3), new Circle("绿色", 12, 3.3)));
    }
    public boolean equalsArea(GeometricObject a,GeometricObject b){
        return a.findArea() == b.findArea();
    }
    public void displayGeometricObject(GeometricObject a){
        System.out.println(a.findArea());
    }
}
