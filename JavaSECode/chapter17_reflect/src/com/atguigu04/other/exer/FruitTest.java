package com.atguigu04.other.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * ClassName: FruitTest
 * Package: com.atguigu04.other.exer
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/5/20 20:58
 * @Version 1.0
 */
public class FruitTest {
    @Test
    public void test1() throws Exception {
        //读取配置文件信息
        Properties properties = new Properties();
        File file = new File("src/config.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        String fruitName = properties.getProperty("fruitName");
        //通过反射创建指定全类名对应的实例
        Class clazz = Class.forName(fruitName);
        Constructor con = clazz.getDeclaredConstructor();
        con.setAccessible(true);

//        Fruit fruit = (Fruit) con.newInstance();
        Apple apple = (Apple) con.newInstance();
        //通过榨汁机对象调用run方法传入创建的实例
        Juicer juicer = new Juicer();
        juicer.run(apple);
    }

}
