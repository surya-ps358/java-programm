public class q36 
{
        public static void main(String[] argv)
        {
               MySubclass my = new MySubclass();
               my.calc(1);
               my.calc1(1.1F);
               System.out.println(my.getClass().getName());
        }
}
class MyClass
{
        public void calc(int i)
        {
                System.out.println("public void calc(int i)");
        }
}
class MySubclass extends MyClass
{
         public void calc1(float f)
         {
                 System.out.println("public void calc(int f)");
         }

         public void calc(float f, float g) {
               
                throw new UnsupportedOperationException("Unimplemented method 'calc'");
         }
}
