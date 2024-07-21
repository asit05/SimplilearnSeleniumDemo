package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass{

	
	@Test
	public void TC01_AddToCartTest() {
		LoginPage lp = new LoginPage();
		HomePage hp = new HomePage();
		lp.loginToSwagLabs("standard_user", "secret_sauce");
		hp.verifyHomePage();
		hp.itemAddToCart("Sauce Labs Backpack");
		hp.verifyNumberOfItemAddedToCart(1);
	}
}
