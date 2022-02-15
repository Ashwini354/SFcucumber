package salesforceproject;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.firebase.base.ReusableMethoda;
import com.teckarch.config.salesPropConfiguration;

public class AutomationScript extends ReusableMethoda {
	private static Properties prop;
	static {
		prop = salesPropConfiguration.loadProperties();
	}

	//@Test()
	public static void EnterUserNameNoPassword1() throws InterruptedException {
		Launch(prop.getProperty("url"));
		ImplicitWait();
		driver.findElement(By.id("username")).sendKeys("ashu@techarc.com");
		driver.findElement(By.id("password")).sendKeys("");
		WebElement button = driver.findElement(By.id("Login"));
		button.click();
	
		String act_text = "Please enter your password.";
		WebElement exp_text = driver.findElement(By.id("error"));
		String ex_text = exp_text.getText();
		System.out.println(" the expeected  :" + ex_text);

		if (act_text.equals(ex_text) == true) {
			System.out.println("the tescase pass");
		} else {
			System.out.println("the tescase fail");
		}

		Thread.sleep(3000);
		driver.close();

	}
	@Test()

	public  void ValidateUserName2() throws InterruptedException {
		Launch(prop.getProperty("url"));
		Login(prop.getProperty("usernameSales"), prop.getProperty("passwordSales"));
		ImplicitWait();
		//driver.findElement(By.id("lexNoThanks")).click();
		//driver.findElement(By.id("tryLexDialogX")).click();

		driver.findElement(By.id("userNavButton")).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText("Logout")).click();

		String act_txt = "ashu@techarc.com";
		WebElement user = driver.findElement(By.id("idcard-identity"));
		Thread.sleep(7000);
		String exp_txt = user.getText();
		System.out.println(exp_txt);
		if (act_txt.equals(exp_txt) == true) {
			System.out.println("the tescase pass");
		} else {
			System.out.println("the tescase fail");
		}
		close();

	}

	//@Test()
	public static void HandleForgotPassword3() throws InterruptedException {
		Launch(prop.getProperty("url"));
		driver.findElement(By.id("forgot_password_link")).click();
		driver.findElement(By.id("un")).sendKeys("ashu@techarc.com");
		driver.findElement(By.id("continue")).click();
		String act_text = "Check Your Email";
		WebElement exp_text = driver.findElement(By.id("header"));
		String ex_text = exp_text.getText();
		System.out.println(" the expeected  :" + ex_text);
		assertEquals(act_text, ex_text);

		if (act_text.equals(ex_text) == true) {
			System.out.println("the tescase pass");
		} else {
			System.out.println("the tescase fail");
		}

		Thread.sleep(5000);
		close();
	}

	// @Test()
	public static void ValidateLoginErrorMessage4() throws InterruptedException {
		Launch(prop.getProperty("url"));
		Login(prop.getProperty("user"), prop.getProperty("pass"));
		ImplicitWait();
		String act_text = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		WebElement exp_text = driver.findElement(By.id("error"));
		String ex_text = exp_text.getText();
		System.out.println(" the expeected  :" + ex_text);

		if (act_text.equals(ex_text) == true) {
			System.out.println("the tescase pass");
		} else {
			System.out.println("the tescase fail");
		}

		Thread.sleep(5000);
		close();
	}

	 //@Test()
	public static void handleUserMenuDropdown5() throws InterruptedException {
		Launch(prop.getProperty("url"));
		Login(prop.getProperty("usernameSales"), prop.getProperty("passwordSales"));
		ImplicitWait();
		//driver.findElement(By.id("lexNoThanks")).click();
		//driver.findElement(By.id("tryLexDialogX")).click();
		driver.findElement(By.id("userNavButton")).click();
		Thread.sleep(3000);
		
		List<WebElement> Allmenu = driver.findElements(By.xpath("//div[@id='userNav-menuItems']"));
		for (WebElement menu : Allmenu) {

			System.out.println("menu -->" + menu.getText());
			String[] str = menu.getText().split("\\n");
			List<String> menuList = Arrays.asList(str);
			if (menuList.contains("My Profile") || menuList.contains("My Settings")
					|| menuList.contains("Developer Console") || menuList.contains("Switch to Lightning Experience")
					|| menuList.contains("Logout")) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}

		}
		close();

	}

	// @Test()
	public  void handleUploadImage6() throws InterruptedException {

		driver.findElement(By.linkText("My Profile")).click();

		WebElement editbutton = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		waitUntilVisible(editbutton);
		editbutton.click();
		driver.switchTo().frame("contactInfoContentId");

		driver.findElement(By.xpath("//a[normalize-space()='About']")).click();
		Thread.sleep(4000);
		WebElement lastname = driver.findElement(By.id("lastName"));
		lastname.clear();
		lastname.sendKeys("pandiyan");
		waitUntilVisible(lastname);
		driver.findElement(By.xpath("//input[@value='Save All']")).click();
		ImplicitWait();
		driver.findElement(By.xpath("//span[normalize-space()='Post']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//body")).sendKeys("hi all");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		// upload image
		WebElement load = driver.findElement(By.id("displayBadge"));
		Actions a = new Actions(driver);
		a.moveToElement(load).build().perform();
		driver.findElement(By.linkText("Add Photo")).click();
		Thread.sleep(3000);
//		driver.switchTo().frame(0);
//		Thread.sleep(3000);
		
	    driver.switchTo().frame("uploadPhotoContentId");
		WebElement image=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
				
		image.sendKeys("/Users/ashwiniramamurthy/Downloads/ashu.jpg");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("uploadPhotoContentId");
		driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")).click();

		close();
	}

	//@Test()
	public static void handleMySetting7() throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='My Settings']")).click();
		driver.findElement(By.id("PersonalInfo")).click();
		driver.findElement(By.id("LoginHistory_font")).click();
		WebElement download = driver
				.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		download.click();
		// display and layout:
		driver.findElement(By.id("DisplayAndLayout_font")).click();
		driver.findElement(By.id("CustomizeTabs_font")).click();
		WebElement select = driver.findElement(By.id("p4"));
		select.click();
		Select select_sales=new Select(select);
		select_sales.selectByVisibleText("Salesforce Chatter");
		//remove
		
		List<WebElement> check1=driver.findElements(By.id("duel_select_1"));
		for(WebElement c1:check1) {
			if(c1.getText().contains("Reports")) {
				if(c1.isDisplayed()) {
					WebElement report_remove=driver.findElement(By.id("duel_select_1"));
					Select select4=new Select(report_remove);
					select4.selectByVisibleText("Reports");
					
					WebElement remove=driver.findElement(By.xpath("//a[@id='duel_select_0_left']"));
					remove.click();
					waitUntilVisible(remove);
					
				System.out.println(" REPORTS REMOVED");
				
				
			}
			}
			else {
				System.out.println("REPORTS NOT REMOVED");
			}
		}
		Thread.sleep(7000);	
		List<WebElement> dropdown=driver.findElements(By.id("duel_select_0"));
		for(WebElement drop:dropdown) {
			if(drop.getText().contains("Reports")) {
				if(drop.isSelected()) {
				System.out.println("ALREADY SELECTED");
			}
		
			else if(!drop.isSelected()) {
				WebElement dropdown1=driver.findElement(By.id("duel_select_0"));
				
				Select select1=new Select(dropdown1);
				
				select1.selectByVisibleText("Reports");
				System.out.println("REPORTS  SELECTED");
				driver.findElement(By.xpath("//img[@title='Add']")).click();
				
			}
		}
		
		}
		Thread.sleep(5000);
	
		driver.findElement(By.xpath("//a[@id='duel_select_0_right']")).click();
		ImplicitWait();
         driver.findElement(By.xpath("//input[@value=' Save ']")).click();
         //email
		driver.findElement(By.id("EmailSetup_font")).click();
		driver.findElement(By.id("EmailSettings_font")).click();
		WebElement name = driver.findElement(By.id("sender_name"));
		name.clear();
		name.sendKeys("123");
		WebElement mail = driver.findElement(By.id("sender_email"));
		mail.clear();
		mail.sendKeys("ashwinir.cse@gmail.com");
		WebElement radio = driver.findElement(By.id("auto_bcc1"));

		System.out.println("Radio " + radio.isSelected());
		if (!radio.isSelected()) {
			radio.click();
		} else {
			System.out.println("not");
		}
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		String ex_test = "Your settings have been successfully saved.";
		WebElement ac = driver.findElement(By.xpath("//div[@class='messageText']"));
		String ac_text = ac.getText();
		assertEquals(ex_test, ac_text);
		// calender
		driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']")).click();
		driver.findElement(By.xpath("//span[@id='Reminders_font']")).click();
		driver.findElement(By.xpath("//input[@id='testbtn']")).click();
		
	}

	// @Test()
	public static void handleDeveloperConsole8() throws InterruptedException {

		WebElement windowbutton = driver.findElement(By.linkText("Developer Console"));
		String oldwindow = driver.getWindowHandle();
		windowbutton.click();
		Thread.sleep(5000);
		Set<String> window2 = driver.getWindowHandles();
		System.out.println(window2.size());
		for (String Windows : window2) {
			if (!Windows.equals(oldwindow)) {
				driver.switchTo().window(Windows);
				break;
				// System.out.println();
			}
		}
		driver.switchTo().window(oldwindow);
		close();

	}

	// @Test()
	public static void handleLogout9() throws InterruptedException {

		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.click();
		String e="ashu@techarc.com";
		
		Assert.assertEquals(e,driver.findElement(By.id("idcard-identity")).getText()); 
		System.out.println("test case pass:  ");
		//close();

	}

	// @Test()
	public static void handleCreateAccount10() throws InterruptedException {

		WebElement account = driver.findElement(By.linkText("Accounts"));
		account.click();
		PopUpLight();
		driver.findElement(By.id("createNewLabel")).click();
		Thread.sleep(3000);

		List<WebElement> menu = driver.findElements(By.id("createNewMenu"));
		System.out.println(menu.get(0).getText());
		// Click Account
		menu.get(0).findElement(By.xpath("//*[@id=\"createNewMenu\"]/a[5]")).click();

		WebElement acc_e=driver.findElement(By.id("acc2"));
		acc_e.clear();
		acc_e.sendKeys("saving");
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();
		
		WebElement acc=driver.findElement(By.xpath("//tbody//tr//td[@id='acc1_ilecell']//a[text()='ashwini pandiyan']"));
		Assert.assertEquals(acc.getText(), "ashwini pandiyan");
		
		WebElement acc1=driver.findElement(By.xpath("//div[@id='acc2_ileinner']"));
		Assert.assertEquals(acc1.getText(), "saving [View Hierarchy]");
		System.out.println("TEST CASE PASS");
		

	}

	// @Test()
	public static void handleCreateNewVeiw11() throws InterruptedException {

		handleAcount();
		PopUpLight();
		driver.findElement(By.linkText("Create New View")).click();
		WebElement name=driver.findElement(By.xpath("//input[@id='fname']"));
		name.clear();
		name.sendKeys("aa");
		WebElement uniq_name=driver.findElement(By.xpath("//input[@id='devname']"));
		uniq_name.clear();
		uniq_name.sendKeys("123");
		driver.findElement(By.xpath("//input[contains(@data-uidsfdc,'3')]")).click();

	}

	// @Test()
	public static void handleEditView12() throws InterruptedException {

		handleAcount();
		PopUpLight();
		driver.findElement(By.id("fcf")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement name=driver.findElement(By.xpath("//input[@id='fname']"));
		name.clear();
		name.sendKeys("nature123");
		WebElement dropdown = driver.findElement(By.id("fcol1"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Account Name");
		WebElement dropdown1 = driver.findElement(By.id("fop1"));
		Select select1 = new Select(dropdown1);
		select1.selectByVisibleText("contains");
		WebElement dropdown2 = driver.findElement(By.id("fval1"));
		dropdown2.sendKeys("a");
		// select field
		WebElement selectfield = driver.findElement(By.id("colselector_select_0"));
		Select select2 = new Select(selectfield);
		select2.selectByVisibleText("Last Activity");
		driver.findElement(By.xpath("//img[@title='Add']")).click();
		driver.findElement(By.xpath("//input[@data-uidsfdc='5']")).click();

	}

	 //@Test()
	public static void handleMergeAccount13() throws InterruptedException {

		handleAcount();
		PopUpLight();
		ImplicitWait();
		driver.findElement(By.linkText("Merge Accounts")).click();
		ImplicitWait();
		driver.findElement(By.id("srch")).sendKeys("saving");
		driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[2]")).click();
		ImplicitWait();
		
		WebElement s=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/th[1]"));
		waitUntilVisible(s);
				if(!s.isSelected()) {
					s.click();
					System.out.println("selected");
					Thread.sleep(3000);
				}
				WebElement s1=driver.findElement(By.xpath("//html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/th[1]"));
				if(!s1.isSelected()) {
					s1.click();
					System.out.println("selected1");
					Thread.sleep(3000);
					
				}
				
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Next']")).click();
		driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@title='Merge']")).click();
		AcceptAlert();

	}

	 //@Test()
	public static void handleCreateAccReport14() throws InterruptedException {

		handleAcount();
		PopUpLight();
		driver.findElement(By.linkText("Accounts with last activity > 30 days")).click();
		driver.findElement(By.id("ext-gen148")).click();
		List<WebElement> createdate = driver.findElements(By.xpath("//div[@class='dateColumnCategory']"));
		System.out.println(createdate.get(0).getText());
		createdate.get(0).findElement(By.xpath("//div[@class='x-combo-list-item x-combo-selected']")).click();
		Thread.sleep(3000);
		WebElement img=driver.findElement(By.xpath("//img[@id='ext-gen152']"));
				img.click();
				
		WebElement dat1 = driver.findElement(By.xpath("//td[@title='Today']//span[contains(text(),'30')]"));
		dat1.click();
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[normalize-space()='18']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='18']")).click();
		driver.findElement(By.xpath("//button[@id='ext-gen49']")).click();
		ImplicitWait();
		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("happy");
		driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).sendKeys("happy123");
		Thread.sleep(5000);
		WebElement save = driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"));
		save.click();
		waitUntilVisible(save);

	}

	 //@Test()
	public static void handleopertinityt15() throws InterruptedException {

		handleOppertunityReusable();
		PopUpLight();
		List<WebElement> oper = driver.findElements(By.id("open"));
		for (WebElement operator : oper) {
			// System.out.println(oper.get(0).getText());
			String[] str = operator.getText().split("\\n");
			List oper_one = Arrays.asList(str);

			if (oper_one.contains("All Opportunities") || oper_one.contains("Open Opportunities")
					|| oper_one.contains("Closed Opportunities") || oper_one.contains("Closed/Won Opportunities")) {
				System.out.println(" Test case pass");
			} else {
				System.out.println("fail");
			}
		}

	}
	//@Test()
	public static void handleopertinitytaccount16() throws InterruptedException {
		handleOppertunityReusable();
		PopUpLight();
		driver.findElement(By.id("createNewLabel")).click();
		Thread.sleep(3000);

		List<WebElement> menu = driver.findElements(By.id("createNewMenu"));
		System.out.println(menu.get(0).getText());

		
		menu.get(0).findElement(By.xpath("//a[normalize-space()='Opportunity']")).click();
		WebElement lname=driver.findElement(By.id("opp3"));
		lname.clear();
				lname.sendKeys("manager");
		WebElement l=driver.findElement(By.id("opp4"));
		l.clear();
				l.sendKeys("saving23");
		driver.findElement(By.id("opp9")).click();
		WebElement time = driver.findElement(By.linkText("Today"));
		time.click();
		waitUntilVisible(time);
		WebElement dropdown = driver.findElement(By.id("opp11"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Qualification");

		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();

	}

	 //@Test()
	public static void handleopertinitytPipeline17() throws InterruptedException {

		handleOppertunityReusable();
		PopUpLight();
		
		WebElement oper_pipeline = driver.findElement(By.linkText("Opportunity Pipeline"));
		oper_pipeline.click();

	}

	 //@Test()
	public static void handleopertinitytStuck18() throws InterruptedException {

		handleOppertunityReusable();
		PopUpLight();
		
		WebElement ope_stuck = driver.findElement(By.linkText("Stuck Opportunities"));
		ope_stuck.click();

	}

	 //@Test()
	public static void handleopertinitytQuarterlySummary19() throws InterruptedException {

		handleOppertunityReusable();
		PopUpLight();
		ImplicitWait();
		driver.findElement(By.xpath("//select[@id='quarter_q']")).click();
		driver.findElement(By.xpath("//select[@id='open']")).click();

	}

	//@Test()
	public static void handleLeads20() throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		PopUpLight();

	}

	@AfterMethod
	public static void CloseAll() {
		close();
	}

	// @Test()
	public static void handleLeads21() throws InterruptedException {

		LinkReusable();
		PopUpLight();
		WebElement selectfield = driver.findElement(By.id("fcf"));
		selectfield.click();
		List<WebElement> link = driver.findElements(By.id("fcf"));
		for (WebElement linkall : link) {
			// System.out.println(oper.get(0).getText());
			String[] str = linkall.getText().split("\\n");
			List<String> linkopt = Arrays.asList(str);

			if (linkopt.contains("All Open Leads") || linkopt.contains("Lost Leads")
					|| linkopt.contains("My Unread Leads") || linkopt.contains("Recently Viewed Leads")) {
				System.out.println(" Test case pass");
			} else {
				System.out.println("fail");
			}
		}
	}

	//@BeforeMethod()
	public  void LoginLaunchBefore() throws InterruptedException {
		Launch(prop.getProperty("url"));
		Login(prop.getProperty("usernameSales"), prop.getProperty("passwordSales"));
		ImplicitWait();
		PopUp();
	}

	 //@Test()
	public static void handleDefaultView22() throws InterruptedException {

		LinkReusable();
		PopUpLight();
		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByVisibleText("Today's Leads");
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.linkText("Logout")).click();
		Launch(prop.getProperty("url"));
		Login(prop.getProperty("usernameSales"), prop.getProperty("passwordSales"));
		ImplicitWait();
		PopUp();
		LinkReusable();
		PopUpLight();

		Thread.sleep(5000);
		WebElement selectfield = driver.findElement(By.id("fcf"));
		selectfield.click();
		List<WebElement> link = driver.findElements(By.id("fcf"));
		for (WebElement linkall : link) {
			// System.out.println(oper.get(0).getText());
			String[] str = linkall.getText().split("\\n");
			List<String> linkopt = Arrays.asList(str);

			if (linkopt.contains("Today's Leads")) {
				System.out.println(" Test case pass");
			} else {
				System.out.println("fail");
			}
		}

	}

	 //@Test()
	public static void handleTodayView23() throws InterruptedException {
		LinkReusable();
		PopUpLight();
		driver.findElement(By.xpath("//input[@title='Go!']")).click();

	}

//@Test()
	public static void handleTodayView24() throws InterruptedException {
		LinkReusable();
		PopUpLight();
		driver.findElement(By.xpath("//input[@title='New']")).click();// new
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys("ABCD");// lastname
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ABCD");// company
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();// save

		Thread.sleep(5000);
	}

//@Test()
	public static void handleContact25() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		driver.findElement(By.id("createNewLabel")).click();// contactmenu
		Thread.sleep(3000);
		List<WebElement> menu = driver.findElements(By.id("createNewMenu"));// select
		System.out.println(menu.get(0).getText());
		// Click Account
		menu.get(0).findElement(By.xpath("//img[@title='Contact']")).click();
		WebElement lname =driver.findElement(By.id("name_lastcon2"));
		lname.clear();
		lname.sendKeys("pranavee");// lastname
		WebElement acc =driver.findElement(By.id("con4"));
		acc.clear();
		acc.sendKeys("saving23");// company
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']")).click();
		// checking
		WebElement act_t = driver.findElement(By.xpath("//h2[@class='topName']"));
		String act_text = act_t.getText();
		String ex_t = "pranavee";
		Assert.assertEquals(ex_t, act_text);
		System.out.println("equal");

	}

//@Test()
	public static void handleContact26() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		driver.findElement(By.xpath("//a[text()='Create New View']")).click();// create new veiw
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("techarcha");// veiw name
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("techarcha");// unique name
		driver.findElement(
				By.xpath("//div[@class='pbHeader']//table//td[@class='pbButtonb']//input[@class='btn primary']"))
				.click();// save

	}

//@Test()
	public static void handleContact27() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		WebElement dropdown = driver.findElement(By.id("hotlist_mode"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByVisibleText("Recently Created");
		List<WebElement> create = driver.findElements(By.id("fcf"));
		for (WebElement linkall : create) {
//System.out.println(oper.get(0).getText());
			String[] str = linkall.getText().split("\\n");
			List<String> linkopt = Arrays.asList(str);

			if (linkopt.contains("Recently Created")) {
				System.out.println(" Test case pass");
			} else {
				System.out.println("fail");
			}
		}

	}

//@Test()
	public static void handleContact28() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		WebElement dropdown = driver.findElement(By.id("fcf"));

		Select select = new Select(dropdown);
		select.selectByIndex(4);// veiw
		driver.findElement(By.xpath("//input[@title='Go!']")).click();

	}

//@Test()
	public  void handleContact29() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		driver.findElement(By.xpath("//tbody/tr[@class='dataRow even first']/th[1]/a[1]")).click();

	}

//@Test()
	public  void handleContact30() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		driver.findElement(By.xpath("//a[normalize-space()='Create New View']")).click();
		driver.findElement(By.cssSelector("#devname")).sendKeys("EFGH");
		driver.findElement(By.xpath(
				"//form[@id='editPage']//div[@class='pbHeader']//table//tr//td[@class='pbButtonb']//input[@name='save']"))
				.click();
		WebElement error = driver.findElement(By.xpath("//div[@class='requiredInput']//div[@class='errorMsg']"));
		String ac = error.getText();
		String ex = "Error: You must enter a value";
		Assert.assertEquals(ac, ex);
		System.out.println("Condition pass");

	}

	//@Test()
	public  void handleContact31() throws InterruptedException {
		ContactReusable();
		PopUpLight();
		driver.findElement(By.xpath("//a[normalize-space()='Create New View']")).click();
		WebElement name=driver.findElement(By.cssSelector("#fname"));
		name.clear();
				name.sendKeys("ABCD");
		WebElement uniquename=driver.findElement(By.cssSelector("#devname"));
		uniquename.click();
			uniquename.sendKeys("EFGH");
		driver.findElement(By.xpath(
				"//form[@id='editPage']//div[@class='pbHeader']//table//tr//td[@class='pbButtonb']//input[@name='cancel']")).click();
		WebElement e=driver.findElement(By.xpath("//h2[normalize-space()='Home']"));
		Assert.assertEquals(e.getText(), "Home");
		System.out.println("pass");
		

	}
	//@Test
	public  void handleContact32() throws InterruptedException {
		
		ContactReusable();
		PopUpLight();
		driver.findElement(By.xpath("//input[@title='New']")).click();
		WebElement name=driver.findElement(By.id("name_lastcon2"));
		name.clear();
		name.sendKeys("indian");
		WebElement lname=driver.findElement(By.id("con4"));
		lname.clear();
		lname.sendKeys("global media");
		
		WebElement save=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
				save.click();
				//waitUntilVisible(save);
				Thread.sleep(5000);
				
}
	//@Test
	public  void handleRandomScenario33() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		PopUpLight();
		WebElement firstname=driver.findElement(By.xpath("//div[@class='greeting']//a[@href='/_ui/core/userprofile/UserProfilePage']"));
		firstname.click();
		WebElement e=driver.findElement(By.linkText("ashwini pandiyan"));
		Assert.assertEquals(e.getText(),"ashwini pandiyan");
		System.out.println("TEST CASE PASS");
	}
	//@Test
	public  void handleRandomScenario34() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		PopUpLight();
		WebElement firstname=driver.findElement(By.xpath("//div[@class='greeting']//a[@href='/_ui/core/userprofile/UserProfilePage']"));
		firstname.click();
	WebElement editbutton = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
	waitUntilVisible(editbutton);
	editbutton.click();
	driver.switchTo().frame("contactInfoContentId");

	driver.findElement(By.xpath("//a[normalize-space()='About']")).click();
	Thread.sleep(4000);
	WebElement lastname = driver.findElement(By.id("lastName"));
	lastname.clear();
	lastname.sendKeys("ABCD");
	waitUntilVisible(lastname);
	driver.findElement(By.xpath("//input[@value='Save All']")).click();
	ImplicitWait();
	WebElement e=driver.findElement(By.id("tailBreadcrumbNode"));
	Assert.assertEquals(e.getText(),"ashwini ABCD");
	System.out.println("TEST CASE PASS");
		
	
}
//@Test
	public  void handleRandomScenario35() throws InterruptedException {
		
		WebElement plus=driver.findElement(By.xpath("//a[@href='/home/showAllTabs.jsp']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", plus);
				
		
	WebElement customize_tab=driver.findElement(By.xpath("//input[@title='Customize My Tabs']"));
			customize_tab.click();
			//waitUntilVisible(customize_tab);
			List<WebElement> check=driver.findElements(By.id("duel_select_0"));
			for(WebElement c:check) {
				if(c.getText().contains("Reports")) {
					if(c.isSelected()) {
						System.out.println("yes");
					}
					else {
						WebElement e=driver.findElement(By.id("duel_select_0"));
						Select s=new Select(e);
						s.selectByVisibleText("Reports");
						driver.findElement(By.xpath("//img[@title='Add']")).click();
					}
				}
				
			}
			
			
			WebElement dropdown=driver.findElement(By.id("duel_select_1"));
			Select select=new Select(dropdown);
			select.selectByVisibleText("Reports");
			
			WebElement remove=driver.findElement(By.xpath("//a[@id='duel_select_0_left']"));
			remove.click();
			waitUntilVisible(remove);
			Thread.sleep(3000);
			List<WebElement> check1=driver.findElements(By.id("duel_select_0"));
			for(WebElement c1:check1) {
				if(c1.getText().contains("Reports")) {
					
					System.out.println("true");
				}
				else {
					System.out.println("fail");
				}
			}
			
			WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
			save.click();
			WebElement usermenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			usermenu.click();
			WebElement logout=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
			logout.click();
			Launch(prop.getProperty("url"));
			Login(prop.getProperty("usernameSales"), prop.getProperty("passwordSales"));
			ImplicitWait();
			PopUp();
			List<WebElement> check2=driver.findElements(By.id("tabBar"));
			for(WebElement c2:check2) {
				if(!c2.getText().contains("Reports")) {
					
					System.out.println("Test Case Pass");
				}
				else {
					System.out.println("Test Case Fail");
				}
			}
			
		
	}
	//@Test
	public  void handleRandomScenario36() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		PopUpLight();
		WebElement date=driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]"));
	    Assert.assertEquals(date, date);
		System.out.println(" Date True");
		date.click();
		WebElement name=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/h1[1]"));
		String e="Calendar for ashwini ABCD - Day View";
		Assert.assertEquals(e, name.getText());
		System.out.println(" Name True");
		WebElement eight=driver.findElement(By.xpath("//a[normalize-space()='8:00 PM']"));
		eight.click();
		WebElement combo=driver.findElement(By.xpath("//a[@title='Combo (New Window)']"));
		String oldwindow = driver.getWindowHandle();
		combo.click();
		Thread.sleep(5000);
		Set<String> window2 = driver.getWindowHandles();
		System.out.println(window2.size());
		for (String Windows : window2) {
			if (!Windows.equals(oldwindow)) {
				driver.switchTo().window(Windows);
				break;
				// System.out.println();
			}
		}
	
		WebElement button=driver.findElement(By.cssSelector("a[href='javascript:pickValue(4);']"));
		
		button.click();
		driver.switchTo().window(oldwindow);
		//waitUntilVisible(button);
		driver.findElement(By.id("EndDateTime_time")).click();
		WebElement nine=driver.findElement(By.xpath("//div[@id='timePickerItem_42']"));
	    nine.click();
	    WebElement save=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
	    save.click();
	    WebElement mouseover=driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id69:28:j_id71:0:j_id72:calendarEvent:i']//div[@class='multiLineEventBlock dragContentPointer']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(mouseover).build().perform();
	    WebElement check=driver.findElement(By.xpath("//td[normalize-space()='1/30/2022, 9:00 PM']"));
	    Assert.assertEquals(check.getText(), "1/30/2022, 9:00 PM");
	    System.out.println("9.00 PM Checked");
	    WebElement check1=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]"));
	   
	    
	}
	//@Test
	public  void handleRandomScenario37() throws InterruptedException {
		driver.findElement(By.linkText("Home")).click();
		PopUpLight();
		Thread.sleep(5000);
		///html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]
		WebElement date=driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[2]/span[2]/a[1]"));
	    Assert.assertEquals(date, date);
		System.out.println(" Date True");
		date.click();
		WebElement name=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/h1[1]"));
		String e="Calendar for ashwini ABCD - Day View";
		Assert.assertEquals(e, name.getText());
		System.out.println(" Name True");
		WebElement eight=driver.findElement(By.xpath("//a[normalize-space()='4:00 PM']"));
		eight.click();
		WebElement combo=driver.findElement(By.xpath("//a[@title='Combo (New Window)']"));
		String oldwindow = driver.getWindowHandle();
		combo.click();
		Thread.sleep(5000);
		Set<String> window2 = driver.getWindowHandles();
		System.out.println(window2.size());
		for (String Windows : window2) {
			if (!Windows.equals(oldwindow)) {
				driver.switchTo().window(Windows);
				break;
				// System.out.println();
			}
		}
	
		WebElement button=driver.findElement(By.cssSelector("a[href='javascript:pickValue(4);']"));
		
		button.click();
		driver.switchTo().window(oldwindow);
		//waitUntilVisible(button);
		driver.findElement(By.id("EndDateTime_time")).click();
		WebElement seven=driver.findElement(By.xpath("//div[@id='timePickerItem_34']"));
	seven.click();
		WebElement checkbox=driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
		else {
			System.out.println("ALREADY SELECTED");
		}
		WebElement weelkly_radio=driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		if(!weelkly_radio.isSelected()) {
			weelkly_radio.click();
		}
		else {
			System.out.println("ALREADY SELECTED");
		}
		WebElement two_weeks=driver.findElement(By.id("RecurrenceEndDateOnly"));
		two_weeks.click();
		WebElement arrow_button=driver.findElement(By.xpath("//img[@title='Next Month']"));
		arrow_button.click();
		WebElement select_date=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[2]/table[1]/tbody[1]/tr[3]/td[6]"));
		select_date.click();
		
		WebElement save=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
	    save.click();
		
	}
	
}
