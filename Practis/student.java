public class student {
    int id;
    String name;

    public student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public student(student obj) {
        this.id = obj.id;
        this.name = obj.name;
    }

    public void display() {
        System.out.println("Id is:" + id);
        System.out.println("Name is:" + name);
    }

    public static void main(String[] args) {
        student s1 = new student(101, "shivam");
        student s2 = new student(s1);
        s1.display();
        s2.display();
    }
}