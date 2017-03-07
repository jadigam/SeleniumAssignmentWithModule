import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaProgram {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.Salesforce.com");
		//Capturing the SS in Webdriver
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/report/ScreenShot/SF.jpg"));
		driver.quit();

	} 
	}






