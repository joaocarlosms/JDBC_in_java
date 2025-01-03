package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionJDBC.SingleConnection;
import model.Student;

public class StudentDao {
	private Connection connection;
	
	public StudentDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveStudent(Student student) {
		try {
			
			String sql = "INSERT INTO student (id, name_st, email) VALUES (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, student.getId());
			insert.setString(2, student.getNameSt());
			insert.setString(3, student.getEmail());
			insert.execute(); //executa o comand sql
			connection.commit();
			
		} catch(Exception e) {
			
			try {
				connection.rollback(); //reverte operações no db
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudents() throws Exception {
		List<Student> listStudent = new ArrayList<Student>();
		
		String sql = "SELECT * FROM student";
		
		PreparedStatement statement = 	connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		
		while(resultset.next()) {
			Student st = new Student();
			st.setId(resultset.getLong("id"));
			st.setNameSt(resultset.getString("name_st"));
			st.setEmail(resultset.getString("email"));
			
			listStudent.add(st);
		}
		
		return listStudent;
	}
}



			












