package database;

import java.sql.*;

public class DBConnection {
	
	public DBConnection(){}
	
	public Connection getConnection(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://118.179.70.102/tenantportal?serverTimezone=UTC","tenantportal","tenantportal");
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection;   
	}
}
