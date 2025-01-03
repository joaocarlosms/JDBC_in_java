package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import connectionJDBC.SingleConnection;
import dao.StudentDao;
import model.Student;

public class TestDatabaseJDBC {
	
	@Test
	public void initDatabase() {
		StudentDao studentDao = new StudentDao();
		Student st = new Student();
		st.setNameSt("zezinho2");
		st.setEmail("zezin@gmail.com");
		
		studentDao.saveStudent(st);
	}
	
	@Test
	public void initGetAllStudentsFromDatabase() throws Exception {
		StudentDao stDao = new StudentDao();
			
		List<Student> allStudents = stDao.getAllStudents();
			
		for(Student st : allStudents) {
			System.out.println(st);
		}
	}

	@Test
	public void initGetStudentById() throws Exception {
		StudentDao stDao = new StudentDao();
				
		Student st = stDao.getStudentById(5L);
		System.out.println(st);
	}
	
	@Test
	public void initUpdateStudent() throws Exception {
		StudentDao stDao = new StudentDao();
		
		Student new_st = stDao.getStudentById(1L);
		new_st.setNameSt("João Atualizado");
		
		stDao.updateStudent(new_st);
	}
}
