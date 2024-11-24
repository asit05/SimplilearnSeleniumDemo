package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public XSSFWorkbook wbook;
	public XSSFSheet sheet;

	private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public void SetDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	public WebDriver GetDriver() {

		return threadLocalDriver.get();

	}

	@Parameters(/* "Browser" */)
	@BeforeMethod(alwaysRun = true)
	public void setup(/* String browser */) throws Throwable {

		String browser = System.getProperty("Browser");
		// String browser = "chrome";

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-using");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--headless");
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("remote-chrome")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.MAC);
			cap.setBrowserName("chrome");

			URL hub = new URL("http://localhost:4444/");
			driver = new RemoteWebDriver(hub, cap);
		} else {
			driver = new ChromeDriver(options);
		}

		SetDriver(driver);
		GetDriver().get("https://www.saucedemo.com/v1/index.html");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		GetDriver().quit();
	}

//	@BeforeTest(alwaysRun=true)
	public void SetUpExcel() throws IOException {

		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");

	}

//	@AfterTest(alwaysRun=true)
	public void CloseExcel() throws IOException {

		wbook.close();

	}

}
