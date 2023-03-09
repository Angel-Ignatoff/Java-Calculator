
package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;

public class DBUtility  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String stored_username = null;
	private String stored_password = null;
	// Connection object is the session between java application and the database
	// the ResultSet object refers to the row and column data and maintains a cursor that points to the current row in the result set.
	public Connection con = null;
	public ResultSet rs = null;

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); //  <<< The suitable driver for connecting to the database.
		String dbname = "group_d_dbs"; //  <<<<< the database name
		String url = "jdbc:mysql://129.151.75.225/" + dbname; // <<<<<<<<< the database IP address 
		String username = "202102_group_d";  // <<<<<<<<<<<< the database user name used for logging in
		String password = "Groupd-z49qff"; //<<<<<< the database password used for logging in
		return DriverManager.getConnection(url, username, password);
	}
	// The above method ^^^ is used for getting connected to the database 
	//it has the password user name and IP address required for connecting to the right database.

	public boolean checkCredentials(String uname , String pwd) throws ClassNotFoundException, SQLException{
		boolean a = false;

		Statement stmt = con.createStatement(); //Creating statement object that is gotten from connection
		ResultSet rs = stmt.executeQuery("SELECT * FROM Angel;"); //create the table or rename it

		while (rs.next()) {
			System.out.println(rs.getString("idAngel")); 
			this.stored_username = rs.getString("USER"); //gets the data from the column Uname and stores it
			this.stored_password = rs.getString("PASSWORD"); //gets the data from the column password and stores it

			if(uname.equals(this.stored_username) && pwd.equals(this.stored_password)){ // Checking if they match with what user inputed.
				a = true; 
			}
		}
		return a;
	}
	// the above ^^^^ method is called in the login servlet to check the parameters of uname and pwd 
	//if the parameter match with the data in username and password column. If it does it will log in else error message.

	public boolean StoreNum(String Uname, String Hexa_Num , String Binary_Num, String Decimal_Num) throws SQLException
	{
		boolean sts = false;
		String MysqlQuery = "INSERT INTO `group_e_dbs`.`Angel-Ignatoff_History` (`Uname`, `Octal_Num Value`, `Binary_Num Value`, `Decimal_Num Value`) VALUES (?, ?, ?, ?);"; 
		PreparedStatement preparedStmt = con.prepareStatement(MysqlQuery); //Creating statement object that is gotten from connection
		preparedStmt.setString(1, Uname);
		preparedStmt.setString(2, Hexa_Num);
		preparedStmt.setString(3, Binary_Num);
		preparedStmt.setString(4, Decimal_Num);
		System.out.println(preparedStmt);
		preparedStmt.execute();  
		sts = true;
		{
			return sts;
		}
	}
	// The above ^^^^^^ method is called in the Converter servlet to input the history of the user into the appropriate columns of the database


	public boolean StoreUser(String FullName, String Uname, String Password ) throws SQLException  {
		boolean sts= false;

		String MysqlQuery = "INSERT INTO `group_d_dbs`.`Angel-Ignatoff_Users` (`Full Name`, `Uname`, `Password`) VALUES (?, ?, ?);";
		PreparedStatement preparedStmt = con.prepareStatement(MysqlQuery); //Creating statement object that is gotten from connection
		preparedStmt.setString(1, FullName);
		preparedStmt.setString(2, Uname);
		preparedStmt.setString(3, Password);
		System.out.println(preparedStmt);
		preparedStmt.execute();
		sts = true;
		{
			return sts;
		}	
	}
	// The above ^^^^^ method is called in the User_Info servlet this method is used to input the user information into the appropriate columns of the database

	public ResultSet recallHistory(String uname) throws SQLException {

		Statement statement = con.createStatement();  //Creating statement object that is gotten from connection
		ResultSet recall = statement.executeQuery("SELECT * FROM group_d_dbs.Angel-Ignatoff_History where Uname like '" + uname + "'");
		return recall;
	}
	// The above ^^^^ method is called in the User_Info servlet in order to retrieve users history.

	public void connectToDB() throws ClassNotFoundException, SQLException {
		con = getConnection();
		System.out.println("Connected To Database");
	}
	//The above method ^^^^ is used to connect to the database and is called whenever we want to connect to the database.

	public void store_user(String firstName, String lastName, String userName, String password) {
		// TODO Auto-generated method stub
		
	}

	public Object getprbMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}