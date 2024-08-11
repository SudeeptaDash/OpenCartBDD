package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{

	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement FirstName_txt;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement LastName_txt;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email_txt;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement Telephone_txt;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Password_txt;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement Cnfpassword_txt;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement Agree_chkbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement cntnue_btn;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement ConfirmationMsg;
	
	public void setFirstName(String FirstName)
	{
		FirstName_txt.sendKeys(FirstName);
	}
	
	public void setLastName(String LastName)
	{
		LastName_txt.sendKeys(LastName);
	}
	
	public void setEmail(String email)
	{
		Email_txt.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		Telephone_txt.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		Password_txt.sendKeys(password);
	}
	
	public void setConfirmPassword(String cnfPassword)
	{
		Cnfpassword_txt.sendKeys(cnfPassword);
	}
	
	public void selectCheckBox()
	{
		Agree_chkbox.click();
	} 
	
	public void clickContinueButton()
	{
		cntnue_btn.click();
	} 
	
	public String getConfirmationMsg()
	{
		String CnfMsg = ConfirmationMsg.getText();
		return CnfMsg;
	}
}
