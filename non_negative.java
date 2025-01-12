// Find the product of all non-negative numbers in list.
import java.util.Arrays;
import java.util.List;

public class non_negative {
    public static void main(String[] args) {
        // Input list
        List<Integer> numbers = Arrays.asList(-10, 20, 0, 15, -5, 3);

        // Calculate the product of all non-negative numbers
        int product = numbers.stream()
                .filter(num -> num >= 0)      // Filter non-negative numbers
                .reduce(1, (a, b) -> a * b); // Multiply them using reduce

        // Print the result
        System.out.println("Product of all non-negative numbers: " + product);
    }
}
