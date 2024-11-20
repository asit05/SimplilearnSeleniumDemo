package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;


@Listeners(Listener.class)
public class HomePageTest extends BaseClass{

	
	@Test
	public void TC01_AddToCartTest() {
		LoginPage lp = new LoginPage(GetDriver());
		HomePage hp = new HomePage(GetDriver());
		lp.loginToSwagLabs("standard_user", "secret_sauce");
		hp.verifyHomePage();
		hp.itemAddToCart("Sauce Labs Backpack");
		hp.verifyNumberOfItemAddedToCart(1);
	}
}
