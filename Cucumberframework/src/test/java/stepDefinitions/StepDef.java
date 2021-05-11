package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	@Given("^User is on Net banking landing page$")
	public void user_is_on_Netbanking_Landing() {
		// Selenium code to browser invoking and landing on the net banking page 
		System.out.println("Navigated to page url");
	}
	
	@When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String strArg1, String strArg2) throws Throwable {
		System.out.println(strArg1);
		System.out.println(strArg2);
    }
	
	@Then("^Home page is populated$")
	public void homepage_Populated() {
		System.out.println("Home page data");
	}
	
	
	@And("^Card displayed are \"([^\"]*)\"$")
    public void card_displayed_are_something(String strArg1) throws Throwable {
		System.out.println(strArg1);
    }
	

}
