package com.atguigu01._this.exer2;

/**
 * ClassName: Customer
 * Package: com.atguigu01._this.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 21:24
 * @Version 1.0
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
