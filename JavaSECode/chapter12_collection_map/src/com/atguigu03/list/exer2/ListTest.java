package com.atguigu03.list.exer2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: ListTest
 * Package: com.atguigu03.list.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/29 15:30
 * @Version 1.0
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        //随机生成三十个小写字母
        for (int i = 0; i < 30; i++) {
            //'a' - 'z'  [97,122]
            arrayList.add((char)(Math.random() * (122 - 97 + 1) + 97) + "");
        }
        System.out.println(arrayList);
        int aCouunt = listTest(arrayList, "a");
        int bCouunt = listTest(arrayList, "b");
        int cCouunt = listTest(arrayList, "c");
        int xCouunt = listTest(arrayList, "x");
        System.out.println(aCouunt);
        System.out.println(bCouunt);
        System.out.println(cCouunt);
        System.out.println(xCouunt);
    }
    public static int listTest(Collection list, String s){
        int count = 0;
        for (Object obj : list){
            if (s.equals(obj)){

                count++;
            }
        }
        return count;
    }
}
