package dstruct.linear;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by nanagarajan on 9/22/2014.
 */
public class QueueLinkedList<Item> implements Iterable<Item> {

    private int N;

    private Node first;

    private Node last;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;

        public String toString() {
            StringBuilder node = new StringBuilder();
            Node<Item> current = this;
            node.append("[");
            do {
                node.append(current.item);
                if (current.next != null)
                    node.append(",");
                current = current.next;
            } while (current != null);
            node.append("]");
            return node.toString();
        }
    }

    public int size() {
        return N;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void enQueue(Item newItem) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = newItem;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;

        N++;
        printQueue();


    }

    public Item deQueue() {
        if (isEmpty()) throw new NoSuchElementException("Queue Overflow");
        Item deQueuedItem = (Item) first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        printQueue();
        return deQueuedItem;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue Overflow");
        return (Item) first.item;
    }

    public void printQueue() {
        int iCount = 0;
        StringBuilder qString = new StringBuilder();
        qString.append("[");
        Iterator<Item> iterator = this.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            iCount++;
            qString.append(item);
            if (iCount < this.size())
                qString.append(",");
        }
        qString.append("], firstPtr = " + first + ", lastPtr = " + last);

        System.out.println(qString);
    }


    @Override
    public Iterator<Item> iterator() {


        return new Iterator<Item>() {
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }


    public static void main(String[] args) {
        QueueLinkedList<String> queue = new QueueLinkedList<String>();
        StdOut.print("> ");
        while (!StdIn.isEmpty()) {

            String item = StdIn.readString();
            if (!item.equals("-")) {
                queue.enQueue(item);

            } else if (!queue.isEmpty())
                StdOut.println(queue.deQueue());

            StdOut.print("> ");
        }

        StdOut.println("(" + queue.size() + " left on queue)");
    }


}
