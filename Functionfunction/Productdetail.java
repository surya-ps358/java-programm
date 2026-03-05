package Functionfunction;

import java.util.Scanner;
import java.util.function.Function;

class Product{
    int id;
    String name;
    double price;

    public Product(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;

    }
}
    public class Productdetail{
        public static void main(String[]args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Product id ");
             int id=Integer.parseInt(sc.nextLine());

             System.out.println("Enter the product Name");
             String name=sc.nextLine();

             System.out.println("Enter this Product price");
             double price=Double.parseDouble(sc.nextLine());
             if(price <= 0){
                System.out.println("Invalid Price");
                return ;

             }

                    Product product=new Product(id,name,price);
                    Function<Product,Double> studentdiscount= p ->
                    {
                        if(p.price >=5000){
                            return p.price-(p.price*10)/100;
                        }
                        else
                        {
                            return p.price-(p.price*5)/100;
                        }
                    };

                    double result=studentdiscount.apply(product);
                    System.out.println("Final price of the product is :"+result);
        }
    }


