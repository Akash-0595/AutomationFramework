package vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SimpleExecuteUpdate {

	@Test
	public void Simp() throws SQLException {
		//step-1 ; register the driver to db
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
			    //step 2: get the connection with database //give db name
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wscm27_info","root","admin");
				//step -3 : issue create statement
				Statement state=con.createStatement();
				
				//step -4 : Execute a query //give  table name
				 String query="insert into customerinfo values(('maxwell',25,'australia');";
				 int result=state.executeUpdate(query);
				 System.out.println(result);
				 if(result==1)
				 {
					 System.out.println("data is added");
				 }
				 else 
				 {
					 System.out.println("data not added ");
				 }
				 
				//step -5 close the database 
				con.close();
				System.out.println("db closed ");
				
	}
}
