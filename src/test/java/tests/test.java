package tests;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class test {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://stag2-feedback.orangehealth.dev/task/29260/?uuid=1699c3b9-0070-450b-b088-575ebe489457");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='EDTA']/following-sibling::button")).click();
		
		driver.findElement(By.xpath("//p[text()='Add Manually']")).click();
		
		driver.findElement(By.id("number-input")).sendKeys("4784833893");
		
		
		
		
		
//		driver.findElement(By.xpath("//p[text()='Add Barcode']/..")).sendKeys("./SwagLabs_TestNG/screenshots/Screenshot.png");
		
		
		try {
			
			
        
            // Find the file input element
            WebElement fileInput = driver.findElement(By.xpath("//p[text()='Add Barcode']/..")); // Replace with the correct locator
            
            // Use JavaScript to set the value of the file input
            File file = new File("SwagLabs_TestNG/screenshots/Screenshot.png");
            
            String filePath = file.getAbsolutePath(); // Replace with the path to your file
            System.out.println(filePath);
            fileInput.sendKeys(filePath);
            fileInput.click();
            
   
        } finally {
            
           // driver.quit();
        }

	}
}

