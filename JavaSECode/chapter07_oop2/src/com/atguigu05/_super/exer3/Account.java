package com.atguigu05._super.exer3;

/**
 * ClassName: Account
 * Package: com.atguigu05._super.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/6 13:34
 * @Version 1.0
 */
public class Account {
    private int id;
    protected double banlance;
    private double annualInterstRate;
    public Account(){}

    public Account(int id, double banlance, double annualInterstRate) {
        this.id = id;
        this.banlance = banlance;
        this.annualInterstRate = annualInterstRate;//年利率
    }

    public int getId() {
        return id;
    }

    public double getBanlance() {
        return banlance;
    }

    public double getAnnualInterstRate() {
        return annualInterstRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }

    public void setAnnualInterstRate(double annualInterstRate) {
        this.annualInterstRate = annualInterstRate;
    }
    public double getMonthlyInterest(){
        return annualInterstRate / 12;
    }
    public void withdraw(double amount){
        if (amount > banlance){
            System.out.println("余额不足");
        }else {
           banlance -= amount;
        }
    }
    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("输入数值非法");
        }else {
            System.out.println("存款成功");
            System.out.println("您的账户余额为:" + (banlance + amount));
        }
    }
}
