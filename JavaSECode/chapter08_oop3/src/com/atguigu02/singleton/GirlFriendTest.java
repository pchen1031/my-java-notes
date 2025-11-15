package com.atguigu02.singleton;

/**
 * ClassName: GirlFriendTest
 * Package: com.atguigu02.singleton
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/11 18:25
 * @Version 1.0
 */
//懒汉式
public class GirlFriendTest {
    public static void main(String[] args) {

    }
}
class GirlFriend{
    private GirlFriend(){

    }

    private static GirlFriend instance = null;

    public static GirlFriend getInstance() {
        if(instance == null){
            instance = new GirlFriend();
        }
        return instance;
    }
}
