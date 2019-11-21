package com.inetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String baseURL="https://demo.guru99.com/v4/";
	public String username="mngr232939";
	public String password="qurezYs";
	public static WebDriver driver;
	
	//note the capital and small l in these two
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		
		/*We create one Logger class
		initialte logger class object by using getLogger
		ebanking refers to name of the project name

		We need to make it global as it being used in multiple methods*/
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
