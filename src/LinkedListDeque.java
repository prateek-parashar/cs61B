/** Implementation of a Deque data structure */
public class LinkedListDeque {
    /** Naked recursive data structure hidden from the user */
    private class Node {
        int data;
        Node next;
        Node prev;

        // Constructor
        public Node(int x, Node n, Node p) {
            data = x;
            next = n;
            prev = p;
        }
        /** Returns the size of the internal implementation */
        private int get(int index) {
            if (index == 0) {
                return this.data;
            }
            else return this.next.get(index - 1);
        }
    }

    // sentinel attribute (the middle man)
    private Node sentinel;
    private int size;

    /** Constructor of the Deque data structure is cyclic in nature */
    public LinkedListDeque() {
        sentinel = new Node(63, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Add an element at the from of the Deque */
    public void addFirst(int x) {
        sentinel.next = new Node(x, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Add an element at the end of the Deque */
    public void addLast(int x) {
        sentinel.prev = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /** Checks if the Deque is empty */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the size of the Deque */
    public int size() {
        return this.size;
    }

    /** Prints the Deque is order */
    public void printDeque() {
        Node p = this.sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.data + " ");
            p = p.next;
        }
    }

    /** Removes and returns the first item of the Deque */
    public int returnFirst() {
        if (size == 0) {
            return 0;
        }
        else {
            Node p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            return p.data;
        }
    }

    /** Returns and removes the last element of the Deque */
    public int returnLast() {
        if (size == 0) {
            return 0;
        }
        else {
            Node p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
            return p.data;
        }
    }

    /** Returns the item at a given index */
    public int get(int x) {
        if (size == 0) {
            return 0;
        }
        return sentinel.next.get(x);
    }

    public static void main (String[] args){
        LinkedListDeque L = new LinkedListDeque();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(25);
        L.addLast(30);
        L.printDeque();
        System.out.println("");
        System.out.print(L.get(4));
    }
}
