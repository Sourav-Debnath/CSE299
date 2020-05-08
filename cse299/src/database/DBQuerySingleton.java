package database;

import java.sql.*;

import security.Hash;

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
		String query="Select nid from user where email='"+email+"'";
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
			String query="Select password from user where email='"+email+"'";
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
	public String createPost(int ownerId,int flatId,String postText,Date postDate,Time postTime,float lat,float lang ) {
		String message="Insertion Successful";
		String query="INSERT INTO `ownerpost`( `ownerId`, `flatId`, `postText`, `postDate`, `postTime`, `lat`, `lang`) VALUES ("
				+ ownerId+","+ flatId+",\""+ postText +"\",\""+ postDate +"\",\""+postTime+"\","+lat+","+lang+") ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();
		}catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}
	
	/*
	 * this function can show posts
	 * that match with the searched area
	 */
	public Post[] searchPost(String areaName) {
		Post post[]=null;
		String query="SELECT `postText`,`postDate`,`postTime`,`lat`,`lang`,`houseNo`,`flatNo`,`floorNo`,`size`,"
				+ "`noBedRoom`,`noBathRoom`,`price`,`flatPic`,`facing`,`roadNo`,`blockNo`,`areaName`,`district`" + 
				"FROM `ownerpost`,`flat`,`road`" + 
				"WHERE ownerpost.flatId = flat.flatId AND flat.roadId = road.roadId AND `areaName` = \""+areaName+
				"\" ORDER BY `postDate` DESC, `postTime` DESC";
		System.out.println(query);
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			//-------------------to know the size of the result set
			rs.last();
			int size = rs.getRow();
			post = new Post[size];
			
			//-------------------keeps the result set data into the array
			rs.beforeFirst();
			for(int i=0;i<size;i++) {				
				rs.next();
				post[i]=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getInt(6),
						rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getString(13),
						rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18));
			}
		}catch (Exception e) {
			System.out.println( e.getMessage());
		}
		return post;
	}
	
	/*
	 * this function can shows posts
	 * created by owners in the portal
	 * in a descending order of date and time
	 * it takes the pageIndex and
	 * shows the Posts according to it
	 */
	public Post[] showPortalPosts(int pageNo,int loadSize) {
		Post[] post=null;
		String query="SELECT `postText`,`postDate`,`postTime`,`lat`,`lang`,`houseNo`,`flatNo`,`floorNo`,`size`,"
				+ "`noBedRoom`,`noBathRoom`,`price`,`flatPic`,`facing`,`roadNo`,`blockNo`,`areaName`,`district`"
				+ " FROM `ownerpost`,`flat`,`road` WHERE ownerpost.flatId = flat.flatId AND flat.roadId = road.roadId"
				+ " ORDER BY `postDate` DESC, `postTime` DESC";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			//-------------------to know the size of the result set
			rs.last();
			int size=rs.getRow();
			post=new Post[size];
			
			//-------------------keeps the result set data into the array
			rs.beforeFirst();
			for(int i=loadSize*(pageNo-1);i<loadSize*pageNo;i++) {
				if(i<size) {
					rs.next();
					post[i]=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getInt(6),
							rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getString(13),
							rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18));
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
	public Post postDetails(int postId) {
		Post post=null;
		String query="SELECT `postText`,`postDate`,`postTime`,`lat`,`lang`,`houseNo`,`flatNo`,`floorNo`,`size`,"
				+ "`noBedRoom`,`noBathRoom`,`price`,`flatPic`,`facing`,`roadNo`,`blockNo`,`areaName`,`district`" + 
				"FROM `ownerpost`,`flat`,`road`" + 
				"WHERE ownerpost.flatId = flat.flatId AND flat.roadId = road.roadId AND `postId` = \""+postId+
				"\" ORDER BY `postDate` DESC, `postTime` DESC";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			post=new Post(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getFloat(5),rs.getInt(6),
					rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getString(13),
					rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18));
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
		String query="SELECT `nid`, `name`, `contactNo`, `address`, `email` FROM `user` Where `nid`="+id;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			profile=new Profile(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}catch (Exception e) {
			System.out.println( e.getMessage() );
		}
		
		return profile;
	}
	
	/*
	 * this function can update the name, contactNo, address,
	 * email, pass of the database provided the Nid
	 */
	public void editPost(String Nid,String Name,String ContactNo,String Address,String Email,String Pass) {
		String encriptedPass = Hash.getMd5(Pass);
		String query="UPDATE `user` SET `name`=\""+Name+"\",`contactNo`=\""+ContactNo+"\",`address`=\""+Address+"\",`email`=\""+Email+"\",`password`=\""+encriptedPass+"\" WHERE nid=\""+Nid+"\"";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	 * this function can entry an user into the database
	 * if there is no problem with duplication of same user the function returns "Insertion Successful"
	 * else the function returns the problematic entry & key
	 */
	public String signUp(String Nid,String Name,String ContactNo,String Address,String Email,String Pass) {
		String message="Insertion Successful";
		String encriptedPass = Hash.getMd5(Pass); 
		String query="INSERT INTO `user`(`nid`, `name`, `contactNo`, `address`, `email`, `password`) VALUES (\""
				+ Nid+"\",\""+Name+"\",\""+ContactNo+"\",\""+Address+"\",\""+Email+"\",\""+encriptedPass+"\")";
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
			String query="Select password from user where email='"+Email+"'";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				rs.next();
				System.out.println(rs.getString("password"));
				if(rs.getString("password").equals(Hash.getMd5(Password))) {
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
