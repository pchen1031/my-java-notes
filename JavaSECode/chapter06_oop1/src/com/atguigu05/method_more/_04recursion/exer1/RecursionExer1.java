package com.atguigu05.method_more._04recursion.exer1;

/**
 * ClassName: RecursionExer1
 * Package: com.atguigu05.method_more._04recursion.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/28 20:32
 * @Version 1.0
 */
//练习1：
//已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),
//其中n是大于0的整数，求f(10)的值。
//
//
//练习2：
//已知有一个数列：f(0) = 1,f(1) = 4,
//f(n+2)=2*f(n+1) + f(n),其中n是大于0的整数，求f(10)的值。
public class RecursionExer1 {
    public static void main(String[] args) {
        RecursionExer1 recursionExer1 =new RecursionExer1();
        System.out.println(recursionExer1.f1(10));
        System.out.println(recursionExer1.f2(10));

    }

    public int f1(int n){
        if(n == 20){
            return 1;
        } else if (n == 21) {
            return 4;
        }else {
            return f1(n+2) - 2 * f1(n+1);
        }
    }
    public int f2(int n){
        if (n == 0){
            return 1;
        } else if (n == 1) {
            return 4;
        }else{
            return 2*f1(n-1) + f1(n-2);
        }
    }
}
