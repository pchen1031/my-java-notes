package com.atguigu01._this.exer2;

/**
 * ClassName: Bank
 * Package: com.atguigu01._this.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 21:24
 * @Version 1.0
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank(){
        customers =new Customer[10];
    }
    public void addCustomer(String f,String l){
        Customer cust = new Customer(f,l);
        customers[numberOfCustomer++] = cust;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
    public Customer getCustomer(int index){
        if (index < 0 || index >= numberOfCustomer){
            return null;
        }else {
            return customers[index];
        }
    }
}
