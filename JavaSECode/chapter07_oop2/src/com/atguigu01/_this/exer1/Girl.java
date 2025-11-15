package com.atguigu01._this.exer1;

/**
 * ClassName: Girl
 * Package: com.atguigu01._this.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 20:05
 * @Version 1.0
 */
public class Girl {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void marry(Boy boy){
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }
    public int compare(Girl girl){
        if (this.age > girl.age){
            return 1;
        } else if (this.age < age) {
            return -1;
        }else {
            return 0;
        }
    }

    public Girl() {
    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
