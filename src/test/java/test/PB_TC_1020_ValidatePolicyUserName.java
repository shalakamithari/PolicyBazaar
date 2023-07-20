package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPage;
import pom.MyAccountPage;
import utility.Utility;

 //@Listeners(testPolicyBazaar.Listener.class)
public class PB_TC_1020_ValidatePolicyUserName extends Base
{
	LoginPage login;
	MyAccountPage myAcc;
	String TCID="PB_TC1234";
	
	@BeforeClass
	public void launchPolicyBazaar() throws InterruptedException, IOException
	{
		Utility.wait(1000);
		launchBrowserUsingPropertyFile();
		login=new LoginPage(driver);
		myAcc=new MyAccountPage(driver);
	}

	@BeforeMethod
	public void signIntoPolicyBazaar() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.wait(2000);
		login.clickOnhomeSignInButton();
		
		Utility.wait(2000);
		login.entermobileNumberfield(Utility.readDataFromPropertyFile("mobNum"));
		
		Utility.wait(3000);
		login.clickOnSignInWithPassword();
		
		Utility.wait(2000);
		login.enterPassword(Utility.readDataFromPropertyFile("pwd"));
		
		Utility.wait(2000);
	    login.clickOnSignInButton();
	   
	    Utility.wait(2000);
	    login.clickOnMyAccountButton();
	   
	    Utility.wait(2000);
	    login.clickOnMyProfileButton();
	   
	    Utility.wait(2000);
	    
	    Set<String> allPageID = driver.getWindowHandles();
	    List<String>l=new ArrayList<>(allPageID);
	    //String mainPageID=l.get(0);
	    String childPageID=l.get(1);
	    
	    driver.switchTo().window(childPageID);
	    Reporter.log("Switching to childPage",true);
	    Utility.wait(3000);
	}
	
      @Test
  public void validateUserName() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  Utility.wait(2000);
	  String actualUN=myAcc.getActualUserName();
	  String expUN=Utility.readDataFromPropertyFile("UN");
	  Assert.assertEquals(actualUN,expUN,"TC is failed actual and expected are not matching");
	//Utility.takesScreenshot(driver,actualUN+" "+TCID);
  }
  
      @AfterMethod
  
  public void logOutFromPolicyBazaar()
  {
    	  myAcc.clickOnLogOutButton();
  }
  
       @AfterClass
   
       public void closePolicyBazaar() throws InterruptedException
       {
    	   closeBrowser();
       }
  
  
  
}
