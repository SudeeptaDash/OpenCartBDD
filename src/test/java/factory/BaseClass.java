package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass 
{
	
	static Properties p;
	static WebDriver driver;
	static Logger logger;
	
	//2-Take parameter and launch browser
	
	public static WebDriver initilizeBrowser() throws IOException
	{
		
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			    case "chrome":
			       driver = new ChromeDriver();
			       break; 
			    
			    case "firefox":
				       driver = new FirefoxDriver();
				       break;
				       
			    case "edge":
				       driver = new EdgeDriver();
				       break;     
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}   
			}
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 return driver;
	}
	 
	
		
	
	//1 - Read all the propertied from config.properties
	public static Properties getProperties() throws IOException
	{
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 p=new Properties();
		 p.load(file);
		 return p;
	}
	
	//3
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	
	public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
}
