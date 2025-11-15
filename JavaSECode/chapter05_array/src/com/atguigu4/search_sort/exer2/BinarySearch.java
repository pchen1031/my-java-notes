package com.atguigu4.search_sort.exer2;

/**
 * ClassName: BinarySearch
 * Package: com.atguigu4.search_sort.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 19:29
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,8,12,15,19,26,37,49,51,66,89,100};
        int low =0 , high = arr.length-1;
        int mid;
        while (low <= high){
            mid = (low + high)/2;
            if (arr[mid] == 5){
                System.out.println("找到啦，对应的索引值为：" + mid);
                break;
            } else if (arr[mid] > 5) {
                high = mid - 1;
            }else {
                low = mid +1;
            }
        }
        if (low > high){
            System.out.println("该数值不存在");
        }
    }
}
