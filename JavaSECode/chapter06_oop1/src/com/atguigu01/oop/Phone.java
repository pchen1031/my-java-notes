package com.atguigu01.oop;

/**
 * @author 尚硅谷-宋红康
 * @create 16:26
 */
public class Phone {
    String name;
    double price;
    public void  call(){
        System.out.println("打电话");
    }
    public void sendMessage(String xinxi){
        System.out.println("发送的信息是:" + xinxi);
    }
    public void playGame(){
        System.out.println("手机可以玩游戏");
    }



}
