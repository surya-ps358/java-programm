package EXepetionHandling;

public class CommandLineDivision {
    public static void main(String[] args) 
    {   try{
        if(args.length != 2){
            throw new IllegalArgumentException("Exactly two argumnets can are you pass !!");
        }
    try{
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);

    double result=a/b;
    System.out.println("division is :"+result);
    }
    catch(ArithmeticException e){
        System.err.println("Arithmetic Error :"+e.getMessage());
    }
}
    catch(IllegalArgumentException e){
        System.err.println(e.getClass().getSimpleName()+ ": "+e.getMessage());
    }
    finally{
        System.out.println("dividion is Completed");
    }

        
    }
}
