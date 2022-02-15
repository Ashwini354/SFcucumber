package salesforceproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginHome extends MainAll {

	public static void main(String[] args) throws InterruptedException {
		
		setDriver();
		String tittle=driver.getTitle();
		System.out.println(tittle);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		//driver.findElement(By.xpath("//button[@class='slds-button branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action forceHeaderButton']")).click();
		
		
		//selecting switch to classic
		//driver.findElement(By.xpath("//a[normalize-space()='Switch to Salesforce Classic']")).click();
		//Thread.sleep(7000);
		 driver.findElement(By.id("lexNoThanks")).click();
		 driver.findElement(By.id("tryLexDialogX")).click();
		 
		
		driver.findElement(By.id("userNavButton")).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText("Logout")).click();
		
		String act_txt="ashwinir.cse-3ujh@force.com";
		WebElement user=driver.findElement(By.id("idcard-identity"));
		Thread.sleep(7000);
		String exp_txt=user.getText();
		System.out.println(exp_txt);
		if(act_txt.equals(exp_txt)==true) {
			System.out.println("the tescase pass");
		}
		else {
			System.out.println("the tescase fail");
		}
		
		
		}
		

		
		
		
		
		
	}



