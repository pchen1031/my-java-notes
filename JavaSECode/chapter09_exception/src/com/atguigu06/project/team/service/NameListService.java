package com.atguigu06.project.team.service;

import com.atguigu06.project.team.domain.*;

/**
 * ClassName: NameListService
 * Package: com.atguigu06.project.team.service
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 22:08
 * @Version 1.0
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        //在构造器中给数组赋值
        employees = new Employee[Data.EMPLOYEES.length];
        Equipment equipment;
        double bonus;
        int stock;
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            switch (type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    private Equipment creatEquipment(int index){
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (type){
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                int price = Integer.parseInt(Data.EQUIPMENTS[index][2]);
                return new NoteBook(Data.EQUIPMENTS[index][1],price);
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId()){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }

}
