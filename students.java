import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String department;

    // Constructor
    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class students {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Alice", "Computer Science"),
            new Student("Bob", "Mathematics"),
            new Student("Charlie", "Computer Science"),
            new Student("David", "Mathematics"),
            new Student("Eve", "Physics"),
            new Student("Frank", "Physics"),
            new Student("Grace", "Computer Science")
        );

        // a. Find the Map of department and list of students
        Map<String, List<Student>> departmentToStudentsMap = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        System.out.println("Department to Students Map:");
        departmentToStudentsMap.forEach((dept, studentList) ->
                System.out.println(dept + ": " + studentList));

        // b. Count the number of students in each department
        Map<String, Long> departmentToStudentCount = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));

        System.out.println("\nDepartment to Student Count:");
        departmentToStudentCount.forEach((dept, count) ->
                System.out.println(dept + ": " + count));
    }
}
