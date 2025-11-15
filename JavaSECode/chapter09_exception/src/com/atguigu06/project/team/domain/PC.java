package com.atguigu06.project.team.domain;

/**
 * ClassName: PC
 * Package: com.atguigu06.project.team.domain
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 21:20
 * @Version 1.0
 */
public class PC implements Equipment{
    //model 表示机器的型号
    //display 表示显示器名称
    private String model;
    private String display;

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
