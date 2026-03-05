import java.util.Scanner;

class employee {

    String name;
    public employee(String name, int id) {
        super();
        this.name = name;
        if (name.isEmpty() || name == "null") {
            System.err.println("Name can not be Empty or Null.");
            System.exit(0);
        }
        if (id < 0) {
            System.err.println("Id can not be nagtive!!");
            System.exit(0);
        }
    }

    public double calculateSalary() {
        return 0.0;

    }
}

class fulltime extends employee {
    protected double salary;

    public fulltime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
        if (salary < 0) {
            System.err.println("Salary can not be nagative !!");
            System.exit(0);
        }

    }

    public double calculateSalary() {
        return salary;

    }

}

class partTime extends employee {
    protected double hourRate;
    protected int hourswork;

    public partTime(String name, int id, double hourRate, int hourswork) {
        super(name, id);
        this.hourRate = hourRate;
        if (hourRate < 0) {
            System.err.println("value can not be nagative, Enter the valid Rate");
            System.exit(0);
        }
        this.hourswork = hourswork;
        if (hourswork < 0) {
            System.err.println("value is invalid");
            System.exit(0);
        }

    }

    public double calculateEmpsalary() {
        return hourRate * hourswork;
    }

}

public class calculateEmpsalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("calculation menu");

        System.out.println("1)fulltime employee.");
        System.err.println("partTime employee");
        System.out.println("Enter your choice [1/2]");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the name :");
                String ftName = sc.nextLine();

                System.out.println("Enter the employee id :");
                int ftId = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the salary :");
                double salary = sc.nextDouble();
                sc.nextLine();
                fulltime Employee = new fulltime(ftName, ftId, salary);
                System.out.println(ftName + "'s Salary: " + Employee.calculateSalary());
                break;

            case 2:
                System.out.println("Enter the name :");
                String pName = sc.nextLine();

                System.out.println("Enter the employee id :");
                int pId = sc.nextInt();
                sc.nextLine();

                System.out.println(" Each hour rate :");
                double hourRate = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter the hourse Time :");
                int hourswork = sc.nextInt();
                sc.nextLine();

                partTime Employee1 = new partTime(pName, pId, hourRate, hourswork);
                System.out.println(pName + "salary is :" + Employee1.calculateSalary());

            default:
                System.err.println("Enter the choice for above given !!!");
                System.exit(0);

                break;
        }
        sc.close();

    }
}
