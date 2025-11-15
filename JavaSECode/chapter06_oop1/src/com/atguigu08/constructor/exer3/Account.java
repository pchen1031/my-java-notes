package com.atguigu08.constructor.exer3;

/**
 * ClassName: Account
 * Package: com.atguigu08.constructor.exer3
 * Description:
 * 1、写一个名为Account的类模拟账户。该类的属性和方法如下图所示。
 * 该类包括的属性：账号id，余额balance，年利率annualInterestRate；
 * 包含的构造器：自定义
 * 包含的方法：访问器方法（getter和setter方法），取款方法withdraw()，存款方法deposit()。
 * 提示：在提款方法withdraw中，需要判断用户余额是否能够满足提款数额的要求，如果不能，应给出提示。
 *
 * @Author 彭晨
 * @Create 2025/3/1 21:28
 * @Version 1.0
 */
public class Account {
    private String id;
    private double balance;
    private double annualInterestRate;

    public void setId(String i) {
        id = i;
    }

    public String getId() {
        return id;
    }

    public void setBalance(double b) {
        balance = b;
    }

    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double a) {
        annualInterestRate = a;
    }

    public double setAnnualInterestRate() {
        return annualInterestRate;
    }
    public Account(String i,double b,double a){
        id = i;
        balance = b;
        annualInterestRate = a;
    }
    public void withdraw(double amount){
        if (amount > 0 && amount < balance){
            System.out.println("成功取出：" + amount);
        }else {
            System.out.println("取款失败");
        }
    }
    public void deposit(double amount){
        if (amount > 0){
            System.out.println("存款成功:" + amount);
        }else {
            System.out.println("存款失败");
        }
    }
}
