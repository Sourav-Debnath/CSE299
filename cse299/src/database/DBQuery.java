package database;

import java.math.BigInteger;
import java.sql.*;

public class DBQuery {
	Connection con;
	
	//constructor
	public DBQuery() {
		DBConnectionSingleton objDBConnection=DBConnectionSingleton.getInstance();
		con=objDBConnection.getConnection();
	}
	
	
	public boolean isEmailExists(String email){
		String query="Select id from user where email='"+email+"'";
		boolean flag=false;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			int size=0;
			if(rs != null) {
				rs.last();
				size = rs.getRow();
			}
			flag=(size == 1);			
		} catch (Exception e) {
		    System.out.println(e);
		}
		return flag;
	}
	
	public void resetPassword(String email) {
		if(isEmailExists(email)) {
			String query="Select pass from user where email='"+email+"'";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				rs.next();
				
				//-------------------Fix here to get the password via email
			    System.out.println("Password :"+rs.getString("pass"));			    
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/*
	 * this function can entry an user into the database
	 * if there is no problem with duplication of same user the function returns "Insertion Successful"
	 * else the function returns the problematic entry & key
	 */
	public String signUp(BigInteger Nid,String Name,String ContactNo,String Address,String Image,String Email,String Pass) {
		String message="Insertion Successful";
		String query="INSERT INTO `user`(`Nid`, `Name`, `ContactNo`, `Address`, `Image`, `Email`, `Pass`) VALUES ("
				+ Nid+",\""+Name+"\",\""+ContactNo+"\",\""+Address+"\",\""+Image+"\",\""+Email+"\",\""+Pass+"\")";
		System.out.println(query);
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();						    
		}catch (Exception e) {
			message=e.getMessage();
		}
		return message;
	}
	
	/*
	 * this function can check if the user is giving right email and password to log in.
	 * if everything is right then it returns "Logged In"
	 * if the email is wrong then it returns "Wrong Email"
	 * if the password is wrong then it returns "Wrong Password"
	 */
	public String login(String Email,String Password) {
		String flag=null;
		if(isEmailExists(Email)) {
			String query="Select pass from user where email='"+Email+"'";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				rs.next();
				System.out.println(rs.getString("pass"));
				if(rs.getString("pass").equals(Password)) {
					flag="Logged In";
				}else {
					flag="Wrong Password";
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}else {
			flag="Wrong Email";
		}
		return flag;
	}


}
