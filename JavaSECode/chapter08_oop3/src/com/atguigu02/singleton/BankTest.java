package com.atguigu02.singleton;

/**
 * ClassName: BankTesr
 * Package: com.atguigu02.singleton
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/11 15:18
 * @Version 1.0
 */
//饿汉式
public class BankTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
        System.out.println(bank1.age);
        System.out.println(bank2.age);
        System.out.println(Bank.getInstance());
    }
}

class Bank{
    int age = 18;
    private Bank(){

    }
    private static void ceshi(){
        System.out.println("这是一个测试");
    }
    private static Bank instance = new Bank();

    public static Bank getInstance() {
        return instance;
    }
}