package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility

{
	//Commonly used method
	//Screenshot
	//Scrolling
	//data reading
	//wait
  
	public static void takesScreenshot (WebDriver driver,String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	    File dest=new File("C:\\Users\\HP\\eclipse-workspace\\PolicyBazaar\\screenshots\\"+fileName+".png");
	    
	  
	   FileHandler.copy(src, dest);
	    
	    Reporter.log("taking Screenshot",true);
	    
	    Reporter.log("Screenshot location is..."+dest,true);
	}
	
	public static void ScrollIntoView(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element);
		
		  Reporter.log("ScrollIntoView",true);
	}	
	
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException 
	{
      FileInputStream myFile=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\PolicyBazaar\\excelSheet\\18 feb excel Test.xlsx");
		
      Reporter.log("Reading data from excel row num "+row+ "cell num is "+cell,true);
      
      String value = WorkbookFactory.create(myFile).getSheet("Sheet4").getRow(row).getCell(cell).getStringCellValue();
      return value;
	}
	
	public static void wait(int waitTime) throws InterruptedException
	{
		Reporter.log("Waiting for"+waitTime+"miliSec",true);
		Thread.sleep(waitTime);
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		
		FileInputStream myFile=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\feb18_2023selenium\\myproperty.properties");
		
		 prop.load(myFile);
		 String value = prop.getProperty(key);
		
		 Reporter.log("reading data "+key+"from property file",true);
		 
		 return value;
	}
}
















