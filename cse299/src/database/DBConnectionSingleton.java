package tenantPortal;

import java.sql.*;

public class DBConnectionSingleton {
	private static DBConnectionSingleton instance = new DBConnectionSingleton();
	
	private DBConnectionSingleton(){}

	public static DBConnectionSingleton getInstance() {
		return instance;
	}
	
	public Connection getConnection(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://118.179.64.218/tenantportal?serverTimezone=UTC","cse299","cse299");
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection;   
	}
}
