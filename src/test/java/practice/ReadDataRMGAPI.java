package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataRMGAPI {
public static void main(String[] args) throws Throwable {
	Connection con=null;
	
	try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = con.createStatement();
	String query = "select * from project where created_by='Thanuja';";
	ResultSet result = state.executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		String actualproject = result.getString(4);
		
		if(actualproject.equals("Hospital management"))
		{
			flag=true;
			break;
		}}
	if(flag) {
		System.out.println("Project is visible in database");
	}
	else
	{
		System.out.println("project is not created");
	}}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally {
		con.close();
		System.out.println("DB IS CLOSED");
	}
	
}
}
