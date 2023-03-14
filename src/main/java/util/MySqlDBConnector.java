package main.java.util;
import java.sql.*;

public class MySqlDBConnector{
    public static Connection makeConnection(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pet_care?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"
            		,"petcare_webapp_user"
            		,"petcare_webapp_user"
            		);
            return con;
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from customer");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//            con.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return null;
    }
}
