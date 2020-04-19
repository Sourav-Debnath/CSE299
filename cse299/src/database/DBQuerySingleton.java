package database;

import java.math.BigInteger;
import java.sql.*;

public class DBQuerySingleton {
	Connection con;
	private static DBQuerySingleton instance = new DBQuerySingleton();
	
	//constructor
	private DBQuerySingleton() {
		DBConnection objDBConnection=new DBConnection();
		con=objDBConnection.getConnection();
	}
	
	//getter
	public static DBQuerySingleton getInstance() {
		return instance;
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
	 * this function can entry an post into the database
	 * if the insertion succeed it returns "Insertion Successful"
	 * else the function returns the problematic entry & key
	 */
	public String createPost(int ownerId,String postText,Date postDate,Time postTime,float xCoordinate,float yCoordiate ) {
		String message="Insertion Successful";
		String query="INSERT INTO `ownerpost`( `ownerId`, `postText`, `postDate`, `postTime`, `xCoordinate`, `yCoordinate`) VALUES ("
				+ ownerId+",\""+ postText +"\",\""+ postDate +"\",\""+postTime+"\","+xCoordinate+","+yCoordiate+") ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();
		}catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}

	/*
	 * this function can shows posts
	 * created by owners in the portal
	 * in a descending order of date and time
	 * it takes the pageIndex and
	 * shows the Posts according to it
	 */
	public Post[] showPortalPosts(int pageIndex) {
		Post[] post=null;
		String query="SELECT `PostText`, `PostDate`, `PostTime`, `xCoordinate`, `yCoordinate` FROM `ownerpost` ORDER BY `PostDate` DESC, `PostTime` DESC";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			//-------------------to know the size of the result set
			rs.last();
			int size=rs.getRow();
			post=new Post[size];
			
			//-------------------keeps the result set data into the array
			rs.beforeFirst();
			for(int i=10*(pageIndex-1);i<10*pageIndex;i++) {
				if(i<size) {
					rs.next();
					post[i]=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5));
				}				
			}
		}catch (Exception e) {
			System.out.println( e.getMessage());
		}
		return post;
		
	}
	
	/*
	 * This function can retrieve the post
	 * that matches PostId
	 */
	public Post postDetails(int PostId) {
		Post post=null;
		String query="SELECT `PostText`, `PostDate`, `PostTime`, `xCoordinate`, `yCoordinate` FROM `ownerpost` Where `PostId`="+PostId;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			post=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5));
		}catch (Exception e) {
			System.out.println( e.getMessage() );
		}
		
		return post;
	}
	
	/*
	 * This function can retrieve the profile
	 * that matches id
	 */
	public Profile profileDetails(String id) {
		Profile profile=null;
		String query="SELECT `Nid`, `Name`, `ContactNo`, `Address`, `Image`, `Email` FROM `user` Where `Nid`="+id;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			profile=new Profile(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
		}catch (Exception e) {
			System.out.println( e.getMessage() );
		}
		
		return profile;
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
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}else {
			flag="Wrong Email Or Password";
		}
		return flag;
	}
	
}
