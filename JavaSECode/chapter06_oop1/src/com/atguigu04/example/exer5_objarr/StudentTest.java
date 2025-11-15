package com.atguigu04.example.exer5_objarr;

/**
 * ClassName: StudentTest
 * Package: com.atguigu04.example.exer5_objarr
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/27 19:36
 * @Version 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        //创建student 每一个数组元素都是一个对象
        Student[] students= new Student[20];
        //给数组元素赋值
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].number = i+1;
            students[i].state = (int) (Math.random()*(6)) + 1;
            students[i].score = (int) (Math.random()*(101)) ;
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i].state == 3){
//                System.out.println("nubmer:" + students[i].number + ",state:" +  students[i].state + ",score:" + students[i].score);
                Student stu = students[i];
                stu.show();
            }
        }
        System.out.println("*************************************************");
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score < students[j+1].score){
                    Student stu = students[j];
                    students[j] = students[j+1];
                    students[j+1] = stu;
                }
            }
        }
        //排序后遍历
        for (int i = 0; i < students.length; i++) {
            students[i].show();
        }

    }

}
