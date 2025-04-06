import java.util.Scanner;
import java.time.LocalDate;

public class UniversityExamProcessor {
    
    static final int NUM_STUDENTS = 10;
    static final int NUM_SUBJECTS = 5;
    static String[] subjectNames = {"Programming 1", "Database", "Accounting", "web Development", "Data Structure"};
    
    static class Student {
        String name;
        String id;
        int[] scores = new int[NUM_SUBJECTS];
        double average;
        char grade;
        String recommendation;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[NUM_STUDENTS];

        // Task 1 & 2: Read student details and scores
        readStudentDetailsAndScores(scanner, students);

        // Task 3: Calculate average and grade
        for (Student student : students) {
            calculateAverageAndGrade(student);
        }

        // Task 4: Display report cards
        for (Student student : students) {
            displayReportCard(student);
        }

        scanner.close();
    }

    public static void readStudentDetailsAndScores(Scanner scanner, Student[] students) {
        for (int i = 0; i < NUM_STUDENTS; i++) {
            students[i] = new Student();
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            students[i].name = scanner.nextLine();
            System.out.print("ID Number: ");
            students[i].id = scanner.nextLine();
            for (int j = 0; j < NUM_SUBJECTS; j++) {
                System.out.print("Enter marks for " + subjectNames[j] + ": ");
                students[i].scores[j] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline
        }
    }

    public static void calculateAverageAndGrade(Student student) {
        int total = 0;
        for (int score : student.scores) {
            total += score;
        }
        student.average = total / (double) NUM_SUBJECTS;

        if (student.average >= 70) {
            student.grade = 'A';
            student.recommendation = "Excellent";
        } else if (student.average >= 60) {
            student.grade = 'B';
            student.recommendation = "Good";
        } else if (student.average >= 50) {
            student.grade = 'C';
            student.recommendation = "Fair";
        } else if (student.average >= 40) {
            student.grade = 'D';
            student.recommendation = "Poor";
        } else {
            student.grade = 'F';
            student.recommendation = "Fail";
        }
    }

    public static void displayReportCard(Student student) {
        System.out.println("\n---- Report Card ----");
        System.out.println("Name: " + student.name);
        System.out.println("ID Number: " + student.id);
        System.out.println("Subjects and Scores:");
        for (int i = 0; i < NUM_SUBJECTS; i++) {
            System.out.println(subjectNames[i] + ": " + student.scores[i]);
        }
        System.out.printf("Average Score: %.2f%n", student.average);
        System.out.println("Grade: " + student.grade);
        System.out.println("Recommendation: " + student.recommendation);
        System.out.println("Date: " + LocalDate.now());
    }
}
