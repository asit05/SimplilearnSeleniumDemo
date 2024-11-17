package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	public void test() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://stag2-feedback.orangehealth.dev/task/29178/?uuid=63dc2d51-4ad3-4cc8-8def-051497f3d674&campId=6004&token=abcd&isEclinic=true&partnerCode=PCA3Y7U81BtawAwB");
		Thread.sleep(10000);
		System.out.println(driver.findElement(By.xpath("//p[text()='Request ID: ']/b")).getText());
	}
}
