package salesforceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainAll {
	static WebDriver driver;
	public static void setDriver() throws InterruptedException {
		
	
	//static WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	Thread.sleep(5000);
	driver.get("https://login.salesforce.com/");
	driver.findElement(By.id("username")).sendKeys("ashwinir.cse-3ujh@force.com");
	driver.findElement(By.id("password")).sendKeys("Sivarani54#");

	WebElement checkbox =driver.findElement(By.xpath("//input[@id='rememberUn']"));
	System.out.println(checkbox.isSelected());
	checkbox.click();
	WebElement button=driver.findElement(By.id("Login"));
	button.click();
	Thread.sleep(5000);
	//driver.close();

}
}
