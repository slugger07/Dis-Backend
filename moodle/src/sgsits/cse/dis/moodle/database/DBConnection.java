package sgsits.cse.dis.moodle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import sgsits.cse.dis.moodle.constants.DBConnectionConstants;;

public class DBConnection {
	
	public static Statement stmt;
    public static Connection con;

    public void create_connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(DBConnectionConstants.DBURL, DBConnectionConstants.DBUSERNAME, DBConnectionConstants.DBPASSWORD);
        stmt = con.createStatement();
    }

}
