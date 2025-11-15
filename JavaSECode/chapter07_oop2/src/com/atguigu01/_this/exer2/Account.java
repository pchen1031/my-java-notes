package com.atguigu01._this.exer2;

/**
 * ClassName: Account
 * Package: com.atguigu01._this.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 21:21
 * @Version 1.0
 */
public class Account {
    private  double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    //存钱
    public void deposit(double amt){
        if (amt > 0){
            balance += amt;
            System.out.println("存钱成功" + amt);
        }
    }
    //取钱
    public void withdraw(double amt){
        if (balance >= amt && amt >0){
            balance -= amt;
            System.out.println("取钱成功" + amt);
        }else {
            System.out.println("取款数额有误或余额不足");
        }
    }
}
