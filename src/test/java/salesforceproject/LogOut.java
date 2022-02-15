package salesforceproject;

import org.openqa.selenium.By;

public class LogOut extends MainAll {

	public static void main(String[] args) throws InterruptedException {
		setDriver();
		Thread.sleep(10000);
     driver.findElement(By.xpath("//button[@class='slds-button branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action forceHeaderButton']")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("tryLexDialogFocusPoint")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("userNavButton")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
//		Thread.sleep(3000);
//		

	}

}
