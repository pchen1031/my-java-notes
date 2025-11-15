import java.util.Scanner;

/**
 * ClassName: IfElseTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/11 14:37
 * @Version 1.0
 */
public class IfElseTest {
    public static void main(String[] args) {
        int score = 67;
        if(score == 100){
            System.out.println("奖励一辆跑车");
        }else if(score >= 60 && score <= 80) {
            System.out.println("奖励环球影城玩一日游");
        }else if(score > 80 && score <= 99){
            System.out.println("奖励一辆山地自行车");
        }
        else{
        	System.out.println("胖揍一顿");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        int a = scanner.nextInt();
        System.out.println(a);
        scanner.nextInt();
        int number= (int) Math.random();
        System.out.println(7%2);

    }
}
