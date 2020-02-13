package tenantPortal;

import java.sql.*;

public class DBQuery {
	DBConnectionSingleton objDBConnection=DBConnectionSingleton.getInstance();
	Connection con=objDBConnection.getConnection();
	
	public void resetPassword(){		
		
		try {
		    String query="";
		    PreparedStatement ps=con.prepareStatement(query);
		} catch (Exception e) {
		    System.out.println(e);
		}
	}

}
