package util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nanagarajan on 9/22/2014.
 */
public class DTester {
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String tempStr = null;
        while (true) {
            System.out.print("> ");
            tempStr = scanner.next();
            if (tempStr.toString().equalsIgnoreCase("exit"))
                break;
            str.add(tempStr);

        }
        System.out.println(str);
    }
}
