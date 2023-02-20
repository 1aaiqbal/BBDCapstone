package tek.bdd.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.project.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	// syntax for finding UI elements and storing them in POM classes 
	/**
	 * @FindBy(locatorType = "value")
	 * public WebElement nameOfElement
	 */
	
	@FindBy(xpath="//a[text()='TEKSCHOOL']")
	public WebElement tekSchoolLogo;
	
	@FindBy(id ="search")
	public WebElement allDepartmentDropDown;
	
	@FindBy(css = "#searchInput")
	public WebElement searchBar;
	
	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton; 
	
	@FindBy(xpath ="//img[contains(@alt, 'Pokemon')]")
	public WebElement pokemanProductImage;
	
	@FindBy(linkText = "Sign in")
	public WebElement signInButton;
	
	@FindBy(xpath = "//p[contains(text(),'Cart')]")
	public WebElement cartButton;
	
	@FindBy(xpath ="//a[text()='Account']")
	public WebElement accountOption;
	
	
	


	



	
}
