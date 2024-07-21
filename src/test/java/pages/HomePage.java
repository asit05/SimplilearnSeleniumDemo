package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import tests.BaseClass;

public class HomePage {

	WebDriver driver = BaseClass.driver;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Products']")
	WebElement productsText;
	
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	WebElement itemNumberAddedToCart;
	
	
	public void verifyHomePage() {
		Assert.assertTrue(productsText.isDisplayed());
	}
	
	public void itemAddToCart(String itemName) {
		driver.findElement(By.xpath("//div[text()='"+itemName+"']/ancestor::div[@class='inventory_item']//button")).click();
	}
	
	public void verifyNumberOfItemAddedToCart(int numberOfItem) {
		Assert.assertEquals(Integer.parseInt(itemNumberAddedToCart.getText()), numberOfItem);
	}

}
