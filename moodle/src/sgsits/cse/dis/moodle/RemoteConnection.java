package sgsits.cse.dis.moodle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoteConnection {
	public static final String  dbURL = "jdbc:mysql://localhost:3306/moodle";
	public static final String user = "root";
	public static final String pass = "root";
	/*public void establishSqlConnection() {
		Connection conn = null;
		 
        try {
 
            
            conn = DriverManager.getConnection(dbURL, user, pass);
            Statement st = conn.createStatement();
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                //System.out.println("Driver name: " + dm.getDriverName());
               // System.out.println("Driver version: " + dm.getDriverVersion());
               // System.out.println("Product name: " + dm.getDatabaseProductName());
                //System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}*/
	public static Connection getConnection()
    {
      try {
        //  DriverManager.registerDriver(new Driver());
          return DriverManager.getConnection(dbURL, user, pass);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
}
