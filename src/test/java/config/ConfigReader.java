package config;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	
	public ConfigReader()
	{
		try {
			prop = new Properties();
			InputStream input = new FileInputStream("C:\\DMA_TestAutomation\\Selenium_UIAutomation\\src\\test\\java\\config\\config.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseURL(){
		return prop.getProperty("BASE_URL");
	}
	
	public String getUN(){
		return prop.getProperty("Username");
	}
	
	public String getPW(){
		return prop.getProperty("Password");
	}
}
