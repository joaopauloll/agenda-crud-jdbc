package agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// private static final String USERNAME = "root";
	// private static final String PASSWORD = "password";
	// private static final String DATABASE_URL =
	// "jdbc:mysql://localhost:3306/agenda";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/agenda";

	public static Connection createConnectionToMySQL() {
		// try {
		// // Carrega o driver JDBC do banco de dados
		// // Class.forName("com.mysql.cj.jdbc.Driver");
		// Class.forName("org.postgresql.Driver");
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }

		Connection connection = null;
		try {
			// Cria a conexão com o banco de dados
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void main(String[] args) {

		Connection connection = createConnectionToMySQL();
		try {
			// Fechar a conexão se não for nula, garantindo que não tenha mais do que uma
			// conexão necessária
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
