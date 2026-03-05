package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class jdbcPro14 {

    String driver = "oacle.jdbc.OracleDriver";
    String durl = "jdbc";
    String username = "root";
    String password = "root";

    public jdbcPro14(String driver, String durl) {
        this.driver = driver;
        this.durl = durl;
    }

    public jdbcPro14() {
    }

    public void meth1() {

        System.out.println("Implementing Metadata in JDBC");

        try {

            Connection con = connect();

            // Database Metadata
            DatabaseMetaData dmtdt = con.getMetaData();

            System.out.println("Database Product Name: " + dmtdt.getDatabaseProductName());
            System.out.println("Database Version: " + dmtdt.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dmtdt.getDriverName());
            System.out.println("Supports Stored Procedures: " + dmtdt.supportsStoredProcedures());

            // SQL Query
            String sqlquery = "select * from student";

            PreparedStatement ps = con.prepareStatement(sqlquery);

            System.out.println("Parameter Metadata: " + ps.getParameterMetaData());

            ResultSet rs = ps.executeQuery();

            // ResultSet Metadata
            ResultSetMetaData rtdt = rs.getMetaData();

            System.out.println("Column Count: " + rtdt.getColumnCount());
            System.out.println("First Column Name: " + rtdt.getColumnName(1));
            System.out.println("Column Display Size: " + rtdt.getColumnDisplaySize(1));
            System.out.println("Is Auto Increment: " + rtdt.isAutoIncrement(1));

            // RowSet Example
            RowSetFactory rsf = RowSetProvider.newFactory();
            CachedRowSet crs = rsf.createCachedRowSet();

            crs.setUrl(durl);
            crs.setUsername(username);
            crs.setPassword(password);
            crs.setCommand(sqlquery);

            crs.execute();

            while (crs.next()) {
                System.out.println("RowSet Data: " + crs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection connect() {

        Connection con = null;

        try {

            Class.forName(driver);

            con = DriverManager.getConnection(
                    durl,
                    username,
                    password
            );

            System.out.println("Connection Established");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {

        jdbcPro14 obj = new jdbcPro14();
        obj.meth1();

    }
}