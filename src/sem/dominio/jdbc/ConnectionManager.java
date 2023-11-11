package sem.dominio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection conexao = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//aqui emplemente a conexão para teste
			/**
			 * conexao = DriverManager.getConnection(
			 * "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "OPS$XXXX", "XXXXX");
			 **/

			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as SYSDBA", "Passw0rd");

		} catch (SQLException e) {
			System.err.println("Não foi possivel conectar ao banco de dados");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("O driver JDBC não foi encontrado!");
			e.printStackTrace();
		}
		return conexao;
	}

}