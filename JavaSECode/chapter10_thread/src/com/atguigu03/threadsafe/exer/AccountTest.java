package com.atguigu03.threadsafe.exer;

/**
 * ClassName: AccountTest
 * Package: com.atguigu03.threadsafe.exer
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/19 20:34
 * @Version 1.0
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account();
        Customer customer1 = new Customer(acc,"储户1");
        Customer customer2 = new Customer(acc,"储户2");

        customer1.start();
        customer2.start();
    }
}
class Account{
    private double balance;
    public void deposit(double amt){
        if (amt > 0){
            balance += amt;
        }
        System.out.println(balance);
    }
}
class Customer extends Thread{
    Account account;
    public Customer(Account account,String name){
        super(name);
        this.account = account;
    }
    @Override
    public void run() {
        synchronized (Customer.class){
            for (int i = 0; i < 3; i++) {
                account.deposit(1000);
            }

        }
    }
}
