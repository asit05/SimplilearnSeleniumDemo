package tests;

import org.testng.annotations.AfterMethod;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	

	@Parameters(/*"Browser"*/)
	@BeforeMethod(alwaysRun = true)
	public void setup(/*String browser*/) {
		
		String browser = System.getProperty("Browser");
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
