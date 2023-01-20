package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		Connection con = null;
		int result=0;
		try {
			Driver driver = new Driver();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			Statement state = con.createStatement();
			String query = "insert into studentinfo values('Kumudha','KRPURAM','Javascript',2);";
			result = state.executeUpdate(query);

		} 
		catch (SQLException e) {

		}
		finally
		{
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

}
