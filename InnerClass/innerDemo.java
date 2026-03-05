
 interface fan{
    public void fanOn();

    
}
class coil implements fan{

    @Override
    public void fanOn() {
       System.out.println("Fan is on !!! :");

    }
    
}
public class innerDemo{
    public static void main(String[] args) {
        
        // fan a=()->System.out.println("Fan is on .");
        // a.fanOn();
        fan a =new coil();
        a.fanOn();
}
}