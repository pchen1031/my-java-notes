

package com.atguigu03.field_method.method;

/**
 * @author 尚硅谷-宋红康
 * @create 19:01
 */
public class MethodTest {
    public static void main(String[] args) {
        Person p1 =new Person();
        p1.eat();
        String peng = p1.interests("haha");
        System.out.println(peng);
//        System.out.println(p1.interests("haha"));//输出abc
    }
}
class Person{
    String name;
    char gender;
    int age;

    public void eat(){
        System.out.println("人吃饭");
        sleep(8);
    }
    public void sleep(int hour){
        System.out.println("人一天至少睡" + hour + "小时");
    }
    public String interests(String hoppy){
//        String info = "我的爱好是" + hoppy;
//        System.out.println(info);
//        return info;
        return "abc";
    }
    public int getAge(){
        return age;
    }

}

