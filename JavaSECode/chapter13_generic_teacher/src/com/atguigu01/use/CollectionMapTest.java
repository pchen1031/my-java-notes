package com.atguigu01.use;

import org.junit.Test;

import java.util.*;

/**
 * @author 尚硅谷-宋红康
 * @create 11:39
 */
public class CollectionMapTest {


@Test
public void test(){
    System.out.println("pc");
}

    //体会集合中使用泛型前的场景
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(67);
        list.add(78);
        list.add(76);
        list.add(99);
        //1.问题1：类型不安全。因为add()的参数是Object类型，意味着任何类型的对象都可以添加成功
//        list.add("AA");

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            //2.问题2：需要使用强转操作，繁琐。还有可能导致ClassCastException异常。
            Integer i = (Integer) iterator.next();//将从迭代器中获取的 Object 类型对象强制转换为 Integer 类型。
            int score = i;

            System.out.println(score);
        }
    }



    //在集合中使用泛型的例子
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(76);
        list.add(66);
        list.add(99);
        //编译报错，保证类型的安全
//        list.add("AA");

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            //因为添加的都是Integer类型，避免了强转操作
            Integer i = iterator.next();
            int score = i;

            System.out.println(score);
        }

    }


    /*
    * 泛型在Map中使用的例子
    * */
    @Test
    public void test3(){
//        HashMap<String,Integer> map = new HashMap<String,Integer>();

        //jdk7的新特性
        HashMap<String,Integer> map = new HashMap<>(); //类型推断

        map.put("Tom",67);
        map.put("Jerry",87);
        map.put("Rose",99);
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
//        Map.Entry<String, Integer> next = iterator1.next();

//        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        //整体来讲是一个Set，Set里是一个一个的entry，entry是一个内部的接口所以需要外部的去调用，entry也有泛型，所以写成<Map.Entry<String,Integer>>
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        //迭代器操作的是entry 所以还是这个<Map.Entry<String,Integer>>

        var entrySet = map.entrySet();
        var iterator = entrySet.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();//是iterator的每一个元素，所以还是Map.Entry<String, Integer>
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "--->" + value);
        }
    }



}
