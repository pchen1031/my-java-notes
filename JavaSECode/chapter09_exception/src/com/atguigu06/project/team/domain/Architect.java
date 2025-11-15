package com.atguigu06.project.team.domain;

/**
 * ClassName: Architect
 * Package: com.atguigu06.project.team.domain
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 22:05
 * @Version 1.0
 */
public class Architect extends Designer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  getDetails() + "\t架构师\t" + getStatus() + "\t" +
                getBonus() + "\t" + getStock() + getEquipment().getDescription();
    }
}
