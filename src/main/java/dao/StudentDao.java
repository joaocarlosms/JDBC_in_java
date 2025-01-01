package dao;

import java.sql.Connection;

import connectionJDBC.SingleConnection;

public class StudentDao {
	private Connection connection;
	
	public StudentDao() {
		connection = SingleConnection.getConnection();
	}
}
