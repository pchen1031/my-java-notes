package com.atguigu04.set.exer2;

import java.util.HashSet;
import java.util.Iterator;

/**
 * ClassName: Exer02
 * Package: com.atguigu04.set.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/30 21:34
 * @Version 1.0
 */
public class Exer02 {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        while(set.size() < 10){
            int random = (int)(Math.random() * (10 - 1 + 1) + 1);
            set.add(random);
        }

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*  为什么会输出有序
        在Java中，HashSet 不保证元素的存储和迭代顺序。然而，在特定情况下，你可能会观察到有序输出。以下是导致该现象的原因：

哈希函数与桶分布：

HashSet 底层使用 HashMap，元素的存储位置由哈希值决定。对于 Integer 类型，其哈希值即为其自身值。

当默认容量为 16 时，桶的位置通过 (n - 1) & hash 计算（n 是容量）。例如，数值 1 的哈希值为 1，落在桶 1；数值 10 落在桶 10。

连续无冲突的存储：

当元素为 1 到 10 且容量足够时，每个数值会被分配到独立的桶中（桶 1 至 10）。

迭代时，HashSet 按桶的顺序遍历，导致输出看似有序。

Java版本的实现细节：

不同Java版本的哈希表实现可能影响迭代顺序。例如，Java 8在哈希冲突时使用平衡树，但此处无冲突，顺序由桶位置决定。

注意：这种现象是特定环境下的巧合（如元素范围、容量、哈希函数等），并非HashSet的规范行为。在不同场景或Java版本中，输出可能无序。

结论：依赖HashSet的顺序是不可靠的。若需有序集合，应使用LinkedHashSet（维护插入顺序）或TreeSet（维护自然顺序）。

*/
    }
}
