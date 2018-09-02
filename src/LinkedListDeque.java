/** Implementation of a Deque data structure */
public class LinkedListDeque <rocket>{
    /** Naked recursive data structure hidden from the user */
    private class Node {
        rocket data;
        Node next;
        Node prev;

        // Constructor
        public Node(rocket x, Node n, Node p) {
            data = x;
            next = n;
            prev = p;
        }
        /** Returns the size of the internal implementation */
        private rocket get(int index) {
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
        sentinel = new <Integer> Node ( null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Add an element at the from of the Deque */
    public void addFirst(rocket x) {
        sentinel.next = new Node(x, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Add an element at the end of the Deque */
    public void addLast(rocket x) {
        sentinel.prev = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /** Checks if the Deque is empty */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        else {
            return false;
        }
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
    public rocket removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            Node p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            size--;
            return p.data;
        }
    }

    /** Returns and removes the last element of the Deque */
    public rocket removeLast() {
        if (size == 0) {
            return null;
        }
        else {
            Node p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
            size--;
            return p.data;
        }
    }

    /** Returns the item at a given index */
    public rocket get(int x) {
        if (size == 0) {
            return null;
        }
        return sentinel.next.get(x);
    }

    public static void main (String[] args){
        LinkedListDeque <Integer> L = new LinkedListDeque <>();
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
