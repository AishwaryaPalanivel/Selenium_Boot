package sprint_01;

import java.time.Duration;
import java.util.Random;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Assessment_TestCase_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Handle notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver(options);
		try {
			//1. Login to https://login.salesforce.com
			driver.get("https://login.salesforce.com");
			//to maximize the window
			driver.manage().window().maximize();
			//- Add an implicit wait to ensure the web page elements are fully loaded
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//locate the username field and type the username

			driver.findElement(By.id("username")).sendKeys("ragothamanu@gmail.com");
			//enter the password
			driver.findElement(By.id("password")).sendKeys("Gr@salesforce202404");
			//Click Login button
			driver.findElement(By.id("Login")).click();

			//2. Click on menu button from the Left corner
			driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
			//3. Click view All 
			driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
			//4. Click Sales from App Launcher
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			//5.Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
			Random rand = new Random();
			int closed = rand .nextInt((4000-1000)+1)+1000;
			System.out.println("randNum1 "+closed);

			int open = rand.nextInt((7000-3500)+1)+3500;
			System.out.println("randNum2 "+open);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
			driver.findElement(By.xpath("//input[@inputmode='decimal']")).clear();
			driver.findElement(By.xpath("//input[@inputmode='decimal']")).sendKeys(String.valueOf(open+closed));
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			//	7. Navigate to Dashboard tab
			WebElement ele =driver.findElement(By.xpath("//a[@title='Dashboards']"));
			driver.executeScript("arguments[0].click()", ele);//org.openqa.selenium.JavascriptException: javascript error: Cannot read properties of undefined (reading 'defaultView')
			//8. Click on New Dashboard
			WebElement new_dashboard=driver.findElement(By.xpath("//div[@title='New Dashboard']"));
			driver.executeScript("arguments[0].click()", new_dashboard);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(0);
			//			9. Enter the Dashboard name as "YourName_Workout"
			driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Aishwarya_Workout");
			//			10. Enter Description as Testing and Click on Create
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");
			//			11. Click on Create
			driver.findElement(By.xpath("//button[text()='Create']")).click();
			//			12. Click on Done
			Thread.sleep(3000);

			// 12. Click on Done
			driver.switchTo().defaultContent();
			WebElement doneIframe = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(doneIframe);
			driver.findElement(By.xpath("//button[text()='Done']")).click();
			// 13. Click on Dashboard tab
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-target-selection-name='sfdc:TabDefinition.standard-Dashboard']")).click();
			//			//			14. Verify the Dashboard is Created
			String	dashboardName = driver.findElement(By.xpath("(//th[@data-label='Dashboard Name'])[1]")).getText();
			System.out.println(dashboardName);
			String actTitle= dashboardName;
			String expTitle="Aishwarya_Workout";
			Assert.assertEquals(actTitle, expTitle);
			boolean displayed =driver.findElement(By.xpath("//a[@title='Aishwarya_Workout']")).isDisplayed();
			Assert.assertTrue(displayed);
			System.out.println("the Dashboard is Created"+displayed);
			System.out.println("===============");
			//			//			15. Click on the newly created Dashboard
			driver.findElement(By.xpath("(//th[@data-label='Dashboard Name'])[1]")).click();
			
			//				16. Click on Subscribe
			Thread.sleep(3000);
			WebElement subscribeIframe = driver.findElement(By.xpath("(//iframe[@title='dashboard'])[2]"));
			driver.switchTo().frame(subscribeIframe);
			driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
			//			//			14. Select Frequency as "Daily"
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//span[text()='Daily']")).click();
			//					15. Time as 10:00 AM
			WebElement time = driver.findElement(By.id("time"));
			time.click();
			Select timeDD = new Select(time);
			timeDD.selectByValue("10");
			//			//			16. Click on Save
			driver.findElement(By.xpath("//span[text()='Save']")).click();
			//			//			17. Verify "You started Dashboard Subscription" message displayed or not
			WebElement message = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
			String dashboardMsg = message.getText();
			System.out.println("The  displayed message after subscribing : " + dashboardMsg);
			String act_Title= dashboardMsg;
			String exp_Title="subscription";
			Assert.assertEquals(actTitle, expTitle);
			boolean displayed_1 =driver.findElement(By.xpath("//div[contains(text(),'subscription')]")).isDisplayed();
			Assert.assertTrue(displayed_1);
			System.out.println("The  displayed message after subscribing : " +displayed_1);
			System.out.println("===============");
			//			//			18. Click on Dashboards tab
			driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-target-selection-name='sfdc:TabDefinition.standard-Dashboard']")).click();
			//			//			19. Verify the newly created Dashboard is available
			WebElement dName_1 = driver.findElement(By.xpath("(//th[@data-label='Dashboard Name'])[1]"));
			String name2 = dName_1.getText();
			System.out.println(name2);
			String act_Title_2= name2;
			String exp_Title_2="Aishwarya_Workout";
			Assert.assertEquals(actTitle, expTitle);
			boolean displayed_2 =driver.findElement(By.xpath("//a[@title='Aishwarya_Workout']")).isDisplayed();
			Assert.assertTrue(displayed_2);
			System.out.println("the newly created Dashboard is available="+displayed_2);
			System.out.println("===============");
			//			//			20. Click on dropdown for the item
			driver.findElement(By.xpath("(//lightning-primitive-cell-actions[@data-action-triggers='enter,space'])[1]")).click();
			// 21. Select Delete
			driver.findElement(By.xpath("//span[text()='Delete']")).click();
			
			// 22. Confirm the Delete
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			WebElement deleteMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
			String delMsg = deleteMsg.getText();
			System.out.println("The message displayed after deletion is " + delMsg);
			
			String act_Title_3= delMsg;
			String exp_Title_3="deleted";
			Assert.assertEquals(actTitle, expTitle);
			boolean displayed_3 =driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).isDisplayed();
			Assert.assertTrue(displayed_3);
			System.out.println("The Dashboard was deleted="+displayed_3);
			System.out.println("===============");
			// 23. Verify the item is not available under Private Dashboard folder
			driver.findElement(By.xpath("//a[@title='Private Dashboards']")).click();
			WebElement firstNameAfterDeletion = driver.findElement(By.xpath("//lightning-primitive-cell-factory[@data-label='Dashboard Name']//a"));
			String firstName = firstNameAfterDeletion.getText();
			System.out.println("The first Name after Deletion is--> " + firstName);
			
			String act_Title_final= firstName;
			String exp_Title_final="Aishwarya_Workout";
			Assert.assertEquals(actTitle, expTitle);
			boolean displayed_final =driver.findElement(By.xpath("//a[@title='Aishwarya_Workout']")).isDisplayed();
			Assert.assertTrue(displayed_final);
			System.out.println("the item is not available under Private Dashboard folder="+displayed_final);
		} catch (Exception error) {
			// TODO: handle exception
			error.printStackTrace();
		}
	}

}
