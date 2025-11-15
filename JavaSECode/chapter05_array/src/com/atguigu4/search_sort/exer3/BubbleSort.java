package com.atguigu4.search_sort.exer3;

/**
 * ClassName: BubbleSort
 * Package: com.atguigu4.search_sort.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 20:23
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{34,54,3,2,65,7,34,5,76,34,67};
        System.out.println("未排序之前:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j =0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
