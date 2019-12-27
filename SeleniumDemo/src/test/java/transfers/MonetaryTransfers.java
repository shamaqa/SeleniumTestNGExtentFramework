package transfers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.BaseClass;
import library.BrowserFactory;
import library.Utility;

public class MonetaryTransfers extends BaseClass {

	
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Transfer Funds from Checking Acct to Checking Acct Using Chrome
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//@Test
	@Test
	public void transferChktoChkChrome() throws IOException {
		logger = extent.createTest("Transfer: Checkings Account to Checkings Account Using Chrome", "Tests the transfer functionality from a checking account to checking account using Chrome.");
		System.out.println("Starting Transfers Test From Checkings Account to Checkings Account Using Chrome Browser");
		
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
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
      	String ActualAccountsPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualAccountsPageTitle);
		String ExpectedAccountsPageTitle = "Accounts";
		softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
		logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Accounts Page");
		
		//Click transfers
		driver.findElement(By.xpath("//*[contains(@title, 'Transfers')]")).click();
		logger.pass("Clicked 'Transfers", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Transfers'");
		
		//Validate on Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualTransferPageTitle);
		String ExpectedTransferPageTitle = "Transfer Money";
		softAssert.assertEquals(ActualTransferPageTitle, ExpectedTransferPageTitle);
		logger.pass("Validated Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Transfer Page");
		
		//Click 'From:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='FromAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'From:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'From:' dropdown");	
		
	
		// SELECT FROM DROPDOWN 	
		System.out.println("Listing options from 'From:' drop down menu");
		List<WebElement> fromDropDownMenu = driver.findElements(By.xpath("//ul[@id='FromAccountIndex_listbox']/*"));
		
		Boolean fromFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement fromList : fromDropDownMenu) {

			System.out.println(fromList.getText());

			if (fromList.getText().contains("*1215")) {

				fromList.click();
				fromFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'From:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'From:' dropdown");	
		
		if (fromFound == false) {
			// say test failed
		}
			
		
		
		//Click 'To:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='ToAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'To:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'To:' Dropdown");	
		

		//List<WebElement> element = driver.findElements(By.xpath("//div[@class='row']//div[1]//span[2]//span[1]//span[1]//div[1]"));
		System.out.println("Listing options from 'From:' Drop Down Menu");
		List<WebElement> toDropDownMenu = driver.findElements(By.xpath("//ul[@id='ToAccountIndex_listbox']/*"));
		
		Boolean toFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement toList : toDropDownMenu) {

			System.out.println(toList.getText());

			if (toList.getText().contains("*4016")) {

				toList.click();
				toFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'To:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'To:' dropdown");	
		
		if (toFound == false) {
			// say test failed
		}
		
		
		
		//Enter Amount
		driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text']")).sendKeys("50.00");
		// 
		logger.pass("Entered transfer amount", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered transfer amount");	
		
		
		//Click Review
		driver.findElement(By.cssSelector("*[type*='submit']")).click();
		logger.pass("Clicked Review", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked Review");
		
		//Validate on Review Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualReviewTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualReviewTransferPageTitle);
		String ExpectedReviewTransferPageTitle = "Review Transfer";
		softAssert.assertEquals(ActualReviewTransferPageTitle, ExpectedReviewTransferPageTitle);
		logger.pass("Validated Review Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Review Transfer Page");
		
				
				
		//Click Make Transfer
		driver.findElement(By.cssSelector("input[value*='Make Transfer']")).click();	
		logger.pass("Clicked 'Make Transfer'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Make Transfer'");
				
				
		//Validate on transfer successful
		driver.findElement(By.cssSelector("*[class='alert-message']")).isDisplayed();
		logger.pass("Validated 'Transfer Successful' message", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated 'Transfer Successful' message");
			

		softAssert.assertAll();
			
		}
   	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Transfer Funds from Checking Acct to Checking Acct Using Firefox
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//@Test
	public void transferChktoChkFirefox() throws IOException {
		logger = extent.createTest("Transfer: Checkings Account to Checkings Account Using Firefox", "Tests the transfer functionality from a checking account to checking account using Chrome.");
		System.out.println("Starting Transfers Test From Checkings Account to Checkings Account Using Firefox Browser");
		
		//Launch Firefox browser
		driver = BrowserFactory.launchBrowser("firefox");
		logger.log(Status.INFO, "Sucessfully launched the Firefox Browser", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Sucessfully launched the Firefox Browser");
		
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
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
      	String ActualAccountsPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualAccountsPageTitle);
		String ExpectedAccountsPageTitle = "Accounts";
		softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
		logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Accounts Page");
		
		//Click transfers
		driver.findElement(By.xpath("//*[contains(@title, 'Transfers')]")).click();
		logger.pass("Clicked 'Transfers", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Transfers'");
		
		//Validate on Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualTransferPageTitle);
		String ExpectedTransferPageTitle = "Transfer Money";
		softAssert.assertEquals(ActualTransferPageTitle, ExpectedTransferPageTitle);
		logger.pass("Validated Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Transfer Page");
		
		//Click 'From:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='FromAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'From:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'From:' dropdown");	
		
	
		// SELECT FROM DROPDOWN 	
		System.out.println("Listing options from 'From:' drop down menu");
		List<WebElement> fromDropDownMenu = driver.findElements(By.xpath("//ul[@id='FromAccountIndex_listbox']/*"));
		
		Boolean fromFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement fromList : fromDropDownMenu) {

			System.out.println(fromList.getText());

			if (fromList.getText().contains("*4016")) {

				fromList.click();
				fromFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'From:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'From:' dropdown");	
		
		if (fromFound == false) {
			// say test failed
		}
			
		
		
		//Click 'To:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='ToAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'To:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'To:' Dropdown");	
		

		//List<WebElement> element = driver.findElements(By.xpath("//div[@class='row']//div[1]//span[2]//span[1]//span[1]//div[1]"));
		System.out.println("Listing options from 'From:' Drop Down Menu");
		List<WebElement> toDropDownMenu = driver.findElements(By.xpath("//ul[@id='ToAccountIndex_listbox']/*"));
		
		Boolean toFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement toList : toDropDownMenu) {

			System.out.println(toList.getText());

			if (toList.getText().contains("*1215")) {

				toList.click();
				toFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'To:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'To:' dropdown");	
		
		if (toFound == false) {
			// say test failed
		}
		
		
		
		//Enter Amount
		//driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text']")).click();
		driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and contains(@class,'k-formatted-value')]")).click();
		driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and @name='Amount']")).sendKeys("50.00");
		
		WebElement amount = driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and contains(@class,'k-formatted-value')]"));
		String amountHtml = amount.getAttribute("outerHTML");
		//sendKeys("50.00");
		
		
		logger.pass("Entered transfer amount", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered transfer amount");	
		
		
		//Click Review
		driver.findElement(By.cssSelector("*[type*='submit']")).click();
		logger.pass("Clicked Review", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked Review");
		
		//Validate on Review Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualReviewTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualReviewTransferPageTitle);
		String ExpectedReviewTransferPageTitle = "Review Transfer";
		softAssert.assertEquals(ActualReviewTransferPageTitle, ExpectedReviewTransferPageTitle);
		logger.pass("Validated Review Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Review Transfer Page");
		
				
				
		//Click Make Transfer
		driver.findElement(By.cssSelector("input[value*='Make Transfer']")).click();	
		logger.pass("Clicked 'Make Transfer'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Make Transfer'");
				
				
		//Validate on transfer successful
		driver.findElement(By.cssSelector("*[class='alert-message']")).isDisplayed();
		logger.pass("Validated 'Transfer Successful' message", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated 'Transfer Successful' message");
			

		softAssert.assertAll();
			
		}
	
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Transfer Funds from Savings Acct to Savings Acct Using Chrome
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
	//@Test
	@Test
	public void transferSvgtoSvgChrome() throws IOException {
		logger = extent.createTest("Transfer: Savings Account to Savings Account Using Chrome", "Tests the transfer functionality from a savings account to savings account using Chrome.");
		System.out.println("Starting Transfers Test From Checkings Account to Checkings Account Using Chrome Browser");
		
		//Launch Chrome browser
		driver = BrowserFactory.launchBrowser("chrome");
		logger.log(Status.INFO, "Sucessfully launched the Chrome Browser", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
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
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
      	String ActualAccountsPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualAccountsPageTitle);
		String ExpectedAccountsPageTitle = "Accounts";
		softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
		logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Accounts Page");
		
		//Click transfers
		driver.findElement(By.xpath("//*[contains(@title, 'Transfers')]")).click();
		logger.pass("Clicked 'Transfers", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Transfers'");
		
		//Validate on Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualTransferPageTitle);
		String ExpectedTransferPageTitle = "Transfer Money";
		softAssert.assertEquals(ActualTransferPageTitle, ExpectedTransferPageTitle);
		logger.pass("Validated Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Transfer Page");
		
		//Click 'From:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='FromAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'From:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'From:' dropdown");	
		
	
		// SELECT FROM DROPDOWN 	
		System.out.println("Listing options from 'From:' drop down menu");
		List<WebElement> fromDropDownMenu = driver.findElements(By.xpath("//ul[@id='FromAccountIndex_listbox']/*"));
		
		Boolean fromFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement fromList : fromDropDownMenu) {

			System.out.println(fromList.getText());

			if (fromList.getText().contains("*0760")) {

				fromList.click();
				fromFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'From:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'From:' dropdown");	
		
		if (fromFound == false) {
			// say test failed
		}
			
		
		
		//Click 'To:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='ToAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'To:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'To:' Dropdown");	
		

		//List<WebElement> element = driver.findElements(By.xpath("//div[@class='row']//div[1]//span[2]//span[1]//span[1]//div[1]"));
		System.out.println("Listing options from 'From:' Drop Down Menu");
		List<WebElement> toDropDownMenu = driver.findElements(By.xpath("//ul[@id='ToAccountIndex_listbox']/*"));
		
		Boolean toFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement toList : toDropDownMenu) {

			System.out.println(toList.getText());

			if (toList.getText().contains("*8303")) {

				toList.click();
				toFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'To:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'To:' dropdown");	
		
		if (toFound == false) {
			// say test failed
		}
		
		
		
		//Enter Amount
		driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text']")).sendKeys("50.00");
		// 
		logger.pass("Entered transfer amount", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered transfer amount");	
		
		
		//Click Review
		driver.findElement(By.cssSelector("*[type*='submit']")).click();
		logger.pass("Clicked Review", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked Review");
		
		//Validate on Review Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualReviewTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualReviewTransferPageTitle);
		String ExpectedReviewTransferPageTitle = "Review Transfer";
		softAssert.assertEquals(ActualReviewTransferPageTitle, ExpectedReviewTransferPageTitle);
		logger.pass("Validated Review Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Review Transfer Page");
		
				
				
		//Click Make Transfer
		driver.findElement(By.cssSelector("input[value*='Make Transfer']")).click();	
		logger.pass("Clicked 'Make Transfer'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Make Transfer'");
				
				
		//Validate on transfer successful
		driver.findElement(By.cssSelector("*[class='alert-message']")).isDisplayed();
		logger.pass("Validated 'Transfer Successful' message", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated 'Transfer Successful' message");
			

		softAssert.assertAll();
			
		}
	
	
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Transfer Funds from Savings Acct to Savings Acct Using Firefox
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//@Test
	public void transferSvgtoSvgFirefox() throws IOException {
		logger = extent.createTest("Transfer: Savings Account to Savings Account Using Firefox", "Tests the transfer functionality from a savings account to savings account using Firefox.");
		System.out.println("Starting Transfers Test From Checkings Account to Checkings Account Using Chrome Browser");
		
		//Launch Chrome browser
		driver = BrowserFactory.launchBrowser("chrome");
		logger.log(Status.INFO, "Sucessfully launched the Chrome Browser", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
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
		
		//Validate on Accounts page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
      	String ActualAccountsPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualAccountsPageTitle);
		String ExpectedAccountsPageTitle = "Accounts";
		softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
		logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Accounts Page");
		
		//Click transfers
		driver.findElement(By.xpath("//*[contains(@title, 'Transfers')]")).click();
		logger.pass("Clicked 'Transfers", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Transfers'");
		
		//Validate on Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualTransferPageTitle);
		String ExpectedTransferPageTitle = "Transfer Money";
		softAssert.assertEquals(ActualTransferPageTitle, ExpectedTransferPageTitle);
		logger.pass("Validated Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Transfer Page");
		
		//Click 'From:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='FromAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'From:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'From:' dropdown");	
		
	
		// SELECT FROM DROPDOWN 	
		System.out.println("Listing options from 'From:' drop down menu");
		List<WebElement> fromDropDownMenu = driver.findElements(By.xpath("//ul[@id='FromAccountIndex_listbox']/*"));
		
		Boolean fromFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement fromList : fromDropDownMenu) {

			System.out.println(fromList.getText());

			if (fromList.getText().contains("*0760")) {

				fromList.click();
				fromFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'From:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'From:' dropdown");	
		
		if (fromFound == false) {
			// say test failed
		}
			
		
		
		//Click 'To:' Drop Down Menu
		driver.findElement(By.xpath("//span[@aria-owns='ToAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
		logger.pass("Clicked 'To:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'To:' Dropdown");	
		

		//List<WebElement> element = driver.findElements(By.xpath("//div[@class='row']//div[1]//span[2]//span[1]//span[1]//div[1]"));
		System.out.println("Listing options from 'From:' Drop Down Menu");
		List<WebElement> toDropDownMenu = driver.findElements(By.xpath("//ul[@id='ToAccountIndex_listbox']/*"));
		
		Boolean toFound = false;
        // Select Business Checking *4016* from 'From:' drop down menu
		for (WebElement toList : toDropDownMenu) {

			System.out.println(toList.getText());

			if (toList.getText().contains("*8303")) {

				toList.click();
				toFound = true;
				break;
			}
		}
		logger.pass("Selected Checking account from 'To:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Selected Checking account from 'To:' dropdown");	
		
		if (toFound == false) {
			// say test failed
		}
		
		
		
		//Enter Amount
		driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and contains(@class,'k-formatted-value')]")).click();
		driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and @name='Amount']")).sendKeys("50.00");
		logger.pass("Entered transfer amount", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Entered transfer amount");	
		
		
		//Click Review
		driver.findElement(By.cssSelector("*[type*='submit']")).click();
		logger.pass("Clicked Review", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked Review");
		
		//Validate on Review Transfers page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		String ActualReviewTransferPageTitle = driver.getTitle();
		System.out.println("The actual title of the page is: " + ActualReviewTransferPageTitle);
		String ExpectedReviewTransferPageTitle = "Review Transfer";
		softAssert.assertEquals(ActualReviewTransferPageTitle, ExpectedReviewTransferPageTitle);
		logger.pass("Validated Review Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated Review Transfer Page");
		
				
				
		//Click Make Transfer
		driver.findElement(By.cssSelector("input[value*='Make Transfer']")).click();	
		logger.pass("Clicked 'Make Transfer'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Clicked 'Make Transfer'");
				
				
		//Validate on transfer successful
		driver.findElement(By.cssSelector("*[class='alert-message']")).isDisplayed();
		logger.pass("Validated 'Transfer Successful' message", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		System.out.println("Validated 'Transfer Successful' message");
			

		softAssert.assertAll();
			
		}
	
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Transfer Funds from Checking Acct to Installment loan Acct Using Firefox
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
	//@Test
	public void transferChktoInstallLoanFirefox() throws IOException {
			logger = extent.createTest("Transfer: Checkings Account to Intallment Loan Account Using Chrome", "Tests the transfer functionality from a checking account to Installment Loan account using Firefox.");
			System.out.println("Starting Transfers Test From Checkings Account to Checkings Account Using Chrome Browser");
			
			//Launch Chrome browser
			driver = BrowserFactory.launchBrowser("firefox");
			logger.log(Status.INFO, "Sucessfully launched the firefox Browser", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Sucessfully launched the Chrome Browser");
			
			//Navigate to Cert URL
			driver.get(CertLink);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    logger.pass("Navigated to Cert Corillian URL", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		    System.out.println("Navigated to Cert Corillian URL");
			
		    //Enter valid username
			driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys(Username);
			logger.pass("Entered Valid Username", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Entered Valid Username:"+ Username);
			
			//Enter valid password
			driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys(Password);
			logger.pass("Entered Valid Password", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Entered Valid Password:" + Password);
			
			//Click Log In
			driver.findElement(By.cssSelector("*[value*='Log In']")).click();
			logger.pass("Clicked 'Log In'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Clicked 'Log In'");
			
			//Validate on Accounts page
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			String ExpectedAccountsPageTitle = "Accounts";
			System.out.println("The expected title of the page is: " + ExpectedAccountsPageTitle);
			String ActualAccountsPageTitle = driver.getTitle();
			System.out.println("The actual title of the page is: " + ActualAccountsPageTitle);
			softAssert.assertEquals(ActualAccountsPageTitle, ExpectedAccountsPageTitle);
			logger.pass("Validated Accounts Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Validated Accounts Page");
			
			//Click transfers
			driver.findElement(By.xpath("//*[contains(@title, 'Transfers')]")).click();
			logger.pass("Clicked 'Transfers", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Clicked 'Transfers'");
			
			//Validate on Transfers page
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
			String ExpectedTransferPageTitle = "Transfer Money";
			System.out.println("The expected title of the page is: " + ExpectedAccountsPageTitle);
			String ActualTransferPageTitle = driver.getTitle();
			System.out.println("The actual title of the page is: " + ActualTransferPageTitle);
			softAssert.assertEquals(ActualTransferPageTitle, ExpectedTransferPageTitle);
			logger.pass("Validated Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Validated Transfer Page");
			
			//Click 'From:' Drop Down Menu
			driver.findElement(By.xpath("//span[@aria-owns='FromAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
			logger.pass("Clicked 'From:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Clicked 'From:' Dropdown");	
			
		
			// SELECT FROM DROPDOWN 	
			System.out.println("Listing options from 'From:' Drop Down Menu");
			List<WebElement> fromDropDownMenu = driver.findElements(By.xpath("//ul[@id='FromAccountIndex_listbox']/*"));
			
			Boolean fromFound = false;
	        // Select Business Checking *4016* from 'From:' drop down menu
			for (WebElement fromList : fromDropDownMenu) {

				System.out.println(fromList.getText());

				if (fromList.getText().contains("*0760")) {

					fromList.click();
					fromFound = true;
					break;
				}
			}
			logger.pass("Selected Checking account from 'From:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Selected Checking account from 'From:' dropdown");	
			
			if (fromFound == false) {
				// say test failed
			}
				
			
			
			//Click 'To:' Drop Down Menu
			driver.findElement(By.xpath("//span[@aria-owns='ToAccountIndex_listbox']//div[contains(@class,'account-list-select-item')]")).click();
			logger.pass("Clicked 'To:' Dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Clicked 'To:' Dropdown");	
			

			//List<WebElement> element = driver.findElements(By.xpath("//div[@class='row']//div[1]//span[2]//span[1]//span[1]//div[1]"));
			System.out.println("Listing options from 'From:' Drop Down Menu");
			List<WebElement> toDropDownMenu = driver.findElements(By.xpath("//ul[@id='ToAccountIndex_listbox']/*"));
			
			Boolean toFound = false;
	        // Select Business Checking *4016* from 'From:' drop down menu
			for (WebElement toList : toDropDownMenu) {

				System.out.println(toList.getText());

				if (toList.getText().contains("*8303")) {

					toList.click();
					toFound = true;
					break;
				}
			}
			logger.pass("Selected Checking account from 'To:' dropdown", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Selected Checking account from 'To:' dropdown");	
			
			if (toFound == false) {
				// say test failed
			}
			
			
			
			//Enter Amount
			driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and contains(@class,'k-formatted-value')]")).click();
			driver.findElement(By.xpath("//div[@id='regularAmount']//input[@type='text' and @name='Amount']")).sendKeys("50.00");
			logger.pass("Entered transfer amount", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Entered transfer amount");	
			
			
			//Click Review
			driver.findElement(By.cssSelector("*[type*='submit']")).click();
			logger.pass("Clicked Review", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Clicked Review");
			
			//Validate on Review Transfers page
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
			String ActualReviewTransferPageTitle = driver.getTitle();
			System.out.println("The actual title of the page is: " + ActualReviewTransferPageTitle);
			String ExpectedReviewTransferPageTitle = "Review Transfer";
			softAssert.assertEquals(ActualReviewTransferPageTitle, ExpectedReviewTransferPageTitle);
			logger.pass("Validated Review Transfer Page", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Validated Review Transfer Page");
			
					
					
			//Click Make Transfer
			driver.findElement(By.cssSelector("input[value*='Make Transfer']")).click();	
			logger.pass("Clicked 'Make Transfer'", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Clicked 'Make Transfer'");
					
					
			//Validate on transfer successful
			driver.findElement(By.cssSelector("*[class='alert-message']")).isDisplayed();
			logger.pass("Validated 'Transfer Successful' message", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			System.out.println("Validated 'Transfer Successful' message");
				

			softAssert.assertAll();
				
			}
		
	
	
	
	
	
	
	
	}
	
	
	
//	@Test
//	public void test2()
//	{
//		logger = extent.createTest("Test 2");
//		
//		driver = BrowserFactory.launchBrowser("chrome");
//		logger.log(Status.INFO, "Sucessfully launched the Chrome Browser");
//		
//		String CertLink = "https://cert.myinvestorsbank.com/auth/SignIn?wa=wsignin1.0&wtrealm=https://cert.myinvestorsbank.com/banking/&wctx=rm=0&id=passive&ru=/banking/";	
//		driver.get(CertLink);
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    logger.pass("Navigated to URL");
//	    
//	    driver.findElement(By.cssSelector("*[id='UserName']")).click();
//	    logger.pass("Clicked Click");
//		
//		driver.findElement(By.cssSelector("*[id='UserName']")).sendKeys("sislamtest");
//		logger.pass("Entered Invalid Username");
//		
//		driver.findElement(By.cssSelector("*[id*='Password']")).sendKeys("Sh@ma93!");
//		logger.pass("Entered Valid Password");
//		
//		driver.findElement(By.cssSelector("*[value*='Log In']")).click();
//		logger.pass("Clicked Log In");
//		
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
//		String ActualLogInPageTitle = driver.getTitle();
//		System.out.println(ActualLogInPageTitle);
//		String ExpectedLogInPageTitle = "Log In";
//		softAssert.assertEquals(ActualLogInPageTitle, ExpectedLogInPageTitle);
//	}
//	

	

