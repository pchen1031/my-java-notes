package com.atguigu06.project.team.domain;

/**
 * ClassName: NoteBook
 * Package: com.atguigu06.project.team.domain
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 21:23
 * @Version 1.0
 */
public class NoteBook implements Equipment{
    private String model;//笔记本电脑品牌
    private double price;//笔记本电脑价格

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
