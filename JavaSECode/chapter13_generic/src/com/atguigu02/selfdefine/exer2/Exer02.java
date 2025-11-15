package com.atguigu02.selfdefine.exer2;

/**
 * ClassName: Exer02
 * Package: com.atguigu02.selfdefine.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/5/6 17:33
 * @Version 1.0
 */
public class Exer02 {
    public static <E> void method1(E[] e, int a, int b){
        E temp = e[a];
        e[a] = e[b];
        e[b] = temp;
    }
    public static <E> void method2( E[] e){
        for(int min = 0,max = e.length - 1;min < max; min++,max--){
            E temp = e[min];
            e[min] = e[max];
            e[max] = temp;
        }
    }
}
