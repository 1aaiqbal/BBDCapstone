package tek.bdd.project.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
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
	@When("User click on All section")
		public void userClickOnAllSection() {
		click(factory.homePage().allIcon);
		logger.info("User click on All section");
	
	}
	@Then("below options are present in shop by department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedSideBar = dataTable.asLists(String.class);

//		List<WebElement> actualSideBar = factory.homePage().sideBarElements;
//
//		for (int i = 0; i < expectedSideBar.get(0).size(); i++) {
//			Assert.assertEquals(actualSideBar.get(i).getText(), expectedSideBar.get(0).get(i));
//			logger.info(actualSideBar.get(i).getText() + " is equal to " + expectedSideBar.get(0).get(i));
	//	}
		Assert.assertEquals(expectedSideBar.get(0).get(0), factory.homePage().electronicsSideBar.getText());
		Assert.assertEquals(expectedSideBar.get(0).get(1), factory.homePage().computersSideBar.getText());
		Assert.assertEquals(expectedSideBar.get(0).get(2), factory.homePage().smartHomeSideBar.getText());
		Assert.assertEquals(expectedSideBar.get(0).get(3), factory.homePage().sportsSideBar.getText());
		Assert.assertEquals(expectedSideBar.get(0).get(4), factory.homePage().automativeSideBar.getText());
		logger.info("actual is equal to expected");
		}
	@When("User on {string}")
	public void userOnElectronics(String department) {
		List<WebElement> sideBarOptions = factory.homePage().sideBarElements;
		for (WebElement option : sideBarOptions) {
			if (option.getText().equals(department)) {
				click(option);
				try {
					logger.info(option.getText() + " is present ");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		List<WebElement> actualDepartmentOptions = factory.homePage().sideBarOptionElements;

		for (int i = 0; i < expectedDepartmentOptions.get(0).size(); i++) {
			for (WebElement dept : actualDepartmentOptions) {
				if (dept.getText().equals(expectedDepartmentOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(dept));
					logger.info(dept.getText() + " is present ");
				}
			}

		}

	}

}