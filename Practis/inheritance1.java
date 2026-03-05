
class A {
    void display() {
        System.out.println("hi A");
    }

    void eat() {

    }
}

class B extends A {
    void show() {
        super.display();
        System.out.println("hi B");
    }

    @Override
    void eat() {

    }
}

public class inheritance1 {
    public static void main(String[] args) {
        B b1 = new B();

        b1.show();
    }

}
