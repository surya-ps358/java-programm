package EXepetionHandling;

import java.io.FileNotFoundException;

public class Test1
 {

    public static void main(String [] args){
        try{
            throw new FileNotFoundException("");
        }
        catch(FileNotFoundException e){
            System.out.println("Book list not found");
            //throw e;
        }
        }
    }
    
    

