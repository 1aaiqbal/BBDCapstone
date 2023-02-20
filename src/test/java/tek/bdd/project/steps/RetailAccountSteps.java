package tek.bdd.project.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.project.pages.POMFactory;
import tek.bdd.project.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility{

	POMFactory factory = new POMFactory();


	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("User clicked on Account Option");

	}
	@When("User update Name {string} Phone {string} and email {string}")
	public void userUpdateNamePhoneAndEmail(String nameValue, String phoneValue, String emailValue) {
		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberInputField);
		clearTextUsingSendKeys(factory.accountPage().profileEmailInputField);
		sendText(factory.accountPage().profileNameInputField, nameValue);
		sendText(factory.accountPage().profilePhoneNumberInputField, phoneValue);
		sendText(factory.accountPage().profileEmailInputField, emailValue);

	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().profileUpdateButton);
		logger.info("user clicked on Update button");

	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateSuccessMessage));
		logger.info("user profile information updated");
	}
}