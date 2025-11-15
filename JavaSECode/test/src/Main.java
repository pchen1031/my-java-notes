/**
 * ClassName: Parent
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/15 22:32
 * @Version 1.0
 */
class Parent {
    String name = "Parent";
    int age = 20;
    public static void method(){
        System.out.println("这是父类的方法");
    }
    public void method2(){
        System.out.println("这是父类方法");
    }

}

class Child extends Parent {
    int age = 18;
    String name = "Child";  // 隐藏父类的 name 变量
    public static void method(){
        System.out.println("这是子类的方法");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.name);    // 输出 "Parent"（父类变量）
        obj.method();
        System.out.println(((Child) obj).name); // 输出 "Child"（子类变量）
        System.out.println(obj.age);

    }
}
