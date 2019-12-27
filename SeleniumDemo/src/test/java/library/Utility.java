package library;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {

	//static method so you can call this using class name, when set properties is available in a different class, then parameterize your WebDriver driver in the method
	public static String captureScreenshot(WebDriver driver) {
		
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			//call method get screenshot for ts and select File output type. Store this screenshot as a source reference for File
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
			
			File destination = new File(path);
			
				try
				{
					//FilesUtils class may need CommonsIO dependency or JAR if doesn't import, throw declaration and chose Exception so it will handle all type of exception
				FileUtils.copyFile(src, destination);
				} catch (Exception e) {
				System.out.println("Screenshot Captured" + e.getMessage());
		
				}
		
		return path;
		
	}
}
