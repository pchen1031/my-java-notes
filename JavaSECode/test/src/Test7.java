/**
 * ClassName: Test7
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/6/27 22:52
 * @Version 1.0
 */
abstract class Animal {
    private String name;

    // 抽象类的构造器
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound(); // 抽象方法
}

class Dog extends Animal {
    // 子类必须调用父类构造器
    public Dog(String name) {
        super(name); // 调用抽象父类的构造器
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}

public class Test7 {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.makeSound(); // 输出: Buddy says: Woof!
    }
}
