package stepDefinations;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps 
{
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	List<HashMap<String, String>> datamap; //Data driven

	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() 
	{
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
	}
	
	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) 
	{
		BaseClass.getLogger().info("Enter Email and password ");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
	    
	}
	
	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() 
	{
		BaseClass.getLogger().info("User clicks on Login btn....");
		lp.clickLogin();
		
	}
	
	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page() 
	{
		macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountPageExists();
	    Assert.assertEquals(targetpage, true);
	}
    
	//*******   Data Driven test **************
    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
        
        macc=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }

}
