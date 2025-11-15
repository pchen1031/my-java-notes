package com.atguigu05._super.exer3;

/**
 * ClassName: AccountTest
 * Package: com.atguigu05._super.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/6 14:02
 * @Version 1.0
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account =new Account(1122,20000,0.045);
        account.withdraw(30000);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println(account.getMonthlyInterest());
    }
}
