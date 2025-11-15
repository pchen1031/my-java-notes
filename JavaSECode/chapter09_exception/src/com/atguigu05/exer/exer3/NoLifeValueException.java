package com.atguigu05.exer.exer3;

/**
 * ClassName: NoLifeValueException
 * Package: com.atguigu05.exer.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/10 17:09
 * @Version 1.0
 */
public class NoLifeValueException extends RuntimeException{
    static final long serialVersionUID = -70348971907939L;
    public NoLifeValueException(String message) {
        super(message);
    }

    public NoLifeValueException() {
    }
}
