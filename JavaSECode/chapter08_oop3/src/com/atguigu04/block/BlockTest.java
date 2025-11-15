package com.atguigu04.block;

/**
 * ClassName: BlockTest
 * Package: com.atguigu04.block
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/11 21:59
 * @Version 1.0
 */
public class BlockTest {
    public static void main(String[] args) {
//        Block block1 =new Block();
//        Block block2 =new Block();
//        System.out.println(Block.s1);
//        block1.ceshi();
        new Block();
    }
}
class Block{
    static String s1 = "xixi";
    public Block(){
        System.out.println("这是构造器");
    }
    {
        System.out.println("非静态代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    public void ceshi(){
        System.out.println("这是一次测试");
    }
}

