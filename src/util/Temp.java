package util;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by nanagarajan on 10/14/2014.
 */
public class Temp {
    private static final int MAX = 400000000;

    private static String[] DB_DATA =
            {"Escape", "Calippic", "Obedible", "Thaumatolatry", "Grief", "Scarp", "Eacutepergne", "Bell jar", "Offshore", "Christs thorn"};

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        String[] arr = new String[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = new String(DB_DATA[i % 10]).intern();
        }

        System.out.println((System.currentTimeMillis() - t + " ms"));
        System.gc();
        System.out.println(arr[0]);


    }
}
