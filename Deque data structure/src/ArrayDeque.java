/** Array based implementation of linked lists */
public class ArrayDeque <Item>{
    private Item[] list;
    private int size;
    private int nextFirst;
    private int nextLast;

    // Constructor

    /** nextFirst is at the end and nextLast is at the beginning to
     * Implement the Deque in a circular fashion.
     */
    public ArrayDeque(){
        list = (Item[]) new Object[8];
        size = 0;
        nextFirst = list.length - 1;
        nextLast = 0;
    }

    // Checks if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the size of the list
    public int size(){
        return this.size;
    }

    // Check is the list is full
    public boolean isFull(){
        if (size == list.length){
            return true;
        }
        return false;
    }

    // Method to resize the array
    private void resize(){
        Item[] bigArray = (Item[]) new Object[this.size * 2];
        int endPointA = list.length - this.nextFirst - 1;
        int endPointB = this.nextLast;
        System.arraycopy(list, this.nextFirst + 1, bigArray, 0, endPointA);
        System.arraycopy(list, 0, bigArray, endPointA, endPointB);
        this.list = bigArray;
        this.nextFirst = list.length - 1;
        this.nextLast = this.size;
    }

    // Adds an element at the front of the Deque
    public void addFirst(Item x){
        if (this.isFull()){
            this.resize();
        }
        list[this.nextFirst] = x;
        this.nextFirst--;
        size++;
    }

    // Adds an element at the end of the Deque
    public void addLast(Item x){
        if (this.isFull()){
            this.resize();
        }
        list[this.nextLast] = x;
        this.nextLast++;
        size++;
    }

    // Prints the Deque in order
    public void printDeque(){
        int p = this.nextFirst + 1;
        int q = 0;
        while (p < this.list.length){
            System.out.print(list[p] + " ");
            p++;
        }

        while (q < this.nextLast){
            System.out.print(list[q] + " ");
            q++;
        }
    }

    // Returns the item at the given index
    public Item get(int x){
        int start = this.nextFirst + 1;
        if (this.nextFirst == list.length - 1){
            start = 0;
        }
        if(x < list.length - start){
            return list[start + x];
        }
        else{
            x = x - (list.length - start) - 1;
            return list[x];
        }
    }

    // Removes and returns the last item of the Deque
    public Item removeLast(){
        nextLast--;
        Item x = list[nextLast];
        list[nextLast] = null;
        return x;
    }

    // Removes and return ths first item of the Deque
    public Item removeFirst(){
        nextFirst++;
        Item x = list[nextFirst];
        list[nextFirst] = null;
        return x;
    }

    public static void main(String[]args){
        ArrayDeque L = new ArrayDeque();
        L.addFirst(3);
        L.addFirst(7);
        L.addLast(24);
        L.addFirst(46);
        L.addFirst('a');
        L.addLast(52);
        L.addLast(66);
        L.addFirst(99);
        L.addLast(124);
        L.addLast(898);
        System.out.println(L.size);
        L.printDeque();
        System.out.println(L.get(0));
        System.out.println(L.get(6));
        System.out.println(L.get(9));
    }
}