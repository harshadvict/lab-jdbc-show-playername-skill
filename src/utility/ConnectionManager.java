package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//load the driver 
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","1129ku");
		if(con!=null) {
			System.out.println("connection established");
		}
		else {
			System.out.println("connection failure");
		}
		return con;
		
	}
}

