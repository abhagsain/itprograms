
package javadatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static javadatabase.JavaDatabase.DB_URL;


public class Callable {
    static final String DB_URL="jdbc:mysql://localhost/db";
    static final String USER="root";
    static final String PASSWORD="keshav";
    public static void main(String args[]) throws SQLException
    {
                      Connection conn=null;
                      CallableStatement astmt=null;
                      
                      try
                      {
                         
                      Class.forName("com.mysql.jdbc.Driver");
           
                      System.out.println("Connecting to Database");
                      conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
                      System.out.println("Creating Statements...");
                      String sql="call getRows(?)";
                      astmt=conn.prepareCall(sql);
                      astmt.registerOutParameter(1,java.sql.Types.INTEGER);
                      astmt.execute();
                      System.out.println("Total Students"+astmt.getInt(1));
                      }
                      catch(SQLException se)
                        {
                        se.printStackTrace();
                        }
                      catch(Exception e)
                        {
                      e.printStackTrace();
                        }
    }
}
//DELIMITER $$
//DROP PROCEDURE IF EXISTS `db`.`getRows` $$
//CREATE PROCEDURE `db`.`getRows` 
//   (OUT stu_rows VARCHAR(255))
//BEGIN
//   SELECT count(*) INTO stu_rows
//   FROM student;
//  
//END $$
//
//DELIMITER ;