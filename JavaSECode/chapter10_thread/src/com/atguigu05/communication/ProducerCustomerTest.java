package com.atguigu05.communication;

/**
 * ClassName: ProducerCustomerTest
 * Package: com.atguigu05.communication
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/20 20:48
 * @Version 1.0
 */
public class ProducerCustomerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Customer customer = new Customer(clerk);
        Producer producer = new Producer(clerk);
        customer.setName("消费者");
        producer.setName("生产者");
        customer.start();
        producer.start();
    }
}
class Clerk{//店员
    private int number = 0;                //因为生产者和消费者要对同一份数据进行操作，所以想到了给他们两个传入同一个对象。操作数据
    public synchronized void addProduct(){
        if (number >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            number++;
            System.out.println(Thread.currentThread().getName() + "生产了第" + number + "个产品");
            notify();
        }
    }
    public synchronized void minusProduct(){
        if (number <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "消费了第" + number + "个产品");
            number--;
            notify();
        }

    }
}
class Producer extends Thread{
    Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println("生产者开始生产");
            clerk.addProduct();
        }
    }
}
class Customer extends Thread{
    Clerk clerk;
    public Customer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("消费者开始消费");
            clerk.minusProduct();
        }
    }
}