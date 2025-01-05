package dao;

import java.beans.beancontext.BeanContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionJDBC.SingleConnection;
import model.BeanStudentPhone;
import model.Phone;

public class PhoneDao {
	private Connection connection;
	
	public PhoneDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void savePhone(Phone phone) throws Exception {
		
		try {
			
			String sql = "INSERT INTO phone_student(number_phone, type_phone, student_phone) VALUES (?, ?, ?);";
				
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, phone.getNumber_phone());
			statement.setString(2, phone.getType_phone());
			statement.setLong(3, phone.getStudent_phone());
			statement.execute();
			
			connection.commit();
			
		} catch(SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
	
	public List<BeanStudentPhone> getListStudentPhone(Long idStudent) throws Exception {
		List<BeanStudentPhone> st_phones = new ArrayList<BeanStudentPhone>();
		
		String sql = "SELECT name_st, number_phone, email FROM phone_student AS phone";
		sql += " INNER JOIN student AS stdt";
		sql += " ON phone.student_phone = stdt.id";
		sql += " WHERE stdt.id = "+idStudent;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			BeanStudentPhone studentPhone = new BeanStudentPhone();
			studentPhone.setName_st(resultSet.getString("name_st"));
			studentPhone.setNumber_phone(resultSet.getString("number_phone"));
			studentPhone.setEmail(resultSet.getString("email"));
			
			st_phones.add(studentPhone);
		}
		
		return st_phones;
	}
	
	public void deletePhoneByStudent(Long idStudent) throws Exception {
		String sqlPhone = "DELETE FROM phone_student WHERE student_phone = "+idStudent;
		String sqlStudent = "DELETE FROM student WHERE id = "+idStudent;
		
		PreparedStatement statement = connection.prepareStatement(sqlPhone);
		statement.executeUpdate();
		connection.commit();
		
		statement = connection.prepareStatement(sqlStudent);
		statement.executeUpdate();
		connection.commit();
	}
}
















