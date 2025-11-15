package com.atguigu01.string.exer3;

import java.util.Scanner;

/**
 * ClassName: UserTest
 * Package: com.atguigu01.string.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/23 13:55
 * @Version 1.0
 */
public class UserTest {
    public static void main(String[] args) {
        User[] users = new User[3];
        users[0] = new User("pengchen","123");
        users[1] = new User("Tom","8888");
        users[2] = new User("Jerry","6666");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String userName = scanner.next();
        System.out.print("请输入密码:");
        String password = scanner.next();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUserName().equals(userName) && users[i].getPassword().equals(password)){
                System.out.println("登录成功," + users[i].getUserName());
                break;
            }
        }
        scanner.close();
    }
}
