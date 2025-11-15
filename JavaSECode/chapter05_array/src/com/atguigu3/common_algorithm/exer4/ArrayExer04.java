package com.atguigu3.common_algorithm.exer4;

/**
 * ClassName: ArrayExer04
 * Package: com.atguigu3.common_algorithm.exer4
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 16:45
 * @Version 1.0
 */
public class ArrayExer04 {
    public static void main(String[] args) {
        int[] array1 , array2;
        array1 =new int[] {2,3,5,7,11,13,17,19};
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
        System.out.println();
        array2 = array1;
        for (int i = 0; i < array2.length; i++) {
            if (i % 2 == 0){
                array2[i] = i;
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }
    }
}
