/**
 * ClassName: Test6
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/5/6 17:25
 * @Version 1.0
 */
public class Test6 {
    public static void main(String[] args) {
        DaiMaKuai daiMaKuai1 = new DaiMaKuai();
        DaiMaKuai daiMaKuai2 = new DaiMaKuai();
        String str = new String(new char[]{97});
        System.out.println(str);
    }
}
class DaiMaKuai{
    {
        System.out.println("这是静态代码块");
    }
}
