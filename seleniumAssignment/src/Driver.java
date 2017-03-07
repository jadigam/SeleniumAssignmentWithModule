import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Driver {

	public static WebDriver driver;
	public static int reportflag = 0;
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
		//here we are executing the testCases by reading xlSheet
		

		//Java Reflexion or reflexive api
		
        String dataPath = "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite/TestSuite.xls";		
		String[][] recData = ReUsableMethods.readSheet(dataPath, "Sheet1");		
		for(int i = 1; i<recData.length; i++){
		
			if(recData[i][1].equalsIgnoreCase("y")){
				/*Firefox*/
				if(recData[i][1].equalsIgnoreCase("Y")){
					driver = new FirefoxDriver();
					reportflag = 0;  // Reset
					String testScript = recData[i][2];
					ReUsableMethods.startReport(testScript, "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite1/report/");
					
					/*Java Reflection or Reflexive API*/
					Method ts = AutomationScripts.class.getMethod(testScript);
					ts.invoke(ts);
					
					driver.close();
					if(reportflag == 0){
						ReUsableMethods.writeExcel(dataPath, "Sheet1", i, 3, "Pass");
					}else{
						ReUsableMethods.writeExcel(dataPath, "Sheet1", i, 3, "Fail");
					}
					

				}
				
				// Chrome..
				if(recData[i][1].equalsIgnoreCase("Y")){
				
					System.setProperty("webdriver.chrome.driver", "C:/vijaya/chrome/chromedriver.exe");
					driver = new ChromeDriver();
					
					reportflag = 0;  // Reset
					String testScript = recData[i][2];
					ReUsableMethods.startReport(testScript, "C:/Users/Chinnu/Desktop/SCM/sheets/XeroTestSuite1/report/");
					
					/*Java Reflection or Reflexive API*/
					Method ts = AutomationScripts.class.getMethod(testScript);
					ts.invoke(ts);
					
					driver.close();
					if(reportflag == 0){
						ReUsableMethods.writeExcel(dataPath, "Sheet1", i, 4, "Pass");
					}else{
						ReUsableMethods.writeExcel(dataPath, "Sheet1", i, 4, "Fail");
					}
					
				}
				

				ReUsableMethods.bw.close();
			}else{
				System.out.println("Row number :" +i+ " script is not executed..");
				System.out.println();
				ReUsableMethods.writeExcel(dataPath, "Sheet1", i, 3, "NA");
			}
			
			}
	}
}
