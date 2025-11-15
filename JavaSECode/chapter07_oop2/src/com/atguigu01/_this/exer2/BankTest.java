package com.atguigu01._this.exer2;

/**
 * ClassName: BankTest
 * Package: com.atguigu01._this.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 22:21
 * @Version 1.0
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("操","曹");
        bank.addCustomer("备","刘");
        System.out.println(bank);
        System.out.println(bank.getCustomer(0));
    }
}
