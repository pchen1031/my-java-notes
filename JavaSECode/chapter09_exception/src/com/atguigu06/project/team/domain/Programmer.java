package com.atguigu06.project.team.domain;

import com.atguigu06.project.team.service.Status;

/**
 * ClassName: Programmer
 * Package: com.atguigu06.project.team.domain
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 21:35
 * @Version 1.0
 */
public class Programmer extends Employee{
    private int memberId;//开发团队中的tID
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t" + equipment.getDescription();
    }

}
