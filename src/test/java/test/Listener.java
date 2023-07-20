package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utility.Utility;

public class Listener extends Base implements ITestListener

{
   @Override
  public void onTestFailure(ITestResult result)
   {
	try {
		Utility.takesScreenshot(driver,result.getName());
	
	} 
	catch (IOException e) {
		
		e.printStackTrace();
	}
   }
   
   @Override
	public void onTestSuccess(ITestResult result)
    {
	   Reporter.log("TC "+result.getName()+"Passed succesfully",true);
	}
   
   @Override
	public void onTestStart(ITestResult result) 
    {
		Reporter.log("TC execution started for TC"+result.getName(),true);
	}



}