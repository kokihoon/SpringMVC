package test.java.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&useSSL=false&autoReconnection=true";
	private static final String USER = "kokihoon";
	private static final String PASSWORD = "123123";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			System.out.println(connection);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}	
