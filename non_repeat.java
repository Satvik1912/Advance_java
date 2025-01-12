import java.util.*;
import java.util.stream.Collectors;

public class non_repeat{
    public static void main(String[] args) {
        // Input string
        String input = "programming";

        // Find all non-repeating characters
        List<Character> nonRepeatingCharacters = input.chars()
                .mapToObj(c -> (char) c) // Convert int stream to character stream
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Filter characters that appear only once
                .map(Map.Entry::getKey) // Extract the characters
                .collect(Collectors.toList()); // Collect them into a list

        // Print the result
        System.out.println("Non-repeating characters: " + nonRepeatingCharacters);
    }
}
