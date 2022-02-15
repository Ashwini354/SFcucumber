package salesforceproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		Thread.sleep(4000);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("ashwinir.cse-3ujh@force.com");
		driver.findElement(By.id("password")).sendKeys("");
		WebElement button=driver.findElement(By.id("Login"));
		button.click();
		Thread.sleep(5000);
		
		String act_text="Please enter your password.";
		WebElement exp_text=driver.findElement(By.id("error"));
		String ex_text=exp_text.getText();
		System.out.println(" the expeected  :"+ex_text);
		//either use this way or that way
//		if(exp_text.getText().equalsIgnoreCase(act_text)) {
//			System.out.println("test case true");
//		}
//			else {
//				System.out.println("the tescase fail");
//			}
//		}
		if(act_text.equals(ex_text)==true) {
			System.out.println("the tescase pass");
		}
		else {
			System.out.println("the tescase fail");
		}
		
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
