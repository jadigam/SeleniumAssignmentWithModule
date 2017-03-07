
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

// WebDriver is an object from Driver class, which is inherited multy level 

public class AutomationScripts extends ReUsableMethods { 

	public static void navigateToXERO() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("navigateToXERO");
		System.out.println("---------------------------");
		String dt_path = "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/TestData/navigateToXERO.xls";
		 String[][] recData = ReUsableMethods.readSheet(dt_path, "Sheet1");
		
		String un = recData[1][2];
		String pwd = recData[1][3];
		String URl = recData[1][1];
		
		
		Module.login(un,pwd,URl); 
		
		Thread.sleep(3000);
	    String actualString = "https://go.xero.com/Dashboard/";
		String expectedString = driver.getTitle();
		System.out.println(expectedString);
						}


	public static void incorrectPassword() throws IOException, InterruptedException {
	
		System.out.println("incorrectPassword");
		System.out.println("-------------------------------");

		String dt_path = "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/TestData/incorrectPassword.xls";
		 String[][] recData = ReUsableMethods.readSheet(dt_path, "Sheet1");
		
		String un = recData[1][2];
		String pwd = recData[1][3];
		String URl = recData[1][1];
		
		
		Module.login(un,pwd,URl); 
		
		 //errormessagelabel
		Thread.sleep(5000);
		 WebElement errorMessageLabel = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p"));
				 
		 String expectedText = "Your email or password is incorrect";
		 String actualText =  errorMessageLabel.getText();
			if(expectedText.equals(actualText)){
				System.out.println("error message is displayed correctly");
			  }else{
				System.out.println("error message is not displayed correctly");
			}		 	   		
	}
	
	public static void incorrectEmail() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("incorrectEmail");
		System.out.println("-------------------------------");

		String dt_path = "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/TestData/incorrectEmail.xls";
		 String[][] recData = ReUsableMethods.readSheet(dt_path, "Sheet1");
		
		String un = recData[1][2];
		String pwd = recData[1][3];
		String URl = recData[1][1];
		
		
		Module.login(un,pwd,URl); 
		 
		 //errormessagelabel
		 WebElement errorMessageLabel = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p"));
				 
		 String expectedText = "Your email or password is incorrect";
		 String actualText =  errorMessageLabel.getText();
			if(expectedText.equals(actualText)){
				System.out.println("error message is displayed correctly");
			  }else{
				System.out.println("error message is not displayed correctly");
			}		 	   		
			}
		
	public static void ForgotPassword() throws IOException{
		System.out.println("ForgotPassword");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.xero.com/");
		
		driver.manage().window().maximize();		
	
		 WebElement forgotPassword = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a"));	
		 clickButton(forgotPassword, "forgotPassword button");
		  		 	        	        
		 WebElement email = driver.findElement(By.xpath(".//*[@id='UserName']"));
		 enterText(email, "vijaya.webui@gmail.com", " enter email ");           
		   	        		 
		 WebElement sendLink = driver.findElement(By.xpath(".//*[@id='submitButton']/a/span"));	
		 clickButton(sendLink, "sendLink button");
		 
		 //resetmessage
		 WebElement passwordResetMessage = driver.findElement(By.xpath(".//*[@id='contentTop']/div/p[1]"));
		 System.out.println(passwordResetMessage.getText());
		 
		 		 		 
		 String expectedText = "A link to reset your password has been sent to:\nvijaya.webui@gmail.com";
		 System.out.println(expectedText);
		 
		 String actualText =  passwordResetMessage.getText();
			if(expectedText.equals(actualText)){
				System.out.println("passwordReset message is displayed correctly");
			  }else{
				System.out.println("passwordReset is not displayed correctly");
			}		 	   		
			}
	
	public static void signUpToXDC() throws IOException, InterruptedException{
		
		System.out.println("signUpToXDC");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://xero.com/us/");
		
		driver.manage().window().maximize();		
	
		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		clickButton(freeTrial, "freeTrial button");
			
		Thread.sleep(7000);
		WebElement firstName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input"));
		enterText(firstName, "vijaya", "firs tName ");
		
		WebElement lastName = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input"));
		enterText(lastName, "jadigam", "last tName ");
		
		WebElement emailAddress = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		enterText(emailAddress, "shravankumarj@gmail.com", "email Address");
		
		WebElement phoneNumber = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/input"));
		enterText(phoneNumber, "7888888890", "phone Number");
		
		WebElement country = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[7]/label/span/select"));
		selectEnabled(country, "country name"); 
		Select select = new Select(country);
		select.selectByVisibleText("United States");	
		
		WebElement checkBox = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/input"));
		selectCheckBox(checkBox, "checkBox");
			
				
		WebElement getStarted = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button"));
		clickButton(getStarted, "getStarted button");

  /*		WebElement emailText = driver.findElement(By.xpath("html/body/main/div/div/div/div[1]/div/div/div[2]/h1"));
		      	
		*/
	 
	}
	
		
	public static void signUpToXDCB() throws InterruptedException, IOException{
		System.out.println("signUpToXDCB");
		System.out.println("-------------------------------");


		driver = new FirefoxDriver();
		driver.get("https://xero.com/us/");
		
		driver.manage().window().maximize();		
	
		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		clickButton(freeTrial, "freeTrial button");
	
		Thread.sleep(4000);

		WebElement getStarted = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button"));
		getStarted.submit();
		Thread.sleep(10000);
	
		WebElement errorMessage1 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-1']"));
		WebElement errorMessage2 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-2']"));
		WebElement errorMessage3 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']"));
		WebElement errorMessage4 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-4']"));
		System.out.println(errorMessage1.getText());   
		System.out.println(errorMessage2.getText());   
		System.out.println(errorMessage3.getText());   
		System.out.println(errorMessage4.getText());   
				
		
		WebElement emailAddress = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
		enterText(emailAddress, "vijaya", "email Address");
		
		WebElement erroremailAddress = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']"));
		
		WebElement checkBoxLabel = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label"));
		String labelcolor  =  checkBoxLabel.getCssValue("Color");
		
				
		System.out.println(labelcolor);
	
							}		


	public static void signUpToXDCC() throws InterruptedException, IOException{
 
		System.out.println("signUpToXDCC");
		System.out.println("-------------------------------");


		
		driver = new FirefoxDriver();
		driver.get("https://xero.com/us/");
		
		driver.manage().window().maximize();		
	
		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		clickButton(freeTrial, "freeTrial button");
	
		Thread.sleep(4000);
		
		String parentWindowTitle =  driver.getTitle();
		System.out.println(parentWindowTitle);
		String parentWindow = driver.getWindowHandle();
		
		WebElement terms = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[1]"));
		clickButton(terms, "terms link");
		
		Thread.sleep(4000);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		String termsWindowTitle =  driver.getTitle();
		System.out.println(termsWindowTitle);
		
		Thread.sleep(4000);		
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(parentWindow);
		
		WebElement privacyPolicy = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[2]"));
		clickButton(privacyPolicy, "privacyPolicy link");
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
			   
		String privacywindowTitle =  driver.getTitle();
		System.out.println(privacywindowTitle);	
		Thread.sleep(4000);		
       if(privacywindowTitle.equals("Privacy Policy | Xero")){
			System.out.println("title is matching");
		}else{
			System.out.println("title is not matching");
		}
		driver.close();
		
			}
	
	public static void signUpToXDCD() throws InterruptedException, IOException{

		System.out.println("signUpToXDD");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://xero.com/us/");
		
		driver.manage().window().maximize();		
	
		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		clickButton(freeTrial, "freeTrial button");
	
		Thread.sleep(4000);
		
		String parentWindowTitle =  driver.getTitle();
		System.out.println(parentWindowTitle);
		String parentWindow = driver.getWindowHandle();
		
		WebElement offerDetail = driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[3]"));
		clickButton(offerDetail, "offerDetail link");
		
		Thread.sleep(4000);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		String offerDetailTitle =  driver.getTitle();
		System.out.println(offerDetailTitle);
		
		if(offerDetailTitle.equals("Offer details | Xero")){
			System.out.println("offer title is matching");
		}else{
			System.out.println("offer title is not matching");
		}
		
		Thread.sleep(4000);		
		
					}
	
	public static void signUpToXDCE() throws InterruptedException, IOException{
		
		System.out.println("signUpToXDE");
		System.out.println("-------------------------------");
	
		driver = new FirefoxDriver();
		driver.get("https://xero.com/us/");
		
		driver.manage().window().maximize();		
	
		WebElement freeTrial = driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span"));
		clickButton(freeTrial, "freeTrial button");
	
		Thread.sleep(4000);
		
		String parentWindowTitle =  driver.getTitle();
		System.out.println(parentWindowTitle);
		String parentWindow = driver.getWindowHandle();
		
		WebElement acoountant = driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a"));
		clickButton(acoountant, "offerDetail link");
		
		Thread.sleep(4000);
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		String acoountantTitle =  driver.getTitle();
		System.out.println(acoountantTitle);
		
		if(acoountantTitle.equals("Sign up for the Xero Partner Program | Xero")){
			System.out.println(" title is matching");
		}else{
			System.out.println(" title is not matching");
		}
		
		Thread.sleep(4000);		
	}

	public static void testAllTabsPage() throws InterruptedException, IOException{

		System.out.println("testAllTabsPage");
		System.out.println("-------------------------------");
		
		String dt_path = "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/TestData/navigateToXERO.xls";
		 String[][] recData = ReUsableMethods.readSheet(dt_path, "Sheet1");
		
		String un = recData[1][2];
		String pwd = recData[1][3];
		String URl = recData[1][1];
		
		
		Module.login(un,pwd,URl); 
		
		 
		 Thread.sleep(3000);
	     String actualString = "https://go.xero.com/Dashboard/";
		String expectedString = driver.getTitle();
		System.out.println(expectedString);
		
		//accounts Tab
		 WebElement accounts = driver.findElement(By.xpath(".//*[@id='Accounts']"));
		 clickButton(accounts, "accounts button");
		 
		 //accountDropDownList
		List<WebElement> AccountdropDown = driver.findElements(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li"));
		for(WebElement AD: AccountdropDown){
			System.out.println(AD.getText());
		}
		
		Thread.sleep(5000);
		
		//report Tab
		 WebElement reports = driver.findElement(By.xpath(".//*[@id='Reports']"));
		 clickButton(reports, "reports button");
		 clickButton(reports, "reports button");
		 
		 Thread.sleep(3000);
		 
		 		 
		 //reportDropDownList
		List<WebElement> reportdropDown = driver.findElements(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[4]/ul/li"));
		for(WebElement RD: reportdropDown){
			System.out.println(RD.getText());
		}			
		
		Thread.sleep(3000);
		//contact Tab
		 WebElement contacts = driver.findElement(By.xpath(".//*[@id='Contacts']"));
		 clickButton(contacts, "contacts button");
		 clickButton(contacts, "contacts button");
		 
		 Thread.sleep(3000);
			
		 //contactsDropDownList
		List<WebElement> contactsdropDown = driver.findElements(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[6]/ul/li"));
		for(WebElement CD: contactsdropDown){
			System.out.println(CD.getText());
		}			
		
		Thread.sleep(3000);
		//settings Tab
		 WebElement settings = driver.findElement(By.xpath(".//*[@id='Settings']"));
		 clickButton(settings, "settings button");
		 clickButton(settings, "settings button");
		 
		 Thread.sleep(3000);
			 
		 //settingsDropDownList
		List<WebElement> settingsdropDown = driver.findElements(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[7]/ul/li"));
		for(WebElement SD: settingsdropDown){
			System.out.println(SD.getText());
		}			
		
		Thread.sleep(5000);
		//new/+ Tab
		 WebElement newTab = driver.findElement(By.xpath(".//*[@id='quicklaunchTab']"));
		 clickButton(newTab, "NEW button");
		 clickButton(newTab, "NEW button");
		 
		 Thread.sleep(5000);
		 //newDropDownList
		List<WebElement> newdropDown = driver.findElements(By.xpath(".//*[@id='quicklaunchPanel']/div/div/div[2]/div/ul/li"));
		for(WebElement ND: newdropDown){
			System.out.println(ND.getText());
		}			
	
		
		Thread.sleep(3000);
	/*	 		
		//file Tab
		 WebElement files = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a"));
		 clickButton(files, "files button");
		 clickButton(files, "files button");
		
		// System.out.println(driver.getTitle());
		 
		 Thread.sleep(5000);
		 
	
		//notifications Tab
		 WebElement notifications = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a[@class='notifications x-sandbox']"));
		 clickButton(notifications, "notifications button");
		 clickButton(notifications, "notifications button");
		
		 Thread.sleep(5000);
		 WebElement notificationsWindowText = driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[1]"));
			
		 System.out.print(notificationsWindowText.getText());
		 	
		 Thread.sleep(2000);
*/
		//search Tab
		 WebElement searchTab = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a[@class='search']"));
		 clickButton(searchTab, "searchTab button");
		 clickButton(searchTab, "searchTab button");
		
		 Thread.sleep(4000);
		 WebElement searchWindowText = driver.findElement(By.xpath(".//*[@id='DemoOrgNotification']/p[1]"));			
		 System.out.print(searchWindowText.getText());
		
		 Thread.sleep(2000);
		//help Tab
		 WebElement help = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]//a[@class='help']"));
		 clickButton(help, "help button");
		 clickButton(help, "help button");
		
		 Thread.sleep(4000);
		 WebElement helpWindowText = driver.findElement(By.xpath(".//*[@id='rt']/div[1]/h3"));			
		 System.out.print(searchWindowText.getText());
			 
	}
	
	
	////////////////////////////////////////
	
	public static void testLogoutFunctionalityCreatenewview() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("testLogoutFunctionalityCreatenewview");
		System.out.println("-------------------------------");

		String dt_path = "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/TestData/navigateToXERO.xls";
		 String[][] recData = ReUsableMethods.readSheet(dt_path, "Sheet1");
		
		String un = recData[1][2];
		String pwd = recData[1][3];
		String URl = recData[1][1];
		
		
		Module.login(un,pwd,URl); 
		 
		 Thread.sleep(3000);
		 	 
		 WebElement userMenu = driver.findElement(By.cssSelector(".username"));
		 clickButton(userMenu, "userMenu button");
		 
		 Thread.sleep(3000);
		 
		 WebElement logOut = driver.findElement(By.cssSelector("a[data-js='logout']"));
		 clickButton(logOut, "logOut button");
		 
	  Thread.sleep(4000);
		
		 WebElement userName1 = driver.findElement(By.cssSelector("input[id='email']"));	
		 		String actualVal = userName1.getText();	
		 		
		 		String expectedName = "vijaya";
		 		
		 		if(expectedName.equals(actualVal)){
		 		System.out.println("name is displaying");
		 			
		 		}else{
		 		System.out.println("name  is not displaying");
		 		
		 		}		
	}	

/*
	public static void CreateAccount() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("createAccount");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement AccountTab = driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickButton(AccountTab, "Account button");
		
		Thread.sleep(3000);
		
		WebElement CreateNewButton = driver.findElement(By.id("createNewButton"));
		clickButton(CreateNewButton, "Create New Button");
		
		Thread.sleep(3000);
		
		WebElement accountDropDown = driver.findElement(By.xpath(".//*[@id='createNewMenu']/a[3]"));
		clickButton(accountDropDown, "account DropDown");
		
		WebElement accountName = driver.findElement(By.id("acc2"));
		enterText(accountName, "vjAccount", "account Name");
	
		//Save
		driver.findElement(By.xpath(".//*[@id='topButtonRow']/input[1]")).click();	
		
		System.out.println("Create Account Test Case succeeded");
		
	}	

	
	public static void editView() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("createAccount");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement AccountTab = driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickButton(AccountTab, "Account button");
		
		Thread.sleep(3000);
		
		WebElement selectArrow = driver.findElement(By.xpath(".//*[@id='fcf']")); 

		Select select = new Select(selectArrow);
		select.selectByVisibleText("myAccountt");
		
		Thread.sleep(3000);
		
		//edit button
		driver.findElement(By.xpath(".//*[@id='filter_element']/div/span/span[2]/a[1]")).click();
				
		Thread.sleep(3000);
		
		//change the view name
		driver.findElement(By.id("fname")).sendKeys("newMyAccount");
		
		WebElement fieldSelect = driver.findElement(By.id("fcol1"));

		Select select1 = new Select(fieldSelect);
		select1.selectByVisibleText("Account Name");
		
		WebElement operatorSelect = driver.findElement(By.id("fop1"));

		Select select2 = new Select(operatorSelect);
		select2.selectByVisibleText("contains");
		
		//enter value in value field next to field, operator select
        driver.findElement(By.id("colselector_select_0")).sendKeys("a");
        
    	WebElement availableFields = driver.findElement(By.id("fcol1"));
        //select last activity
		Select select3 = new Select(availableFields);
		select3.selectByVisibleText("Last Activity");
        
		Thread.sleep(5000);
        //add button
		driver.findElement(By.xpath(".//*[@id='colselector_select_0_right']/img")).click();
		
		//save button
		driver.findElement(By.xpath(".//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]")).click();
		
		// need to write select dropdown has the value of expected string "newMyAccount"
		System.out.println("newMyAccount is added to view dropdown list");
		
        
			}	
	
	public static void mergeAccounts() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("createAccount");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement AccountTab = driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickButton(AccountTab, "Account button");
		
		Thread.sleep(3000);
		
		//click on merge accounts in tools area
		driver.findElement(By.linkText("Merge Accounts")).click();
		
		//enter value 
		driver.findElement(By.xpath(".//*[@id='srch']")).sendKeys("vjaccount");
		
		//click on find accounts
		driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[4]/input[2]")).click();
		
		
		//click on first two check boxes
		WebElement oilCheckbox1 = driver.findElement(By.xpath(".//*[@id='cid0']"));
		selectCheckBox(oilCheckbox1, "first check box");
		
		WebElement oilCheckbox2 = driver.findElement(By.xpath(".//*[@id='cid1']"));
		selectCheckBox(oilCheckbox1, "second check box");
		
		//click on next
		driver.findElement(By.name("goNext")).click();
		//click on merge
		driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[1]/div/input[2]")).click();
		
		//to click on ok for alert box
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(7000);
		WebElement viewDropdown = driver.findElement(By.xpath(".//*[@id='fcf']"));
        //select last activity
		Select select = new Select(viewDropdown);
		select.selectByVisibleText("Recently Viewed Accounts");
        
		driver.findElement(By.name("go")).click();
		System.out.println("recently viewed list has oil and gas");
		
		//need to compare the table values for validations
		
	}	

	public static void createAccountReport() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("createAccountReport");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement AccountTab = driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickButton(AccountTab, "Account button");
		
		Thread.sleep(3000);
		
		WebElement last30dayLink = driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		clickButton(last30dayLink, "last30dayLink");
		
		//date field
//		WebElement dateField = driver.findElement(By.xpath(".//*[@id='ext-gen20']"));
//		clickButton(dateField, "dateField");
		
	//	WebElement createDateentireWindow = driver.findElement(By.xpath(".//*[@id='ext-gen270']"));
	//	clickButton(createDateentireWindow, "dateField");
				
		//createdDate 
	//	WebElement createdDate = driver.findElement(By.xpath(".//*[@id='ext-gen271']/div[3]"));
	//	clickButton(createdDate, "createedDate");
		
		WebElement fromDate = driver.findElement(By.id("ext-comp-1042"));
		fromDate.sendKeys(Keys.RETURN);
		
	    driver.findElement(By.xpath(".//*[@id='ext-gen276']")).click();
		
		//click on today on calendar
		
		WebElement todayFrom = driver.findElement(By.xpath(".//*[@id='ext-gen304']"));
		clickButton(todayFrom, "todayFrom button");
					
		WebElement toDate = driver.findElement(By.id("ext-comp-1045"));
		clickButton(toDate, "toDate");

		WebElement todayTo = driver.findElement(By.xpath(".//*[@id='ext-gen323']"));
		clickButton(todayTo, "todayTo");
		
		Thread.sleep(5000);
			
	}

	public static void verifyOpportunitiesDropDownPresent() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("verifyOpportunitiesDropDownPresent");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement opportunities = driver.findElement(By.xpath(".//*[@id='Opportunity_Tab']/a"));
		clickButton(opportunities, "opportunities");
		
		Thread.sleep(3000);
				
		WebElement viewDropdown = driver.findElement(By.xpath(".//*[@id='fcf']"));
		
		//string of arrays to compare the select control options
		String [] dropDownLi = new String[]{"All Opportunities", "Closing Next Month","Closing This Month", "My Opportunities", "New Last Week", "New This Week", "Opportunities Pipeline", "Private", "Recently Viewed Opportunities", "Won"};
		
        //select last activity
		Select select = new Select(viewDropdown);
		List<WebElement> optionSelect = select.getOptions();
		for (int i = 0; i < optionSelect.size(); i++){
			
		 System.out.println(optionSelect.get(i).getText());  
		 if(optionSelect.get(i).getText().equals(dropDownLi[i])){
			 System.out.println("Expected Value is mathcing with Actual value");
		 }else{
			 System.out.println("Expected Value is not mathcing with Actual value");
		 }
			 
		}
		
		Thread.sleep(3000);
		
			}
	
	public static void createNewOpty() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("createNewOpty");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement opportunities = driver.findElement(By.xpath(".//*[@id='Opportunity_Tab']/a"));
		clickButton(opportunities, "opportunities");
		
		//click on new button
		WebElement newButton = driver.findElement(By.xpath(".//input[@name='new']"));
		clickButton(newButton, "new button");	
		
		//enter text for opportunity name
		driver.findElement(By.id("opp3")).sendKeys("xyz");
		
		//account name
		driver.findElement(By.id("opp4")).sendKeys("abc");
		
		//click on close date
		driver.findElement(By.id("opp9")).click();
		//we can get the calendar date by xpath by inspecting element
		// we can get the xpath for the date table we can give customised xpath by selecting table//tr/td etc
		driver.findElement(By.id("opp9")).click();
		
		//we can get all the dates as list
		List <WebElement> listofDate = driver.findElements(By.xpath(".//*[@id='datePicker']//td")); 
		for(WebElement s: listofDate){
			System.out.println(s.getText());  //it will return all the dates
			if(s.getText().equalsIgnoreCase("28")){        //asking to click on particular date
				s.click();
			}
		}
		
		//stage control
		
		WebElement stageDropDown = driver.findElement(By.id("opp11"));
		Select select = new Select(stageDropDown);
		select.selectByVisibleText("Qualification");
		
		//probability text field
		driver.findElement(By.id("opp12")).sendKeys("10");
		
		//lead control
		WebElement leadDropDown = driver.findElement(By.id("opp6"));
		Select select1 = new Select(leadDropDown);
		select.selectByVisibleText("Web");
		
		//primary campaign source text field
		driver.findElement(By.id("opp17")).sendKeys("abc");
				
		//click save
		driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();
				
		Thread.sleep(3000);
		
		//save it is throwing some data matching errors
		
			}

	public static void TestOpportunityPipelineReport() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("TestOpportunityPipelineReport");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement opportunities = driver.findElement(By.xpath(".//*[@id='Opportunity_Tab']/a"));
		clickButton(opportunities, "opportunities");
		
		Thread.sleep(3000);
		
		WebElement opportunitiesPipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
		clickButton(opportunitiesPipeline, "opportunitiesPipeline");
		
		System.out.println(driver.getTitle() + "test is success");
		
							}

	public static void TestStuckOpportunitiesReport() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("TestStuckOpportunitiesReport");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement opportunities = driver.findElement(By.xpath(".//*[@id='Opportunity_Tab']/a"));
		clickButton(opportunities, "opportunities");
		
		WebElement stuckOpportunities = driver.findElement(By.linkText("Stuck Opportunities"));
		clickButton(stuckOpportunities, "stuckOpportunities");
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle() + " test is success");
		
			}

	public static void TestQuarterlySummaryReport() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("TestQuarterlySummaryReport");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement opportunities = driver.findElement(By.xpath(".//*[@id='Opportunity_Tab']/a"));
		clickButton(opportunities, "opportunities");
		
		//Quarterly Summary
		//select interval activity
		WebElement intervalDropDown = driver.findElement(By.id("quarter_q"));
		
		Select select = new Select(intervalDropDown);
		select.selectByVisibleText("Current FQ");		
		
        WebElement includeDropDown = driver.findElement(By.xpath(".//*[@id='open']"));
		
		Select select1 = new Select(intervalDropDown);
		select1.selectByIndex(1);
				
		//click on report
		WebElement report = driver.findElement(By.xpath(".//*[@id='lead_summary']/table/tbody/tr[3]/td/input"));
		clickButton(report, "report");
						
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
	}

	public static void checkLeadstabLink () throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("checkLeadstabLink ");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		WebElement lead = driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a"));
		clickButton(lead, "lead tab");
		
		Thread.sleep(3000);
				
		String leadtitle =  driver.getTitle();
		String expectedString = "Leads: Home ~ Salesforce - Developer Edition";
		
		System.out.println(leadtitle);
		
		if(expectedString.equals(leadtitle)){
			System.out.println("expected string is matching with" + leadtitle);
			
		}
		else{
			System.out.println("expected string is not matching with" + leadtitle);
				
		}			
			}
	
	public static void leadsSelectView() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("leadsSelectView");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
	//click on leads tab	
		WebElement lead = driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a"));
		clickButton(lead, "lead tab");
		
		Thread.sleep(3000);		
		String [] dropDownLi = new String[]{"All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads", "View - Custom 1", "View - Custom 2" }; 
		
		//System.out.println(dropDownLi[1]);	
		//select options		
		WebElement viewDropdown = driver.findElement(By.xpath(".//*[@id='fcf']"));
        //select control activity
		Select select = new Select(viewDropdown);
		
		List<WebElement> optionSelect = select.getOptions();
		for (int i = 0; i < optionSelect.size(); i++){
			
		 System.out.println(optionSelect.get(i).getText());  
		 
		 if(optionSelect.get(i).getText().equals(dropDownLi[i])){
		  System.out.println("expected value is mathcing with" + optionSelect.get(i).getText());  
		 }else {
			 System.out.println("expected value is not mathcing with");			 
		 }
		 
		}
		Thread.sleep(3000);	
		
			}

	public static void functionalityOfTheGoButton() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("functionalityOfTheGoButton");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		//click on leads tab	
		WebElement lead = driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a"));
		clickButton(lead, "lead tab");
				
		Thread.sleep(3000);
			
		WebElement viewDropdown = driver.findElement(By.xpath(".//*[@id='fcf']"));
        //select last activity
		Select select = new Select(viewDropdown);
		select.selectByVisibleText("Today's Leads");
		
		//logout
		driver.findElement(By.id("userNavButton")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(3000);
		
		WebElement userName1 = driver.findElement(By.id("username"));
		enterText(userName1, "vijaya@wells.com", "user name");
		
		WebElement passWord1 = driver.findElement(By.id("password"));
		enterText(passWord1, "ganapathi@9", "Pass word");
		
		WebElement logIn1 = driver.findElement(By.id("Login"));
		clickButton(logIn1, "LogIn button");
		
		Thread.sleep(5000);
		//click on leads tab	
		WebElement lead1 = driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a"));
		clickButton(lead1, "lead tab");
		
		WebElement goButton = driver.findElement(By.name("go"));
		clickButton(goButton, "go tab");				
		Thread.sleep(3000);
		
		WebElement Dropdown = driver.findElement(By.id("00B46000001kwa1_listSelect"));
        //select last activity
		Select select1 = new Select(Dropdown);
		
		//to check the selected option
		System.out.println(select1.getFirstSelectedOption().getText());
		
	  }

	public static void listItemTodaysLeadsWork() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("listItemTodaysLeadsWork");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		//click on leads tab	
		WebElement lead = driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a"));
		clickButton(lead, "lead tab");
				
		Thread.sleep(3000);
			
		WebElement viewDropdown = driver.findElement(By.xpath(".//*[@id='fcf']"));
        //select last activity
		Select select = new Select(viewDropdown);
		select.selectByVisibleText("Today's Leads");
		
		System.out.println("Test got success");
	
	}

	public static void checkNewButtonOnLeadsHome() throws InterruptedException, IOException{
		// TODO Auto-generated method stub

		System.out.println("checkNewButtonOnLeadsHome");
		System.out.println("-------------------------------");

		driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "vijaya@wells.com", "user name");
		
		WebElement passWord = driver.findElement(By.id("password"));
		enterText(passWord, "ganapathi@9", "Pass word");
		
		WebElement logIn = driver.findElement(By.id("Login"));
		clickButton(logIn, "LogIn button");
		
		Thread.sleep(5000);
		
		//click on leads tab	
		WebElement lead = driver.findElement(By.xpath(".//*[@id='Lead_Tab']/a"));
		clickButton(lead, "lead tab");
				
		//click on new button in the Recent Leads
		driver.findElement(By.xpath(".//input[@name='new']")).click();     //used custom xpath
		
		System.out.println(driver.getTitle() + " new lead window opened");
		
		//enter text in last name field
	    driver.findElement(By.id("name_lastlea2")).sendKeys("ABC");
		
	   //enter text in company name field
	    driver.findElement(By.id("lea3")).sendKeys("ABC");
		
	  //click on save button
	    driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]")).click();
		
	    WebElement newLeadName =  driver.findElement(By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2"));
	    System.out.println("new Lead name is " + newLeadName.getText());
	    
	}		
	
	*/
}
