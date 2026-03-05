package lambdaExpression;

import java.util.function.Supplier;


public class SupplierDemo2 {
    public static String message(){
        return "Hello Pandurang";
     }
    public static void main(String[] args) {
        
        //sms s=new sms();
        Supplier<String> smSupplier=() ->message();
        System.out.println(smSupplier.get());

    }
}
