/**
 * ClassName: A
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/14 16:19
 * @Version 1.0
 */
public class A {
    static int a = 10;
    private int c =30;
    public final int d = 50;
    public int pp = 333;
    int b;
    public static void method2(){
        System.out.println("haha");
    }
    public final void method3(){
        System.out.println("测试111");
    }
    public A(){
        System.out.println("这是A的无参构造器");
    }

    public A(int b) {
        this.b = b;
    }

    public static void method(){
        System.out.println("这是A的静态方法");
    }
}
class B extends A{
    int d = 30;
    public static void method2(){
//        System.out.println("子类的haha");
    }
    public B(){
        super(20);
    }
    public static void method(){
        System.out.println("这是A的静态方法");
    }
    {
        System.out.println("非静态代码块");
    }
    public void method3(A a){

    }
}
class Atest{
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        System.out.println(b.a);
        System.out.println(b.b);
        System.out.println(a.b);
        b.method2();
        b.method3();
        System.out.println(b.d);
        System.out.println(b.pp);
        A c = new A();
//        B d = (B)c; 会报错
        B e = new B();
        A f = (A)e;
    }
}