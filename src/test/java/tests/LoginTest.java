package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

@Listeners(Listener.class)
public class LoginTest extends BaseClass {

	@Test(groups = {"sanity"}, description = "This is login success test")
	public void TC01_LoginSuccessTest() {
		LoginPage lp = new LoginPage(GetDriver());
		HomePage hp = new HomePage(GetDriver());
		lp.loginToSwagLabs("standard_user", "secret_sauce");
		hp.verifyHomePage();
	}

	@Test(groups = {"sanity"}, description = "This is login failure test")
	public void TC02_LoginFailureTest() {
		LoginPage lp = new LoginPage(GetDriver());
		lp.loginToSwagLabs("standard_user", "secret");
		lp.verifyErrorText("Epic sadface: Username and password do not match any user in this service");
	}

	@Test
	public void TC03_LockedUserTest() {
		LoginPage lp = new LoginPage(GetDriver());
		lp.loginToSwagLabs("locked_out_user", "secret_sauce");
		lp.verifyErrorText("Epic sadface: Sorry, this user has been locked out.");
	}
}
