package tenantPortal;

import java.sql.*;

public class DB_Connection_Singleton {
	private static DB_Connection_Singleton instance = new DB_Connection_Singleton();
	
	private DB_Connection_Singleton(){}

	public static DB_Connection_Singleton getInstance() {
		return instance;
	}
	
	public Connection get_connection(){
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
