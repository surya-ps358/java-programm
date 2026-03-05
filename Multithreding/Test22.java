package Multithreding;

 class Multithread extends Thread{

    @Override
    public void run(){
        System.out.println("Hi shivam");
        super.run();
    }
    @Override
    public synchronized void start(){
        System.out.println("hello Amar");
        super.start();
    }
    
}
public class Test22{
    public static void main(String[] args) {
        nit();

        
    }
    public static void nit(){
        System.out.println("hello Imran...");
        Multithread mt1=new Multithread();
        mt1.start();
    }
}


