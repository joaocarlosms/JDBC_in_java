package connectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String database = "jdbc:postgresql://localhost:5432/jdev_training";
	private static String password = "admin";
	private static String user = "myuser";
	private static Connection connection = null;
	
	static {
		connect();
	}
	
	public SingleConnection() {
		connect();
	}
	
	public static void connect() {
		try {
			
			if(connection == null || connection.isClosed()) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(database, user, password);
				connection.setAutoCommit(false);
				System.out.println("Connected with success!");
			}
			
		} catch(Exception e) {
			e.printStackTrace();;
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
