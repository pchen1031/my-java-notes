package com.atguigu05.map.exer2;

import java.util.*;

/**
 * ClassName: Exer02
 * Package: com.atguigu05.map.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/5/2 21:30
 * @Version 1.0
 */
public class Exer02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set set = CityMap.model.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        String[] cities;
        while(true){
            System.out.print("请选择你所在的省份：");
            String province = scanner.next();
            //获取省份对应的各个城市构成的String[]
            cities = (String[]) CityMap.model.get(province);

            if(cities == null || cities.length == 0){
                System.out.println("你输入的省份有误，请重新输入");
            }else{
                break; //意味着用户输入的省份是存在的，则跳出当前循环
            }

        }

        for (int i = 0; i < cities.length; i++) {
            System.out.print(cities[i] + " ");
        }
        String city;
        while (true){
            System.out.print("请选择你所在的城市：");
            city = scanner.next();
            break;
        }

        scanner.close();
    }
}
class CityMap{

    public static Map model = new HashMap();

    static {
        model.put("北京", new String[] {"北京"});
        model.put("辽宁", new String[] {"沈阳","盘锦","铁岭","丹东","大连","锦州","营口"});
        model.put("吉林", new String[] {"长春","延边","吉林","白山","白城","四平","松原"});
        model.put("河北", new String[] {"承德","沧州","邯郸","邢台","唐山","保定","石家庄"});
        model.put("河南", new String[] {"郑州","许昌","开封","洛阳","商丘","南阳","新乡"});
        model.put("山东", new String[] {"济南","青岛","日照","临沂","泰安","聊城","德州"});
    }

}
