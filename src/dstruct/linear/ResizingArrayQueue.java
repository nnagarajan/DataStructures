package dstruct.linear;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by nanagarajan on 9/22/2014.
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {

    private Item[] q;

    private int N;

    private int first;

    private int last;

    final int INITIAL_CAPACITY = 2;


    public boolean isEmpty() {
        return N == 0;
    }

    ResizingArrayQueue() {
        q = (Item[]) new Object[INITIAL_CAPACITY];
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last = N;

    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue Underflow");

        return q[first];
    }

    public void enQueue(Item item) {

        if (N == q.length)
            resize(2 * q.length);

        q[last++] = item;
        if (last == q.length) last = 0;
        N++;


        printQueue();
    }

    public Item deQueue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue Underflow");
        Item deQueuedItem = q[first];
        q[first] = null;
        N--;
        first++;

        if (first == q.length) first = 0;           // wrap-around

        //shrink array
        if (N > 0 && N == q.length / 4)
            resize(q.length / 2);

        printQueue();
        return deQueuedItem;
    }

    private void printQueue() {
        int iCount = 0;
        StringBuilder qString = new StringBuilder();
        qString.append("[");
        for (Item i : q) {

            iCount++;
            qString.append(i);
            if (iCount < q.length)
                qString.append(",");
        }
        qString.append("], firstPtr = " + first + ", lastPtr = " + last);

        System.out.println(qString);

    }


    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < N;
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new UnsupportedOperationException();
                Item item = q[(i + first) % q.length];
                i++;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        StdOut.print("> ");
        while (!StdIn.isEmpty()) {

            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enQueue(item);

            else if (!queue.isEmpty())
                StdOut.println(queue.deQueue());

            StdOut.print("> ");
        }

        StdOut.println("(" + queue.size() + " left on queue)");
    }


}
