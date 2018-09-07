public class TestSort {
    public static void testSort() {
        String[] input = {"this", "is", "bloody", "awesome"};
        String[] expected = {"awesome", "bloody", "is", "this"};
        Sort.sort(input);

        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Error! expected " + expected[i] + " received " + input[i]);
                return;
            }
        }

    }

    public static void main(String args[]) {
        TestSort.testSort();
    }
}
