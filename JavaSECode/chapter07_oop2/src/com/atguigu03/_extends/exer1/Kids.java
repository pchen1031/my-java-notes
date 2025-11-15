package com.atguigu03._extends.exer1;

/**
 * ClassName: Kids
 * Package: com.atguigu03._extends.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/4 21:44
 * @Version 1.0
 */
public class Kids extends ManKind{
    private int yearsOld;

    public Kids() {
    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void pringAge(){
        System.out.println(yearsOld);
    }
}
