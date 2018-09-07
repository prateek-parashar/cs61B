public class Sort {
    /** Sorts a given array destructively */
    public static void sort(String[] input) {
        /** Implementation of Selection Sort
         * 1. Find the smallest item
         * 2. Swap it with the first item
         * 3. DO Selection sort on the remaining array
         */
        sort(input, 0);
    }

    /** private method that allows us to use recursion */
    private static void sort(String[] input, int start) {
        if (start == input.length) {
            return;
        }
        int smallestIndex = findSmallest(input, start);
        swap(input, start, smallestIndex);
        sort(input, start + 1);
    }

    /** Returns the index of the smallest value in the array */
    public static int findSmallest(String [] input, int start) {
        int smallest = start;
        for (int i = start; i < input.length; i++) {
            if (input[smallest].compareTo(input[i]) > 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    /** Swaps the given indexes of the array */
    public static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
