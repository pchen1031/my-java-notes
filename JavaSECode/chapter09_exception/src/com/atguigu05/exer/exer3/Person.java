package com.atguigu05.exer.exer3;

/**
 * ClassName: Person
 * Package: com.atguigu05.exer.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/10 17:11
 * @Version 1.0
 */
public class Person {
    private String name;
    private int lifeValue;

    public Person() {
    }

    public Person(String name, int lifeValue) {
        setName(name);
        setLifeValue(lifeValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if (lifeValue < 0){
            throw new NoLifeValueException("生命值不能为负数");
        }else{
            this.lifeValue = lifeValue;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }
}
