package com.atguigu02.selfdefine.exer1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * ClassName: DAO
 * Package: com.atguigu02.selfdefine.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/5/5 16:57
 * @Version 1.0
 */
public class DAO <T>{
    Map<String,T> map;

    public void save(String id,T entity){
        if (!map.containsKey(id)){

            map.put(id,entity);
        }
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        if (map.containsKey(id)){

            map.put(id,entity);
        }
    }
    public List<T> list(){
        //方式一
//        Collection<T> values = map.values();
//        ArrayList<T> list = new ArrayList<>();
//        list.addAll(values);
//        return list;
        //方式二
        Collection<T> values = map.values();
        ArrayList<T> list = new ArrayList<>(values);
        return list;
    }
    public void delete(String id){
        if (map.containsKey(id)){

            map.remove(id);
        }
    }
}
