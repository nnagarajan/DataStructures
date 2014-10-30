package algorithms.sorting;

import dstruct.tree.Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by nanagarajan on 9/23/2014.
 */
public class HeapSort {

    public static void main(String[] args) {
        System.out.print("Enter array to sort > ");
        Heap<Integer> myHeap = new Heap<Integer>(10);
        Scanner scanner = new Scanner(System.in);


        while (true) {

            String inputString = scanner.nextLine();
            Scanner integerScanner = new Scanner(inputString);
            while (integerScanner.hasNextInt()) {
                myHeap.add(integerScanner.nextInt());
            }

            while (!myHeap.isEmpty()) {
                System.out.println(myHeap.deleteMax());
            }
            break;
        }


    }
}
