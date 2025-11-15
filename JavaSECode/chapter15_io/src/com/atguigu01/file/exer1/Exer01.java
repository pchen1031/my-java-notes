package com.atguigu01.file.exer1;

import java.io.File;

/**
 * ClassName: Exer01
 * Package: com.atguigu01.file.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/5/10 16:35
 * @Version 1.0
 */
public class Exer01 {
    public static void main(String[] args) {

        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsolutePath());
        File file2 = new File(file1.getAbsoluteFile().getParent(),"abc.txt");
        System.out.println(file2.getAbsolutePath());
    }

}
