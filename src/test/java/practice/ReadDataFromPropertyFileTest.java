  package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		//step1:get object representation for physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		//step 2: Create object for properties
		Properties pObj = new Properties();
		//step 3:Load the file
		pObj.load(fis);
		//step 4: Read data from file
		String url = pObj.getProperty("url");
		String username = pObj.getProperty("username");
		String password = pObj.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
	}

}
