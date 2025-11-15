package com.atguigu05.exer.exer4;

/**
 * ClassName: BelowZeroException
 * Package: com.atguigu05.exer.exer4
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/11 16:16
 * @Version 1.0
 */
public class BelowZeroException  extends Exception{
    static final long serialVersionUID = -33875169939948L;
    public BelowZeroException() {
    }

    public BelowZeroException(String message) {
        super(message);
    }
}
