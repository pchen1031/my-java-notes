import java.util.Arrays;

/**
 * ClassName: test4
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/30 22:23
 * @Version 1.0
 */
public class test4 {
    public static void main(String[] args) {
        int[] arr =new int[]{5,10,4,90,77,32,11,58,3,1};
        Arrays.sort(arr);
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
