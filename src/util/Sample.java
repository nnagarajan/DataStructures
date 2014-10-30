package util;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Created by nanagarajan on 9/30/2014.
 */
public class Sample {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16, 0.75f, true);
        linkedHashMap.put("1", null);
        linkedHashMap.put("2", null);
        linkedHashMap.put("3", null);



        for (String str : linkedHashMap.keySet()) {
            System.out.println(str);
        }

        System.out.println("** Access one, will move it to end **");
        linkedHashMap.get("1");

        for (String str : linkedHashMap.keySet()) {
            System.out.println(str);
        }
        linkedHashMap.put("2", "2");
        System.out.println("** Access two, will move it to end **");
        for (String str : linkedHashMap.keySet()) {
            System.out.println(str);
        }

    }
}
