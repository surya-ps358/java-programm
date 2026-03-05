package ConsumerFunction;

import java.util.Scanner;
import java.util.function.Consumer;

record Student(int id, String name, String course) {
}

public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Consumer<Student> studentDetails = student -> System.out
                .println("Hello " + student.name() + "! Welcome to the " + student.course() + " course.");


        System.out.println("Enter the how much students you want to show deatils ?");
        int count = sc.nextInt();
        if (count <= 0) {
            System.out.println("Invalid number of students");
            return;

        }

        for (int i = 0; i < count; i++) {
            System.out.println("Enter the student id.");
            int id = sc.nextInt();
            System.out.println("Enter the student Name.");
            String name = sc.next();
            System.out.println("Enter student course");
            String course = sc.next();

            Student student = new Student(id, name, course);
            studentDetails.accept(student);
        }

        sc.close();
    }
}
