public class q42
{
      public static void main(String[] argv) 
      {
            a("a");
            a("a", "b");
            a("a", "b", "c");
      }
      static void a(String... string) 
      {
         System.out.println(string);
      }
}

