package pos_java_jdbc.pos_java_jdbc;

import org.junit.jupiter.api.Test;

import connectionJDBC.SingleConnection;
import dao.StudentDao;
import model.Student;

public class TestDatabaseJDBC {
	
	@Test
	public void initDatabase() {
		StudentDao studentDao = new StudentDao();
		Student st = new Student(2L, "João Carlos", "jc@gmail.com");
		
		studentDao.saveStudent(st);
	}
}
