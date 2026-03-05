public class q37 
{

    public static void main(String[] args) {
        q37 q=new q37();
        MyClass s = q.new MyClass();
        s.calc(1,2);
        s.calc(1.1F, 1.0F);

    }

    class MyClass
    {
        public void calc(int i,int j)
        {
            System.err.println("public void cal(int i,int j)from my class");
        }
        public void calc(float f,float f1)
        {
            System.out.println("public void calc(float f,float f1) from MyClass");
        }
        class MySubclass extends MyClass{
            public void calc(int i,int j){
                System.out.println("public void calc(int i,intj) from MySubclass");
            }

        }
    }
}
