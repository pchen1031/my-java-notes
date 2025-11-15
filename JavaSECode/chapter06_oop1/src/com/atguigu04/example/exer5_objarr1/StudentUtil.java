package com.atguigu04.example.exer5_objarr1;

/**
 * ClassName: StudentUtil
 * Package: com.atguigu04.example.exer5_objarr1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/28 12:47
 * @Version 1.0
 */
public class StudentUtil {
    public void targetState(Student[] students,int state){
        for (int i = 0; i < students.length; i++) {
            if (students[i].state == state){
//                System.out.println("nubmer:" + students[i].number + ",state:" +  students[i].state + ",score:" + students[i].score);
                Student stu = students[i];
                stu.show();
            }
        }
    }
    public void sortStudents(Student[] students){
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score < students[j+1].score){
                    Student stu = students[j];
                    students[j] = students[j+1];
                    students[j+1] = stu;
                }
            }
        }
    }
    public void printStudent(Student[] students){
        for (int i = 0; i < students.length; i++) {
            students[i].show();
        }
    }
}
