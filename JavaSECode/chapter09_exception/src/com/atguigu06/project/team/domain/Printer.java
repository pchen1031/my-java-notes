package com.atguigu06.project.team.domain;

/**
 * ClassName: Printer
 * Package: com.atguigu06.project.team.domain
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 21:25
 * @Version 1.0
 */
public class Printer implements Equipment{
    private String name;
    private String type;//type 表示机器的类型

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
