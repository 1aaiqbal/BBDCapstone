package tek.bdd.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.project.base.BaseSetup;

public class RetailAccountPage extends BaseSetup{
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//img[@id='profileImage']")
	public WebElement profileImage;
	
	@FindBy(xpath = "//input[@id='nameInput']")
	public WebElement profileNameInputField;
	
	@FindBy(xpath = "//input[@id='personalPhoneInput']")
	public WebElement profilePhoneNumberInputField;
	
	@FindBy(xpath = "//input[@id='emailInput']")
	public WebElement profileEmailInputField;
	
	@FindBy(xpath ="//button[text()='Update']")
	public WebElement profileUpdateButton;
	
	@FindBy(xpath = "//div[contains(text(),'Personal Information Updated Successfully')]")
	public WebElement personalInfoUpdateSuccessMessage;
	
	
	@FindBy(xpath = "//img[@id='profileImage']")
	public WebElement profilePicture;
	
	@FindBy(xpath = "//h1[contains(text(),'Ahad')]")
	public WebElement profileNameText;
	
	@FindBy(xpath = "//h1[contains(text(),'1aaiqbal@gmail.com')]")
	public WebElement profileEmailText;
	
	
	@FindBy(xpath = "//input[@id='previousPasswordInput']")
	public WebElement profilePreviousPassword;
	
	@FindBy(xpath = "//input[@id='newPasswordInput']")
	public WebElement profileNewPassword;
	
	@FindBy(xpath = "//input[@id='confirmPasswordInput']")
	public WebElement profileConfirmPassword;
	
	@FindBy(xpath = "//button[@id='credentialsSubmitBtn']")
	public WebElement profileChangePassword;
	
	@FindBy(xpath = "//div[contains(text(),'Password Updated Successfully')]")
	public WebElement newPasswordUpdateSuccessfrully;

	
}
