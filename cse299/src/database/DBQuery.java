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
	
	public void signUp(BigInteger Nid,String Name,String ContactNo,String Address,String Image,Boolean ActiveStatus,String Email,String Pass) {
		String query="INSERT INTO `user`(`Nid`, `Name`, `ContactNo`, `Address`, `Image`, `ActiveStatus`, `Email`, `Pass`) VALUES ("
				+ Nid+",\""+Name+"\",\""+ContactNo+"\",\""+Address+"\",\""+Image+"\","+ActiveStatus+",\""+Email+"\",\""+Pass+"\")";
		System.out.println(query);
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();						    
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void login(String Email,String Password) {
		if(isEmailExists(Email)) {
			String query="Select pass from user where email='"+Email+"'";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				rs.next();
				System.out.println(rs.getString("pass"));
				if(rs.getString("pass").equals(Password)) {
					System.out.println("Right Password");
				}else {
					System.out.println("Wrong Password");
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}else {
			System.out.println("Wrong Email. Please Check again.");
		}
	}
	
	public static void main(String[] args) {
		DBQuery objDBQuery=new DBQuery();
		objDBQuery.login("Email", "Password");
	}

}
