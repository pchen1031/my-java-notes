package com.atguigu3.common_algorithm.exer3;

/**
 * ClassName: ArrayExer03
 * Package: com.atguigu3.common_algorithm.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 15:46
 * @Version 1.0
 */
public class ArrayExer03 {
    public static void main(String[] args) {
        int[][] yanghui = new int[10][];
        for (int i = 0; i < yanghui.length ; i++) {
            yanghui[i] = new int[i+1];
            yanghui[i][0] = 1;
            yanghui[i][i] = 1;
        }
        for (int i =2; i < yanghui.length ; i++) {
            for (int j = 1; j < yanghui[i].length-1; j++) {
                yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
            }
        }
        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
