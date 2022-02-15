package com.firebase.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethoda {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public static void Launch(String element) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(element);

	}

	public static void Login(String username, String passwordEle) {
		WebElement email = driver.findElement(By.id("username"));
		email.sendKeys(username);

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(passwordEle);
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		System.out.println(checkbox.isSelected());
		checkbox.click();
		WebElement button = driver.findElement(By.id("Login"));
		button.click();

//			
	}

	public static void clickOper(WebElement ele) {
		ele.click();

	}

	public static void waitUntilVisible(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitUntilVisible60(WebElement element) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void ImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void AcceptAlert() {
		waitUntilAlertIsPresent();
		Alert alert = driver.switchTo().alert();
		System.out.println("alert text=" + alert.getText());
		alert.accept();

	}

	public static void close() {
		driver.close();
	}

	public static void PopUp() throws InterruptedException {
		//driver.findElement(By.id("lexNoThanks")).click();
		//driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.id("userNavButton")).click();
		Thread.sleep(4000);
	}
	
	public static void PopUpLight() throws InterruptedException {
		driver.findElement(By.id("lexNoThanks")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
	}
	public static void handleAcount() {
		WebElement account = driver.findElement(By.linkText("Accounts"));
		account.click();
	}

	public static void handleOppertunityReusable() {
		WebElement opertunity = driver.findElement(By.linkText("Opportunities"));
		opertunity.click();
	}

	public static void LinkReusable() {
		driver.findElement(By.linkText("Leads")).click();
	}

	public static void ContactReusable() {
		driver.findElement(By.linkText("Contacts")).click();
	}

}
