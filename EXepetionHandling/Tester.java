package EXepetionHandling;

//import javax.management.RuntimeErrorException;

class ParentClass {
   
    public void loadingClass(String Classname) throws ClassNotFoundException {

        Class<?> class1 = Class.forName(Classname);
        System.out.println("Class Loaded Successfully !! :" + class1.getName());
    }
}

class ChildClass extends ParentClass {
    public void loadingClass(String Classname) throws IllegalArgumentException {
        if (Classname == null || Classname.trim().isEmpty()) {
            throw new IllegalArgumentException("Class is Can not be Empty !!");
            // System.exit(0);
        }
        try {
            super.loadingClass(Classname);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading class in ChildClass. Converting to unchecked exception.");
            throw new RuntimeException("Unchecked Exception: RuntimeException from ChildClass", e);

        }

    }
}

public class Tester {
    public static void main(String[] args) throws IllegalArgumentException {
        ChildClass c1 = new ChildClass();

        if (args.length == 0) {
            System.out.println("enter the comand line arguments !!");
            return;

        }
        try {
            c1.loadingClass(args[0]);
        } catch (RuntimeException e) {
            System.out.println("Exception caught:" + e.getMessage());

        }

    }
}

// class ParentClass{
// public void loadingClass(String className) throws ClassNotFoundException {
// Class<?> clazz = Class.forName(className);
// System.out.println("Class loaded successfully: " + clazz.getName());
// }
// }

// class ChildClass extends ParentClass {
// @Override
// public void loadingClass(String className) {
// if (className == null || className.trim().isEmpty()) {
// throw new IllegalArgumentException("Class name cannot be empty");
// }

// try {
// super.loadingClass(className);
// } catch (ClassNotFoundException e) {
// System.out.println("Error loading class in ChildClass. Converting to
// unchecked exception.");
// throw new RuntimeException("Unchecked Exception: RuntimeException from
// ChildClass", e);
// }
// }
// }
// public class Tester {
// public static void main(String[] args) throws IllegalArgumentException {
// ChildClass cc = new ChildClass();

// if (args.length == 0) {
// System.out.println("Please provide a class name as a command-line
// argument.");
// return;
// }

// try {
// cc.loadingClass(args[0]);
// } catch (RuntimeException e) {
// System.out.println("Exception caught: " + e.getMessage());
// }
// }
// }
