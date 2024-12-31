package pos_java_jdbc.pos_java_jdbc;

import org.junit.jupiter.api.Test;

import connectionJDBC.SingleConnection;

public class TestDatabaseJDBC {
	
	@Test
	public void initDatabase() {
		SingleConnection.getConnection();
	}
}
