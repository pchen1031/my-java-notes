package com.atguigu05._super.exer3;

/**
 * ClassName: CheckAccountTest
 * Package: com.atguigu05._super.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/6 15:31
 * @Version 1.0
 */
public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122,20000,0.045,5000);
        checkAccount.withdraw(5000);
        System.out.println("您的账户余额：" + checkAccount.getBanlance());
        System.out.println("您的可透支额：" + checkAccount.getOverDraft());

        checkAccount.withdraw(18000);
        System.out.println("您的账户余额：" + checkAccount.getBanlance());
        System.out.println("您的可透支额：" + checkAccount.getOverDraft());

        checkAccount.withdraw(3000);
        System.out.println("您的账户余额：" + checkAccount.getBanlance());
        System.out.println("您的可透支额：" + checkAccount.getOverDraft());
    }
}
