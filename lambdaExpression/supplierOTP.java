package lambdaExpression;

import java.util.function.Supplier;
import java.util.Random;

public class supplierOTP {
    public static void main(String[] args) {
    Random rd=new Random();
    {
        Supplier<String> OTP= () -> {
            int otp=rd.nextInt(1000);
            return String.format("%06d", otp);
        };
        System.out.println(OTP.get());
    }

}
}
