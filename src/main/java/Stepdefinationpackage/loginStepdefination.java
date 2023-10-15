package Stepdefinationpackage;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Pagepackage.loginp;
import Utilities.ReportingManager;
import basepackage.Basec;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginStepdefination  extends loginp
{
	@Given("^User is in login page$")
    public void user_is_in_login_page() throws IOException  
	{
		launchApplication();	
		
		ExtentCucumberAdapter.addTestStepLog("application launched successfully");
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ReportingManager.captureScreenshot());
	}
	
	   @When("^User enters email id \"([^\"]*)\"$")
	    public void user_enters_email_id(String EmailID) throws IOException, InterruptedException 
	   {
			enterEmailId(EmailID);  
			ExtentCucumberAdapter.addTestStepLog(" User entered the emaild successfully"+EmailID);
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ReportingManager.captureScreenshot());
	    	Thread.sleep(3000);
	    	
	    }
	
	   
	   @And("^User enters password \"([^\"]*)\"$")
	    public void user_enters_password(String strArg1) throws IOException {
	        enterPassword(strArg1);
	        ExtentCucumberAdapter.addTestStepLog("entered password");
	        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ReportingManager.captureScreenshot());
	    }
	   
	
	@And("^User clicks the signin button$")
    public void User_clicks_the_signin_button() throws IOException  
	{
		clickSigninButton();
		 ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(ReportingManager.captureScreenshot());
		
	
	}
	

	@Then("^close application$")
    public void close_application()  
	{
		
		closebrowser();
	}
	
	 @Then("^User should see error message on the screen$")
	    public void user_should_see_error_message_on_the_screen()  {
	        
	    	String actual = captureErrorMessage().trim();
	    	String expected = "Invalid email or password.";
	    	SoftAssert sa = new SoftAssert();
	    	
	    	sa.assertEquals(actual, expected);
	    	sa.assertAll();
	    	
	    	
	    	
	    }

}
