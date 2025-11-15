package com.atguigu05._super.exer3;

/**
 * ClassName: CheckAccount
 * Package: com.atguigu05._super.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/6 15:03
 * @Version 1.0
 */
public class CheckAccount extends Account{
    private double overDraft;

    public CheckAccount(int id, double banlance, double annualInterstRate, double overDraft) {
        super(id, banlance, annualInterstRate);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBanlance()){
            super.withdraw(amount);
        } else if (amount < getBanlance() + overDraft) {
            overDraft -= amount - getBanlance();
            super.withdraw(getBanlance());
        }else {
            System.out.println("超过可透支额度");
        }
    }
}
