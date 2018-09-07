import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    /** Test for sort Method */
    @Test
    public void testSort() {
        String[] input = {"this", "is", "bloody", "awesome"};
        String[] expected = {"awesome", "bloody", "is", "this"};
        Sort.sort(input);

        assertArrayEquals(expected, input);
    }

    /** Tests the method to find the smallest value */
    @Test
    public void testFindSmallest() {
        String[] input = {"this", "is", "bloody", "awesome"};
        int expected = 3;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);
    }

    /** Test the method to swap values */
    @Test
    public void testSwap() {
        String[] input = {"this", "is", "bloody", "awesome"};
        int a = 0;
        int b = 2;
        String[] expected = {"bloody", "is", "this", "awesome"};
        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }

}
