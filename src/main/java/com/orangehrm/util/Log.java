package com.orangehrm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
public static Logger log = Logger.getLogger("Log");
	
	public static void info(String message) {
	 
		PropertyConfigurator.configure("G:\\Selenium_Rahul\\testng\\DDWithPOM\\src\\main\\java\\com\\orangehrm\\config\\log4j.properties");
		log.info(message);
	}	

}
