/**
 * ClassName: Test2
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/27 15:30
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        CC c1 = new CC();
        CC c2 = new CC();
    }
}
class CC{
    static {
        System.out.println("静态代码块");
    }
}
