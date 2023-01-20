package com.hms.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @author Thanu
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	public String getStringDate() {
		Date Dt = new Date();
		String date = Dt.toString();
		return date;
	}
	public String getSystemDateandTimeFormat() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemDate=new Date(); 
		String getdateandtime = dateformat.format(systemDate);
		return getdateandtime.replaceAll(":", "-");
		
	}

}

