package EXepetionHandling;


import java.util.Scanner;

public class ClassNotFoundExpDemo {

    public ClassNotFoundExpDemo(String className) {
        try {
            
            Class cls = Class.forName(className);
            System.out.println("Class loaded successfully: " + cls.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class '" + className + "' not found.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the class name to load: ");
        String className = scanner.nextLine();

        new ClassNotFoundExpDemo(className);

        scanner.close();
    }
}
