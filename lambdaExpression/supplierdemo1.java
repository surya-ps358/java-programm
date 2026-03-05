package lambdaExpression;

import java.util.function.Supplier;

class product{
    String fruit="mango";

    public String toString(){
        return fruit;

    }
}
public class supplierdemo1 {
    public static void main(String[] args) {


        Supplier<product> foo = () ->{
        product p=new product();
        p.fruit="Grapes";
        return p;

    };

    product result=foo.get();
    System.out.println(result);
    }
}
