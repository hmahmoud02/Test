
// test hmm
import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://db.fancymacaron.com:3306", "funitemadmin" , "2%UvsewG&RCX1");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from employee_schema.users");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("username") + ", " + myRs.getString("nickname"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
