package com.atguigu05.field;

/**
 * ClassName: FileTest
 * Package: com.atguigu05.field
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/13 15:28
 * @Version 1.0
 */
public class FileTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.id);
    }
}
class Order{
    int id = 1;
    {
        id = 2;
    }
    public Order(){
        id = 3;
    }
}