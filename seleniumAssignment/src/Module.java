import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Module extends ReUsableMethods {

public static void login(String un,String pwd,String URl) throws IOException{
	
	
	driver.get(URl);
	driver.manage().window().maximize();
		 		
	 WebElement userName = driver.findElement(By.xpath(".//*[@id='email']"));	
	 enterText(userName, un , "User name");           //is display method
	        	        
	 WebElement passWord = driver.findElement(By.xpath(".//*[@id='password']"));
	 enterText(passWord, pwd, "Pass Word");           
	   	        
	        
	 WebElement logInSubmit = driver.findElement(By.xpath(".//*[@id='submitButton']"));
	 clickButton(logInSubmit, "logInSubmit button");
	 	
	}
	
	
	public static void logOut(){
		
	}
	
	public static void clickAccount(){
		
	}
	
}
