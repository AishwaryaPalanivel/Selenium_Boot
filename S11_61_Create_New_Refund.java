package sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class S11_61_Create_New_Refund {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Handle notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver(options);
		//1. Login to https://login.salesforce.com/?locale=in
		driver.get("https://login.salesforce.com/?locale=in");
		//to maximize the window
		driver.manage().window().maximize();
		//- Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//locate the username field and type the username
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		//enter the password
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//Click Login button
		driver.findElement(By.id("Login")).click();
		//2. Click on menu button from the Left corner
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		//3. Click view All and click Service Console from App Launcher
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Refunds");
		//4. Click on the drop down and select Refunds
		driver.findElement(By.xpath("//mark[text()='Refunds']")).click();
		//5. Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//6. Select Account name
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).click();
		driver.findElement(By.xpath("//span[text()='Yamuna1373200068']")).click();

		//7. Select Status as Canceled

		driver.findElement(By.xpath("(//a[@role='combobox'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Canceled'])[1]")).click();

		//		//8. Give Amount as 50000 and select Referenced in Type
		//				
		driver.findElement(By.xpath("//input[contains(@class,'uiInputSmartNumber')]")).sendKeys("50000");
		driver.findElement(By.xpath("(//a[@role='combobox'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Type']/following::a[text()='Referenced']")).click();
		//				
		//		//9. Select Processing Mode as External
		driver.findElement(By.xpath("(//a[@role='combobox'])[3]")).click();
		driver.findElement(By.xpath("//a[text()='External']")).click();

		//		//10. Click SaveExpected Result:successRefund "R-000000001" was created.Step 
		driver.findElement(By.xpath("(//button[@title='Save'])[1]")).click();
		//Refund "R-000000001" was created.
		String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(message);
		String actTitle= message;
		String expTitle="Refund \"R-000000005\" was created.";
		Assert.assertEquals(actTitle, expTitle);
		boolean displayed =driver.findElement(By.xpath("//span[text()='R-000000005']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
		driver.quit();
	}

}
