/**
 * ClassName: Season
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/26 21:03
 * @Version 1.0
 */
public class Season {
    private final String seasonName;
    private final String seasonDesc;

    // 非静态的 spring 实例（作为 Season 类的成员属性）
    public final Season spring = new Season("春天", "春暖花开");

    // 私有构造方法，禁止外部直接 new Season()
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 实例方法：返回当前实例的季节名称
    public String getSeasonName() {
        return this.seasonName;
    }

    // 实例方法：返回当前实例的季节描述
    public String getSeasonDesc() {
        return this.seasonDesc;
    }

    // 实例方法：返回 spring 的季节名称（直接访问内部属性）
    public String getSpringName() {
        return this.spring.getSeasonName();
    }

    // 主方法测试
    public static void main(String[] args) {
        // 创建一个 Season 实例（实际是冗余的，只是为了演示）
        Season season = new Season("默认季节", "无描述");

        // 通过实例方法获取 spring 的季节名称
        String springName = season.getSpringName();
        System.out.println("春天名称: " + springName); // 输出 "春天名称: 春天"
    }
}
//栈溢出