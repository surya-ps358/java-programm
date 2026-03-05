public class a19
{
       public static void main(String[] argv)
       {
              System.out.println(doStuff());
       }
       static boolean doStuff() 
       {
              for (int x = 0; x < 5;) 
              {
                     System.out.println("in for loop");
                     return true;
              }
              return false;
       }
    }
