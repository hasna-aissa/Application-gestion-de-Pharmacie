/**
 * 
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_DB {
	public static Connection connectionWithDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacien","root","");
			System.out.println("connection établi");
			return con;
		}
		catch(Exception e1) {
			System.out.print(e1);
		}
		return null;
		
	}
	
}
