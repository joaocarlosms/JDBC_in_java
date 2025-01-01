package connectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String database = "jdbc:postgresql://localhost:5432/jdev_training";
	private static String password = "admin";
	private static String user = "myuser";
	private static Connection connection = null;
	
	/*Utilizar o static dessa forma, automatiza nossa conexão
	 * com o database toda vez que a classe seja instanciada
	 * dessa forma, garantimos que a primeira coisa ser instanciada
	 * na classe seja esse metodo static*/
	static {
		connect();
	}
	
	/*Utilizamos nosso metodo connect no constructor para
	 * caso a conexão com o nosso databsae não seja estabelecida,
	 * ao utilizar o construtor, ele estabelece a conexão com o db.
	 * Mesmo que ele consiga estabelecer a conexão no nosso metodo static
	 * ele ainda passa pelo constructor só para garantir que está
	 * tudo de acordos*/
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
