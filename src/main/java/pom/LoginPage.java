package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {

	//variable
	
	@FindBy(xpath="//a[text()='Sign in']") private WebElement homePageSignInButton; 
	
	@FindBy(xpath="(//input[@type='number'])[2]") private WebElement mobileNumberfield;
	
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword;
	
	@FindBy(name="password") private WebElement passwordfield;
	
	@FindBy(xpath="//span[text()='Sign in']") private WebElement signInButton;
	
	@FindBy(xpath="//div[text()='My Account']") private WebElement myAccountButton;
	
	@FindBy(xpath="//span[text()=' My profile ']") private WebElement myProfileButton;
	
	
	//constructor
	
	public LoginPage (WebDriver driver)
	{
	 PageFactory.initElements(driver,this);	
		
	}
	
	//methods
	
	public void clickOnhomeSignInButton()
	{
		Reporter.log("Cliking on homepage SignInButton",true);
		homePageSignInButton.click();
		
	}
	
	public void entermobileNumberfield(String mobNum)
	
	{
		Reporter.log("entering mobile number",true);
		mobileNumberfield.sendKeys(mobNum);
		
	}
	
	public void clickOnSignInWithPassword()
	{
		Reporter.log("Clicking On SignInWithPassword",true);
	    signInWithPassword.click();
		
	}
	
	public void enterPassword(String pwd)
	{
		Reporter.log("entering password",true);
		passwordfield.sendKeys(pwd);	
		
	}
	
	public void clickOnSignInButton()
	{
		Reporter.log("clicking On SignInButton",true);
		signInButton.click();
		
	}
	
	public void clickOnMyAccountButton()
	{
		Reporter.log("clicking On MyAccountButton",true);
		myAccountButton.click();
		
	}
	
	public void clickOnMyProfileButton()
	{
		Reporter.log("clicking On MyProfileButton",true);
		myProfileButton.click();
		
	}
	
	
}
