public class TestSort {
    /** Test for sort Method */
    public static void testSort() {
        String[] input = {"this", "is", "bloody", "awesome"};
        String[] expected = {"awesome", "bloody", "is", "this"};
        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expected, input);
    }

    /** Tests the method to find the smallest value */
    public static void testFindSmallet() {
        String[] input = {"this", "is", "bloody", "awesome"};
        int expected = 3;
        int actual = Sort.findSmallest(input, 0);
        org.junit.Assert.assertEquals(expected, actual);
    }

    /** Test the method to swap values */
    public static void testSwap() {
        String[] input = {"this", "is", "bloody", "awesome"};
        int a = 0;
        int b = 2;
        String[] expected = {"bloody", "is", "this", "awesome"};
        Sort.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);
    }


    public static void main(String args[]) {
        testSort();
    }
}
