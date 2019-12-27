package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

	
	public static WebDriver driver;
	public static ChromeOptions ops;

	public static WebDriver launchBrowser(String browserName)
	{
		if(browserName.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
			
		//	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			ops = new ChromeOptions();

			ops.addArguments("--disable-notifications");
			
			ops.addArguments("disable-extensions");

			ops.addArguments("disable-infobars");

			ops.addArguments("--start-maximized");

			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,

					System.getProperty("user.dir") + "\\DriverLog\\chrome.log");

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			
		//	options.setHeadless(true);
	
			
			driver = new ChromeDriver(ops);
			
		//  driver = new ChromeDriver();
		}
	
		driver.manage().window().maximize();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();	
	
		return driver;
	
	
	}
	
}
