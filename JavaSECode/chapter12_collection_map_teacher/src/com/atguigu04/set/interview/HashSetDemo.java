package com.atguigu04.set.interview;

import java.util.HashSet;

/**
 * @author shkstart
 * @create 15:35
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}] remove的时候是按照[1001，CC]的哈希值去remove的 虽然把p1的name改成了CC但是p1的哈希值还是原来的
//
//        set.add(new Person(1001,"CC"));
//        System.out.println(set);
//
//        set.add(new Person(1001,"AA"));
//        System.out.println(set);

    }
}
