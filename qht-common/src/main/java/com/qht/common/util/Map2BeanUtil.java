package com.qht.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Map2BeanUtil
 * @Author Zuoxh
 * @Data 2018/11/16 0016 下午 6:49
 */
public class Map2BeanUtil {
    /**
     * 批量实现javaBean 转map
     * @return
     */
    public static <T> List<Map<String,Object>> toList(List<T> list){
        List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
        for(T bean : list){
            Map<String,Object> m = new HashMap<String,Object>();
            toMap(bean,m);
            maps.add(m);
        }
        return maps;
    }

    /**
     * map 转 javaBean
     */
    public static void toBean(Map<?,?> map, Object bean) {
        Iterator<?> it = map.keySet().iterator();
        while (it.hasNext()) {
            try {
                Object key = it.next();
                Object value = map.get(key);
                setProperty(bean, (String) key, value);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

    }

    /**
     * javaBean 转 Map
     */
    public  static void toMap(Object bean,Map<String,Object> map){
        Field[] f = bean.getClass().getDeclaredFields();
        for(int i = 0 ; i < f.length ; i++){
            Object value = getProperty(bean, f[i].getName());
            if (value != null) {
                map.put(f[i].getName(), value);
            }
        }

    }

    /**
     * 得到某个对象的公共属性
     *
     * @param owner
     * @param fieldName
     * @return 该属性对象
     * @throws Exception
     */

    public static Object getProperty(Object owner, String fieldName) {
        Field field;
        Object property = null;
        try {
            field = owner.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            property = field.get(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return property;
    }

    /**
     * 设置某个对象的公共属性、
     *
     * @param owner
     * @param fieldName
     * @return 该属性对象
     * @throws Exception
     */
    public static void setProperty(Object owner, String fieldName, Object value) {
        Field field;
        try {
            field = owner.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (field.getModifiers() == 26) {
                return;
            }
            field.set(owner, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] agrs){
//        Student source = new Student();
//        source.setAccount("ytg");
//        source.setPassword("123456");
//        source.setSex(5);
//        Map<String,Object> map=new HashMap<>();
//        Map2BeanUtil.toMap(source, map);
//        for (Map.Entry<String,Object> entry :map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
//    }
}
