package sgsits.cse.dis.moodle;

import java.sql.SQLException;

import sgsits.cse.dis.moodle.database.DBConnection;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DBConnection connection = new DBConnection();
		connection.create_connection();
		
		Quiz quiz = new Quiz();
		quiz.getQuizGrade();

	}

}
