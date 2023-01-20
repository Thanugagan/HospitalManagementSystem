package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFroDataBaseTest{
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try
		{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root","root");
		Statement state = con.createStatement();
		String query = "select * from studentinfo;";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			con.close();
			System.out.println("Closed database connection succesfully");
		}
		
		
		}}
		
		
		
		
	
	

	 
	
	


