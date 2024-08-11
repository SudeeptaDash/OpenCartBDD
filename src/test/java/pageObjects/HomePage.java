package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")  
	WebElement lnkmyaccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")   // Login link added in step6
	WebElement linkLogin;
	
	// Action Methods
	public void clickMyAccount() {
		lnkmyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()    // added in step6
	{
		linkLogin.click();
	}

}
