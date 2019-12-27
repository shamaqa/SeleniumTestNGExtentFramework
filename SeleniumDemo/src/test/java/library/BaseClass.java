package library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public static   SoftAssert softAssert = new SoftAssert();
	
	public static	WebDriver driver;
	public static	ExtentHtmlReporter htmlReporter;
	public static	ExtentReports extent;
	public static	ExtentTest logger;
	
	public static String Username = "Corillian";
	public static String Password = "20!9Pwchg";
	public static String CertLink = "https://cert.myinvestorsbank.com/auth/SignIn?wa=wsignin1.0&wtrealm=https://cert.myinvestorsbank.com/banking/&wctx=rm=0&id=passive&ru=/banking/";	
	
	
	
	@BeforeSuite
	public void setUpExtentReports() {
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh;mm;ss");  
		String strDate = dateFormat.format(date); 
		
												//give "./Reports/namefile.html" "./reports/_" + strDate + ".html"
		htmlReporter = new ExtentHtmlReporter("./reports/" + this.getClass().getName() + "_" + strDate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	//	extent.loadConfig(new File(AppConfig.getExtent_ConfigXML()));
	}
	
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if (driver == null)
		{
			return;
		}
			
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String failtempsc = Utility.captureScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(failtempsc).build());
		}			
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String passtempsc = Utility.captureScreenshot(driver);
			logger.pass(result.getName()+" Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(passtempsc).build());		
		}
		else
		{
			String skiptempsc = Utility.captureScreenshot(driver);
			logger.skip(result.getName()+" Test Case Skipped", MediaEntityBuilder.createScreenCaptureFromPath(skiptempsc).build());
			logger.skip(result.getThrowable());
		}

	  	driver.close();
		//softAssert.assertAll();
	}
	
	
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
	
	
	
}
