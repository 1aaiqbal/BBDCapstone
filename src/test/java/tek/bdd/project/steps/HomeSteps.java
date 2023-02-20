package tek.bdd.project.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.project.pages.POMFactory;
import tek.bdd.project.utilities.CommonUtility;


public class HomeSteps extends CommonUtility {
	
	private POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + " ExpectedTitle " + expectedTitle);
		
	}
	
	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product "+ productValue );
		
	}
	
	@And("User search for other {string} product")
	public void userSearchForOtherProduct(String secondProValue) {
		sendText(factory.homePage().searchBar, secondProValue);
		click(factory.homePage().searchButton);
		logger.info("user search for second product " + secondProValue);
		
	}
	
	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed()  {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemanProductImage));
		logger.info("Pokeman picture is displayed on home page");
		
		
	}
	@Then("The sign in button should be present")
	public void theSignInButtonShouldBePresent()  {
		Assert.assertTrue(isElementDisplayed(factory.homePage().signInButton));
		logger.info("The SignIn button is present ");
		

	}
	@Then("The cart button should be present")
	public void theCartButtonShouldBePresent()  {
		Assert.assertTrue(isElementDisplayed(factory.homePage().cartButton));
		logger.info("The cart button is present");

		
	}
}