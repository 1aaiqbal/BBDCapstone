package tek.bdd.project.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.bdd.project.utilities.CommonUtility;


public class BaseUITest extends CommonUtility{


	@Before
	public void setupTests() {
		super.setupBrowser();
	}

	@After
	public void closeTests(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName() + " scenario Failed");
		}

		super.quitBrowser();
	}
}