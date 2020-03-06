package database;

import java.sql.*;

public class DBConnection {
	
	public DBConnection(){}
	
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
