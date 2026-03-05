package database_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demoDatabase {

    public static void main(String[] args) {

        try {

            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/suryadb",
                    "root",
                    "surya358"
            );

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Insert Query
            String query = "INSERT INTO student VALUES(1,'Surya')";

            int i = stmt.executeUpdate(query);

            if(i > 0) {
                System.out.println("Data Inserted Successfully");
            }

            // 5. Close Connection
            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}