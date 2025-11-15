package com.atguigu07.encapsulation.exer3;

/**
 * ClassName: Employee
 * Package: com.atguigu07.encapsulation.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/1 16:30
 * @Version 1.0
 */
//- 包含属性：姓名、性别、年龄、电话，属性私有化
//
//- 提供get/set方法
//
//- 提供String getInfo()方法
public class Employee {
    private String name;
    private char gender;
    private int age;
    private String phoneNumber;

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setGender(char g){
        gender = g;
    }
    public char getGender(){
        return gender;
    }

    public void setAge(int a) {
        age = a;
    }
    public int getAge() {
        return age;
    }

    public void setPhoneNumber(String pN) {
        phoneNumber = pN;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getInfo(){
        return name + "\t" + gender + "\t" + age + "\t" + phoneNumber;
    }
}
