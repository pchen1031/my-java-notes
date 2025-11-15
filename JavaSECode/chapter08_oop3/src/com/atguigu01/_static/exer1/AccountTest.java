package com.atguigu01._static.exer1;

/**
 * ClassName: AccountTest
 * Package: com.atguigu01._static.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/10 21:38
 * @Version 1.0
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        System.out.println(account1);
        Account account2 =new Account("20011031",2000);
        System.out.println(account2);
        System.out.println(Account.getInterestRate());
        System.out.println(Account.getMinBalance());
        System.out.println(Test.age);
        Account.age = 20;
        System.out.println(Test.age);

    }


}
