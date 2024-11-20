package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import tests.BaseClass;

public class LoginPage {
	
	WebDriver driver;
	
	
	@FindBy(id = "user-name")
	WebElement userNameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorText;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToSwagLabs(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public void verifyErrorText(String ExpectedText) {
		Assert.assertEquals(errorText.getText(), ExpectedText);
	}
}
