package vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SimpleEXecuteQuery {

	@Test 
	public void Sample () throws SQLException {
		//step-1 : register the driver to db
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
	    //step 2: get the connection with database //give db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm27_info","root","admin");
		//step -3 : issue create statement
		Statement state=con.createStatement();
		
		//step -4 : Execute a query //give  table name
		ResultSet result=state.executeQuery("select * from customerinfo;");
		while(result.next()) {
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		
		//step -5 close the database 
		con.close();
		System.out.println("db closed ");
		
		
		
		
		
		
	}
	
}
