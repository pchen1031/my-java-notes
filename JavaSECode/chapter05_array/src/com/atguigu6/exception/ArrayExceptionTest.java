package com.atguigu6.exception;
/**
 *
 * 测试数组中常见的异常
 *
 * @author 尚硅谷-宋红康
 * @create 13:22
 */
public class ArrayExceptionTest {
	public static void main(String[] args) {
		// 1. 数组角标越界的异常：
		int[] arr = new int[10];
		//角标的有效范围：0、1、2、...、9
//		System.out.println(arr[10]);
//		System.out.println(arr[-1]);

		// 2. 空指针异常：
		//情况1：
//		int[] arr1 = new int[10];
//
//		arr1 = null;
//
//		System.out.println(arr1[0]);//NullPointerException

		//情况2：
//		int[][] arr2 = new int[3][];
//
////		arr2[0] = new int[10];//此行代码不存在时，下一行代码出现NullPointerException
//
//		System.out.println(arr2[0][1]); //NullPointerException


		//情况3：
//		String[] arr3 = new String[4];
//		System.out.println(arr3[0].toString());//NullPointerException
		String s1 = new String("Hello"); // 堆内存中的新对象
		String s2 = new String("Hello"); // 另一个堆内存中的新对象
		String s3 = "Hello";             // 指向常量池中的对象
		String s4 = "Hello";             // 指向常量池中的同一对象

		System.out.println(s1 == s2);    // false（堆中不同对象）
		System.out.println(s3 == s4);    // true（常量池中同一对象）
		System.out.println(s1 == s3);    // false（堆 vs 常量池）
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
		System.out.println(arr1==arr2);//false
		arr2 = arr1;
		System.out.println(arr1==arr2);//true
	}
}

