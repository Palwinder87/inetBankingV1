package com.inetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	//note the capital and small l in these two
	public static Logger logger;
	
	
	@Parameters("browser") //this will take parameters from xml
	
	
	@BeforeClass
	//br is a browser variable
	public void setup(String br)
	{
		
		/*We create one Logger class
		initialte logger class object by using getLogger
		ebanking refers to name of the project name

		We need to make it global as it being used in multiple methods*/
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		//Based on the br value and condition we decide which browser to launch
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		/* else(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}*/
		
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
