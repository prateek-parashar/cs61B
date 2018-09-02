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

    public static void main (String[] args){
        LinkedListDeque L = new LinkedListDeque();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(25);
        L.addLast(30);

    }
}
