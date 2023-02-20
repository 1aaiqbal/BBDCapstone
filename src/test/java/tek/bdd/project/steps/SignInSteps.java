package tek.bdd.project.steps;

import java.util.List;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.project.pages.POMFactory;
import tek.bdd.project.utilities.CommonUtility;

public class SignInSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
	click(factory.homePage().signInButton);
	logger.info("User clicked on Sign in Option");
	
	}
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passwordValue) {
	sendText(factory.signInPage().emailField, emailValue);
	sendText(factory.signInPage().passwordField, passwordValue);
	logger.info("user entered email " + emailValue+ " and password " + passwordValue);

	}
	@And("User click on login button")
	public void userClickOnLoginButton() {
	click(factory.signInPage().loginPageButton);
	logger.info("user clicked on login button");

	}
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
	Assert.assertTrue(isElementDisplayed(factory.homePage().accountOption));	

	}
	
	@And("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().createNewAccountButton);
		logger.info("user clicked on Create New Account button");
	
	}
	@And("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
	List<Map<String, String>> signUpInformation = dataTable.asMaps(String.class, String.class);
	sendText(factory.signInPage().signUpNameField,signUpInformation.get(0).get("name"));
	sendText(factory.signInPage().signUpEmailField,signUpInformation.get(0).get("email"));
	sendText(factory.signInPage().signUpPasswordField, signUpInformation.get(0).get("password"));
	sendText(factory.signInPage().signUpConfirmPassField,signUpInformation.get(0).get("confirmPassword"));
	logger.info("user filled the signUp information form");
	

	}
	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signUpFormButton);
		logger.info("user clicked on SignUpForm button");

	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().profileImage));
		logger.info("user is login into account page");
	}
}
	    
		
	
	
	

	



