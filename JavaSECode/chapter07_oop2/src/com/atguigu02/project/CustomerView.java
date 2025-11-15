package com.atguigu02.project;

/**
 * ClassName: CustomerView
 * Package: com.atguigu02.project
 * Description:
 *      CustomerView为主模块，负责菜单的显示和处理用户操作
 * @Author 彭晨
 * @Create 2025/3/3 20:59
 * @Version 1.0
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out
                    .println("\n-------------------拼电商客户管理系统-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            char key =  CMUtility.readMenuSelection();
        }
    }
    private void addNewCustomer(){

    }
    private void modifyCustomer(){

    }
    private void deleteCustomer(){

    }
    private void listAllCustomers(){

    }
    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

}
