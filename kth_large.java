import java.util.Arrays;
import java.util.List;

public class kth_large {
    public static void main(String[] args) {
        // Input list
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Value of K
        int k = 3;

        // Find the Kth largest number
        int kthLargest = numbers.stream()
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(k - 1)            // Skip the first (k-1) elements
                .findFirst()            // Get the first element after skipping
                .orElseThrow(() -> new IllegalArgumentException("List doesn't have enough elements"));

        // Print the result
        System.out.println(k + "rd largest number is: " + kthLargest);
    }
}
