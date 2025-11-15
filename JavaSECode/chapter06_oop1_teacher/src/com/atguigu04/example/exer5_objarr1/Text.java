package com.atguigu04.example.exer5_objarr1;

/**
 * ClassName: Text
 * Package: com.atguigu04.example.exer5_objarr1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/27 21:17
 * @Version 1.0
 */
public class Text {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3};
        xixi ha = new xixi();
        ha.modifyArray(myArray);
        System.out.println(myArray[0]); // 输出 100（原数组被修改）
    }
}
class xixi{
    public void modifyArray(int[] arr) {
//        arr[0] = 100; // 通过引用副本修改堆内存中的数组元素
        arr = new int[]{4, 5, 6};
    }

}

