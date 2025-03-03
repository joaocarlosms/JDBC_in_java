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
			
			String sql = "INSERT INTO student (name_st, email) VALUES (?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, student.getNameSt());
			insert.setString(2, student.getEmail());
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
	
	public Student getStudentById(Long id) throws Exception {
		Student st_found = new Student();
		
		String sql = "SELECT * FROM student WHERE id = "+id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			st_found.setId(resultSet.getLong("id"));
			st_found.setNameSt(resultSet.getString("name_st"));
			st_found.setEmail(resultSet.getString("email"));
		}
		
		return st_found;
	}
	
	public void updateStudent(Student new_st) throws Exception {
		try {
			
			String sql = "UPDATE student SET name_st = ? WHERE id = "+new_st.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, new_st.getNameSt());
			
			statement.execute();
			connection.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentById(Long id) throws Exception {
		try {
			
			String sql = "DELETE FROM student WHERE id = "+id;
		
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.execute();
			connection.commit();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}



			












