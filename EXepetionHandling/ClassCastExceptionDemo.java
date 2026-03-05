package EXepetionHandling;

public class ClassCastExceptionDemo {

    public static void handleClassCastException() {
        Object[] objects = {"Hello", true, "Java"};

        for (Object obj : objects) {
            try {
                String str = (String) obj;
                System.out.println("Casting successful: " + str);
            } catch (ClassCastException e) {
                System.out.println("ClassCastException: Cannot cast " + obj.getClass().getName() + " to String.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        handleClassCastException();
    }
}
