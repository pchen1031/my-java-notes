package com.atguigu06.project.team.service;

/**
 * ClassName: TeamException
 * Package: com.atguigu06.project.team.service
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/15 16:26
 * @Version 1.0
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3383124229948L;
    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
