package com.swjtu;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListMap {

    static List<Map> lis = new ArrayList<Map>();
    static Map<Integer, String> map = new HashMap<Integer, String>();
    static Map<Integer, Integer> ma = new HashMap<Integer, Integer>();

    public static void main(String[] args) {

        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");

        ma.put(1, 1);
        ma.put(2, 2);
        ma.put(3, 3);

        lis.add(map);
        lis.add(ma);

        for (Map m : lis) {
            Iterator<Map.Entry<Object, Object>> it = m.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Object, Object> entry = it.next();
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

}