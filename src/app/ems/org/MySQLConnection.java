package app.ems.org;

import static app.ems.org.Properties.*;

import java.sql.*;

import javax.swing.JOptionPane;


public class MySQLConnection {  
            
	  static Connection con=null;  

        static {
        	
             try {
				Class.forName(DRIVER_NAME);
				 con= DriverManager.getConnection(CONNECTION_URL+DATABASE_NAME, DATABASE_USER_NAME, DATABASE_PASSWORD);  
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				 JOptionPane.showMessageDialog(null,"Database main connection error ","Error !",JOptionPane.ERROR_MESSAGE); 
				e.printStackTrace();
			}         
            
        }
        

         public static Connection getConnection()throws ClassNotFoundException, SQLException  
         {  
              return con;  
         }  
}