package com.atguigu01.string.exer3;

/**
 * ClassName: User
 * Package: com.atguigu01.string.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/23 10:37
 * @Version 1.0
 */
public class User {
    private String userName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return userName + "-" + password;
    }
}
