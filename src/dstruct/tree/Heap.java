package dstruct.tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Heap storage class based on array implementation
 */
public class Heap<HeapItem extends Comparable<HeapItem>> {

    private ArrayList<HeapItem> items;

    private int cursor;

    public Heap() {
        items = new ArrayList<HeapItem>();
        cursor = -1;
    }

    public Heap(int capacity) {
        items = new ArrayList<HeapItem>(capacity);
        cursor = -1;
    }


    /**
     * Element will be inserted towards the end of an array and will move up
     * by comparing it with the parent
     *
     * @param myIndex
     */
    private void siftUp(int myIndex) {
        HeapItem me = items.get(myIndex);
        while (myIndex > 0) {
            int pIndex = (myIndex - 1) / 2;
            HeapItem pItem = items.get(pIndex);
            if (me.compareTo(pItem) > 0) {
                items.set(myIndex, pItem);
                myIndex = pIndex;
            } else
                break;
        }
        items.set(myIndex, me);
    }


    /**
     * Once the root is deleted last element in the tree will replace the root node
     * and will be shifted down by comparing with child (L+R) nodes
     *
     * @param myIndex
     */
    private void siftDown(int myIndex) {
        if (items.size() <= 0)
            return;

        HeapItem me = items.get(myIndex);
        int lIndex = (2 * myIndex + 1);
        while (lIndex < items.size()) {
            int maxIndex = lIndex;
            HeapItem maxChild = items.get(lIndex);
            int rIndex = lIndex + 1;
            if (rIndex < items.size()) {
                HeapItem rightChild = items.get(rIndex);
                if (rightChild.compareTo(maxChild) > 0) {
                    maxChild = rightChild;
                    maxIndex = rIndex;
                }
            }
            if (me.compareTo(maxChild) < 0) {
                items.set(myIndex, maxChild);
                myIndex = maxIndex;
                lIndex = (2 * myIndex + 1);
            } else
                break;


        }

        items.set(myIndex, me);
    }

    /**
     * checks if the heap is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return items.size() == 0;
    }

    /**
     * returns the size of heap
     *
     * @return
     */
    public int size() {
        return items.size();
    }

    /**
     * delete the max element in the heap, which is the root node
     *
     * @return
     */
    public HeapItem deleteMax() {
        if (items.size() < 0)
            throw new NoSuchElementException("Overflow");

        //cursor = size() - 1;
        HeapItem maxItem = items.get(0);

        HeapItem lastItem = items.get(items.size() - 1);
        items.set(0, lastItem);
        items.remove(items.size() - 1);
        siftDown(0);
        cursor--;

        return maxItem;
    }

    /**
     * @return
     */

    public void add(HeapItem heapItem) {

        items.add(heapItem);
        siftUp(items.size() - 1);

    }

    public HeapItem first() {
        if (items.size() < 0)
            throw new NoSuchElementException("Overflow");
        return items.get(0);
    }

    public HeapItem next() {
        if (items.size() < 0)
            throw new NoSuchElementException();
        cursor++;
        HeapItem nextItem = items.get(cursor);
        return nextItem;
    }

    public static void main(String[] args) {
        System.out.print("> ");
        Heap<Integer> myHeap = new Heap<Integer>(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String inputString = scanner.nextLine();
            Scanner integerScanner = new Scanner(inputString);
            while (integerScanner.hasNextInt()) {
                myHeap.add(integerScanner.nextInt());
            }

            System.out.println(myHeap.items);

            if (inputString.contains("-")) {
                myHeap.deleteMax();
                System.out.println(myHeap.items);
            } else if (inputString.contains("exit"))
                break;

            System.out.print("> ");
        }
    }


}
