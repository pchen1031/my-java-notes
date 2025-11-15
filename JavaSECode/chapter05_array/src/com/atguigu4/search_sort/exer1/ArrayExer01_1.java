package com.atguigu4.search_sort.exer1;

/**
 * ClassName: ArrayExer01_1
 * Package: com.atguigu4.search_sort.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 17:43
 * @Version 1.0
 */
public class ArrayExer01_1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        //int[] newarr = new int[arr.length * 2];
        int[] newarr = new int[arr.length << 1];//位运算
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = 10;
        newarr[arr.length + 1] = 20;
        newarr[arr.length + 2] = 30;
        arr = newarr;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
