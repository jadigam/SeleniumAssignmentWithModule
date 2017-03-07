import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.WebElement;

public class ReUsableMethods extends Driver {
	
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;

	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	public static void enterText(WebElement webObj, String textVal, String objName) throws IOException{
		if(webObj.isDisplayed()){
			webObj.sendKeys(textVal);
			
			Update_Report("Pass","enterText", textVal + "entered in " + objName + "field");  //enterText is the name of the method
				//System.out.println("pass: " + textVal + "entered in " + objName + "field");
		}else{
			Update_Report("Fail","enterText", textVal + "entered in " + objName + "field");
				//System.out.println("fail: " + objName + " is not exist check your field");}			
		}	
	}
		
	public static void clickButton(WebElement webObj, String objName) throws IOException{
		if(webObj.isEnabled()){
			webObj.click();
			Update_Report("Pass","clickButton", "entered in " + objName + "field");  
		}else{
			Update_Report("fail","clickButton", objName+ " is not clicked");  
				//System.out.println(objName+ " is not clicked");		
		}
		}
	
	public static void selectCheckBox(WebElement webObj, String objName) throws IOException{
		if(!webObj.isSelected()){
			webObj.click();
			Update_Report("Pass","selectCheckBox", objName + "  is not selected");  
				//System.out.println(objName + "  is not selected");
		}else{
			Update_Report("fail","selectCheckBox", objName+ " is checked now");  
			//System.out.println(objName+ " is checked now");				
		}
	}
	
		public static void radioButton(WebElement webObj, String objName) throws IOException{
			boolean radioValue = webObj.isSelected();
			if(radioValue==false){
				webObj.click();
				Update_Report("Pass","radioButton", objName+ " is not selected");  
				//System.out.println(objName + "  is not selected");
			}else{
				Update_Report("fail","radioButton", objName+ " is selecteds now");  
				//System.out.println(objName+ " is already selected");				
			}
			}
		
		
	public static void deselectCheckBox(WebElement webObj, String objName) throws IOException{
		if(webObj.isSelected()){
			webObj.click();
			Update_Report("pass","deselectCheckBox", objName+ " is checked now");  
			//System.out.println(objName + "  is selected already ");
		}else{
			Update_Report("fail","deselectCheckBox", objName+ " is checked now");  
			//System.out.println(objName+ " is checked now");				
		}		
		}
	
	public static void selectEnabled(WebElement webObj, String objName) throws IOException{
		if(webObj.isEnabled()){
			webObj.click();
			Update_Report("pass","selectEnabled", objName+ " is checked now");  
			//System.out.println(objName + "  is clicked ");
		}else{
		//System.out.println(objName+ " is not clicked");		
		Update_Report("fail","selectEnabled", objName+ " is checked now");  
		}
		}	
			
	public static String[][] readSheet(String dt_Path, String sheetName) throws IOException{


		/*Step 1: Get the XL Path*/
		File xlFile = new File(dt_Path);

		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();

		String[][] xlData = new String[iRowCount][iColCount];
		
		for(int i=0; i<iRowCount; i++){
			for(int j = 0; j<iColCount; j++){
				
				xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		
		return xlData;
	}
	
	public static void writeExcel(String dt_path, String sheetName, int iRowCount, int iColCount, String XlData) throws IOException{
		/*Step 1: Get the XL Path*/
		File xlFile = new File(dt_path);

		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);
		
		/*Step 5: Access Row*/
		HSSFRow row = sheet.getRow(iRowCount);
		
		/*Step 6: Access Column*/
		HSSFCell cell = row.getCell(iColCount);
		
//		cell.setCellValue(XlData);
		
		if(XlData.equalsIgnoreCase("Pass")){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else if(XlData.equalsIgnoreCase("Fail")){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else{
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}
		

		
		FileOutputStream fout = new FileOutputStream(dt_path);
		wb.write(fout);
		fout.flush();
		fout.close();
	}

	

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	
}
