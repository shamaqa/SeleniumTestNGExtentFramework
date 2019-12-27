package logIn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
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

public class ValidCredentials extends BaseClass {
	
	

	
	//@Test
	public void ValidCredentialsChromeLogIn() throws IOException {
		logger = extent.createTest("Log In: Valid Username and Valid Password Using Chrome", "Tests the log in functionality of Project with valid credentials.");
		System.out.println("Starting Valid Credentials Test Using Chrome Browser");
		
		//Launch Chrome browser
		driver = BrowserFactory.launchBrowser("chrome");
		logger.log(Status.INFO, "Sucessfully launched the Chrome Browser");
		System.out.println("Sucessfully launched the Chrome Browser");
		
		//Navigate to Cert URL
		driver.get(CertLink);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    logger.pass("Navigated to URL", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
	    System.out.println("Navigated to URL");
		
	    //Enter valid username
		driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys(Username);
		logger.pass("Entered Valid Username", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		
		System.out.println("Entered Valid Username");
		
		//Enter valid password
		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
		logger.pass("Entered Valid Password", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered Valid Password");
		
		//Click Log In
		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
		logger.pass("Clicked 'Log In'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Log In'");
		
		
		//Security Question
		
		
	//	if (driver.findElement(By.cssSelector("*[class='page-message-wrap']")).isDisplayed())
	//		{
			
			
	//		};
		
		
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
      	String ActualAccountsPageTitle = driver.getTitle();
		System.out.println(ActualAccountsPageTitle);
		String ExpectedAccountsPageTitle = "Accounts";
		softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
		logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Accounts Page");
		
		
	}
	
	
	
	
	@Test 
	public void ValidCredentialsFirefoxLogIn() throws IOException {
		logger = extent.createTest("Log In: Valid Username and Valid Password Using Firefox", "Tests the log in functionality of Project with valid credentials.");
		System.out.println("Starting Valid Credentials Test Using Firefox Browser");
		
		//Launch Firefox browser
		driver = BrowserFactory.launchBrowser("firefox");
		logger.log(Status.INFO, "Sucessfully launched the firefox Browser");
		System.out.println("Sucessfully launched the firefox Browser");
		
		//Navigate to Cert URL
		driver.get(CertLink);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    logger.pass("Navigated to URL", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
	    System.out.println("Navigated to URL");
	    
	    //Enter valid username
		driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys(Username);
		logger.pass("Entered Valid Username", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered Valid Username");
		
		//Enter valid password
		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
		logger.pass("Entered Valid Password", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered Valid Password");
		
		//Click Log In
		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
		logger.pass("Clicked 'Log In'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Log In'");
		
		//Validate on Accounts Page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
      	String ActualAccountsPageTitle = driver.getTitle();
		System.out.println(ActualAccountsPageTitle);
		String ExpectedAccountsPageTitle = "Accounts";
		softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
		logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Accounts Page");
		
	}
	
	
	
	
	
}
