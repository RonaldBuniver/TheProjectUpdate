package utilities;

import java.sql.DriverManager;


public class ManageDB extends CommonOps{

    public static void openConnection(String dbURL , String user , String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL , user , pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while connecting to DB, See Details: " + e);
        }
    }
    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
                System.out.println("Error Occurred while Closing to DB, See Details: " + e);
        }
    }



}
