import java.util.Arrays;
import java.util.List;

public class list_avg{
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Calculate the average
        double average = numbers.stream()
                                .mapToInt(Integer::intValue) // Convert to IntStream
                                .average()                  // Calculate average
                                .orElse(0.0);               // Handle empty list case

        // Print the result
        System.out.println("Average: " + average);
    }
}
