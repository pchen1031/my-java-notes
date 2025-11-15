package com.atguigu2.two.exer1;

/**
 * ClassName: ArrayExer01
 * Package: com.atguigu2.two.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 10:37
 * @Version 1.0
 */
public class ArrayExer01 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,5,8},{12,9},{7,0,6,4}};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                count += arr[i][j];
            }
        }
        System.out.println(count);
    }
}
