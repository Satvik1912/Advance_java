import java.util.Arrays;
import java.util.List;

public class greater_thanK {
    public static void main(String[] args) {
        // Input list
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Value of K
        int k = 25;

        // Find and print elements greater than K
        List<Integer> greaterThanK = numbers.stream()
                .filter(num -> num > k) // Filter elements greater than K
                .toList();             // Collect them into a list

        System.out.println("Elements greater than " + k + ": " + greaterThanK);
    }
}
