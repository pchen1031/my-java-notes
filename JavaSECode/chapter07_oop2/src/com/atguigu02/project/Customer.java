package com.atguigu02.project;

/**
 * ClassName: Customer
 * Package: com.atguigu02.project
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/3 15:51
 * @Version 1.0
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String eamil;

    public Customer() {
    }

    public Customer(String name, char gender, int age, String phone, String eamil) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.eamil = eamil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }
}
