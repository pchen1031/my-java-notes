package com.atguigu04.example.exer5_objarr1;

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
        StudentUtil util = new StudentUtil();
        util.targetState(students,3);
        System.out.println("*************************************************");
        util.sortStudents(students);
        //排序后遍历
        util.printStudent(students);
    }

}
