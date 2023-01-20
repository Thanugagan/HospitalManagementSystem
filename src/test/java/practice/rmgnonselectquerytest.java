package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class rmgnonselectquerytest {
	public static void main(String[] args) throws Throwable  {
		Connection con=null;
		int result = 0;
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		 Statement state = con.createStatement();
		 String query = "insert into project values('TY_Projects_004','Thanuja','21/12/2022','SDET45','Created',3);";
		 result=state.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		 if(result==1)
			{
				System.out.println("Data inserted successfully");
			}
			else
			{
				System.out.println("Data not inserted");
			}
			con.close();
		}

	}
	


