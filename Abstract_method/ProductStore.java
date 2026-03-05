package Abstract_method;

import java.util.Scanner;

public class ProductStore
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Product Type :");
        System.out.println("1) digital Product ");
        System.out.println("2) Physical Product ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Product Name :");
                String name = sc.nextLine();

                System.out.println("Product Price :");
                double price = sc.nextDouble();
                sc.nextLine();

                System.out.println("Product Category :");
                String category = sc.nextLine();

                System.out.println("Product License Key :");
                String licenseKey = sc.nextLine();

                DigitalProduct dProduct = new DigitalProduct(name, price, category, licenseKey);

                System.out.println("Enter trge discount % on final bill ");
                double discount = sc.nextDouble();
                sc.nextLine();

                System.out.println("Digital Product :");
                System.out.println(dProduct);
                dProduct.applyDiscount(discount);
                dProduct.calculateTax();

                break;

            case 2:
                System.out.println("Product Name :");
                String name1 = sc.nextLine();

                System.out.println("Product Price :");
                double price1 = sc.nextDouble();
                sc.nextLine();

                System.out.println("Product Category :");
                String category1 = sc.nextLine();

                System.out.println("Product weight :");
                double weight = sc.nextDouble();
                sc.nextLine();

                PhysicalProduct Pproduct = new PhysicalProduct(name1, price1, category1, weight);

                System.out.println("Enter the discount % on final bill ");
                double discount1 = sc.nextDouble();
                sc.nextLine();
                System.out.println("Physical Product ");
                System.out.println(Pproduct);
                Pproduct.applyDiscount(discount1);
                Pproduct.calculateTax();
                Pproduct.calculateShippingCost();

                break;
            }
            sc.close();
    }

}


abstract class product
{
    private String name;
    private double price;
    private String category;

    public product(String name, double price, String category) {
        this.name = name;
        if (name.isEmpty() || name == null || name == "null") {
            System.err.println("Name can not be empty or null");
            System.exit(0);
        }
        this.price = price;
        if (price < 0) {
            System.err.println("Price cant be nagative !!");
            System.exit(0);
        }
        this.category = category;
        if (category.isEmpty() || category == null || category == "null")
            System.err.println("category can not be empty or null");
        System.exit(0);
    }

    public abstract void applyDiscount(double percentage);

    public abstract void calculateTax();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", category=" + category + "]";
    }

}

class DigitalProduct extends product {
    private String licensekey;

    public DigitalProduct(String name, double price, String category, String liceString) {
        super(name, price, category);
        this.licensekey = liceString;
        if (licensekey.isEmpty() || licensekey == null || licensekey == "null") {
            System.err.println("Licenseskey can not empty or null ");
            System.exit(0);
        }

    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = (getPrice() * percentage) / 100;
        System.out.println(discount);

        double updatePrice = getPrice() - discount;
        System.out.println(updatePrice);
    }

    @Override
    public void calculateTax() {
        double tax = (getPrice() * 5) / 100;
        System.out.println(tax);

    }

    @Override
    public String toString() {
        return super.toString() + "[licensekey=" + licensekey + "]";
    }

}

class PhysicalProduct extends product {
    private double shippingWeight;

    public PhysicalProduct(String name, double price, String category, double shippingWeight) {
        super(name, price, category);
        this.shippingWeight = shippingWeight;
        if (shippingWeight < 0) {
            System.err.println("Shipping weight can not be nagtive !!");
            System.exit(0);
        }

    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = (getPrice() * percentage) / 100;
        System.out.println(discount);
        double tax = (getPrice() * 8) / 100;
        System.out.println(tax);
    }

    @Override
    public void calculateTax() {
        double tax = (getPrice() * 8) / 100;
        System.out.println(tax);
    }

    public double calculateShippingCost() {

        return shippingWeight * 5;
    }

    @Override
    public String toString() {
        return super.toString() + "[shippingWeight=" + shippingWeight + "]";
    }

}


