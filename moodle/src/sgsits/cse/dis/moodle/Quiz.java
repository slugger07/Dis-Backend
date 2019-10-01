package sgsits.cse.dis.moodle;

import java.sql.*;

import sgsits.cse.dis.moodle.database.DBConnection;

public class Quiz 
{
	DBConnection conn = new DBConnection();
	
	public void getQuizGrade() 
	{
		try 
		{
			DBConnection conn = new DBConnection();
			String query = "SELECT grade FROM mdl_quiz_grades where id = 2";
			ResultSet rs = conn.stmt.executeQuery(query);
			if(rs!=null)
			while(rs.next())
			{			
				System.out.print("ID: " + rs.getFloat(1));
			}
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
	}
}
