package stepDefinations;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationSteps 
{
	
     HomePage hp;
     RegistrationPage regpage;
	
	@Given("the user navigates to account registration page")
	public void the_user_navigates_to_account_registration_page() 
	{
	      hp = new HomePage(BaseClass.getDriver());
	      hp.clickMyAccount();
	      hp.clickRegister();
	}

	@When("user provides the details as below")
	public void user_provides_the_details_as_below(DataTable dataTable) 
	{
		regpage = new RegistrationPage(BaseClass.getDriver());
	     Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	     
	     regpage.setFirstName(dataMap.get("FirstName"));
	     regpage.setLastName(dataMap.get("LastName"));
	     regpage.setEmail(dataMap.get("Email"));
	     regpage.setTelephone(dataMap.get("Telehone"));
	     regpage.setPassword(dataMap.get("Password"));
	     regpage.setConfirmPassword(dataMap.get("Password"));
	 }

	@When("user checks the privacypolicy check box")
	public void user_checks_the_privacypolicy_check_box() 
	{
		regpage.selectCheckBox();
	}

	@When("user clicks on the continue button")
	public void user_clicks_on_the_continue_button() 
	{
		regpage.clickContinueButton();
	}

	
	@Then("User account get created successfully")
	public void user_account_get_created_successfully() 
	{
	    String Actualmsg = regpage.getConfirmationMsg();
	    String expectedmsg = "Your Account Has Been Created!";
	    Assert.assertEquals(expectedmsg, Actualmsg);
	  
	}


}
