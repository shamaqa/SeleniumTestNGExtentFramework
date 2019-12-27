package logIn;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import library.BaseClass;
import library.BrowserFactory;
import library.Utility;

public class InvalidCredentials extends BaseClass {
	

		
	@Test
	public void InvalidUsernameChromeLogIn() {
		logger = extent.createTest("Log In: Invalid Username and Valid Password Using Chrome ", "Tests the log in functionality of Project with invalid credentials.");
		System.out.println("Starting Log In Test With Invalid Username Using Chrome Browser");
		
		//Launch Chrome Browser
		driver = BrowserFactory.launchBrowser("chrome");
		logger.log(Status.INFO, "Sucessfully launched the Chrome Browser");
		
		//Navigate to Cert URL
		driver.get(CertLink);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    logger.pass("Navigated to URL");
		
		//Enter invalid username
		driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys(Username);
		logger.pass("Entered Invalid Username");
		
		//Enter valid password
		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
		logger.pass("Entered Valid Password");
		
		//Click Log In
		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
		logger.pass("Clicked Log In");
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualLogInPageTitle = driver.getTitle();
		System.out.println(ActualLogInPageTitle);
		String ExpectedLogInPageTitle = "Log In";
		softAssert.assertEquals(ActualLogInPageTitle, ExpectedLogInPageTitle);
		logger.pass("Log in Unsuccesfull");
		
		
		//Assert.assertEquals(LogInUnsuccesfullMessage, "Accounts");
		//logger.pass("Validated Homepage");
		
		
		
//    	if (driver.getPageSource().contains("We are unable to validate your information")) {
//    		driver.close();
//    		Assert.assertTrue(true);
//    		logger.pass("Log in Unsuccessful");
//    	} else {
//    		Assert.assertTrue(false);
//    	}
//		
//		
//    	driver.close();
    	
		}	
	
	
	
	
	
	
	
	
	
	@Test
	public void InvalidPasswordChromeLogIn() {
		logger = extent.createTest("Log In: Valid UserName and Invalid Password Using Chrome ", "Tests the log in functionality of Project with invalid credentials.");
		System.out.println("Starting Log In Test With Invalid Password Using Chrome Browser");
		
		//Launch Chrome browser
		driver = BrowserFactory.launchBrowser("chrome");
		logger.log(Status.INFO, "Sucessfully launched the Chrome Browser");
		
		//Navigate to Cert URL
		driver.get(CertLink);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     	logger.pass("Navigated to URL");
     	
		//Enter valid username
		driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys(Username);
		logger.pass("Entered Valid Username");
	
		//Enter valid password
		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
		logger.pass("Entered Invalid Password");
		
		//Click Log In
		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
		logger.pass("Clicked Log In");
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualLogInPageTitle = driver.getTitle();
		System.out.println(ActualLogInPageTitle);
		String ExpectedLogInPageTitle = "Log In";
		softAssert.assertEquals(ActualLogInPageTitle, ExpectedLogInPageTitle);
		logger.pass("Log in Unsuccesfull");
	
}
	
	
	
	
	
	
	
	
	@Test
	public void InvalidPasswordFirefoxLogIn() {
		logger = extent.createTest("Log In: Valid Username and Invalid Password Using Firefox ", "Tests the log in functionality of Project with invalid credentials.");
		System.out.println("Starting Log In Test With Invalid Password Using Firefox");
		
		//Launch Firefox browser
		driver = BrowserFactory.launchBrowser("firefox");		
		logger.log(Status.INFO, "Sucessfully launched the Firefox Browser");
		
		//Navigate to Cert URL
		driver.get(CertLink);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
       	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       	logger.pass("Navigated to URL");
	
       	//Enter valid username
		driver.findElement(By.cssSelector("*[id='UserName']")).click();
		logger.pass("Clicked Click");
		
		//Enter valid password
		driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys(Username);
		logger.pass("Entered Valid Username");
	
		//Enter Invalid password
		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
		logger.pass("Entered Invalid Password");
		
		//Click Log In
		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
		logger.pass("Clicked Log In");
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualLogInPageTitle = driver.getTitle();
		System.out.println(ActualLogInPageTitle);
		String ExpectedLogInPageTitle = "Log In";
		softAssert.assertEquals(ActualLogInPageTitle, ExpectedLogInPageTitle);
		logger.pass("Log in Unsuccesfull");
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	@Test
	public void InvalidUsernameFirefoxLogIn() {
	logger = extent.createTest("Log In: Invalid Username and Valid Password Using Firefox ", "Tests the log in functionality of Project with invalid credentials.");
	System.out.println("Starting Log In Test With Invalid Username Using Chrome Browser");
	
	//Launch Firefox browser
	driver = BrowserFactory.launchBrowser("firefox");
	logger.log(Status.INFO, "Sucessfully launched the Firefox Browser");
	
	//Navigate to Cert URL
	driver.get(CertLink);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    logger.pass("Navigated to URL");
		
	//Enter invalid username	
	driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys("invalid");
	logger.pass("Entered Invalid Username");
	
	//Enter valid password	
	driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
	logger.pass("Entered Valid Password");
		
	//Click Log In	
	driver.findElement(By.cssSelector("*[value*='Log In']")).click();
	logger.pass("Clicked Log In");
	
	//Validate on Accounts page
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
	String ActualLogInPageTitle = driver.getTitle();
	System.out.println(ActualLogInPageTitle);
	String ExpectedLogInPageTitle = "Log In";
	softAssert.assertEquals(ActualLogInPageTitle, ExpectedLogInPageTitle);
	logger.pass("Log in Unsuccesfull");
	
	softAssert.assertAll();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






//	
//	WebDriver driver;
//	
//	@Parameters({"browser"})
//	@Test(priority=1)
//	public void launchBrowser(String browser) {
//		System.out.println("Running test using " + browser + " Browser");
//		
//		if(browser.contentEquals("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//		else if(browser.equals("Firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver 32\\geckodriver.exe" );
//			driver = new FirefoxDriver();
//		}
//		else if(browser.equals("InternetExplorer")) {
//			System.setProperty("webdriver.ie.driver", "C:\\IEDRIVER\\IEDriverServer.exe" );
//			driver = new InternetExplorerDriver();
//		}	
//		
//	}
//	
//	@Parameters
//	@Test(priority=2)
//	public void navigateToUrl() {
//	
//		String CertLink = "https://cert.myinvestorsbank.com/auth/SignIn?wa=wsignin1.0&wtrealm=https://cert.myinvestorsbank.com/banking/&wctx=rm=0&id=passive&ru=/banking/";	
//		driver.get(CertLink);
//	}
//		
//	@Parameters({"username","password"})
//	@Test(priority=3)
//	public void logInTest(String username, String password) {
//		driver.findElement(By.cssSelector("input[id='UserName']")).click();
//		System.out.println("username:" + username);
//		driver.findElement(By.cssSelector("input[id='UserName']")).sendKeys(username);
//		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(password);
//		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
//	}
//	
//
//	
//}
