package sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class S11_23_Create_Individuals_without_mandatory_fields {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handle notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver(options);

		// Declaring Java Script Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		//to maximize the window
		driver.manage().window().maximize();
		//locate the username field and type the username
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		//enter the password
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//Click Login button
		driver.findElement(By.id("Login")).click();

		Thread.sleep(6000);
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		//3. Click View All and click Individuals from App Launcher
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		//4. Click on the Dropdown icon in the Individuals tab
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);
		WebElement individuals= driver.findElement(By.xpath("//div[contains(@class,'slds-scrollable')]//p[text()='Individuals']"));
		Actions Dropdown = new Actions(driver);
		Dropdown.moveToElement(individuals).click().build().perform();
		//4. Click on the Individuals tab 
		//		WebElement more = driver.findElement(By.xpath("//span[contains(text(),'More')]"));
		//		Actions Dropdown1 = new Actions(driver);
		//		Dropdown1.moveToElement(more).click().build().perform();

		Thread.sleep(2000);
		WebElement individualstab = driver.findElement(By.xpath("//span[contains(text(),'Individuals')][1]"));
		Actions Dropdown3 = new Actions(driver);
		Dropdown3.moveToElement(individualstab).click().build().perform();
		//5. Click on New Individual
		WebElement newindividuals = driver.findElement(By.xpath("//div[contains(text(),'New')]"));
		Actions Dropdown5 = new Actions(driver);
		Dropdown5.moveToElement(newindividuals).click().build().perform();

		//6.Select Salutation as 'Mr'
		Thread.sleep(2000);
		WebElement buttonSalutation=driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]"));
		Actions Salutation = new Actions(driver);
		Salutation.moveToElement(buttonSalutation).click().build().perform();
		Thread.sleep(2000);
		WebElement Sel_Mr = driver.findElement(By.xpath("//a[@title='Mr.']"));
		Actions Mr = new Actions(driver);
		Mr.moveToElement(Sel_Mr).click().build().perform();
		//7.Enter the first name as 'Ganesh'.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ganesh");
		//8. Click on Save
		driver.findElement(By.xpath("//div[contains(@class,'slds-text-align_right')]//span[text()='Save']")).click();
		//9. Verify the Alert message
		//String message = driver.findElement(By.xpath("//div[contains(@class,'genericNotification')]")).getText();
		//	System.out.println(message);

		//(Complete this field) displayed for the Last NameExpected Result:
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//div[contains(@class,'slds-text-align_right')]//span[text()='Save']")).click();
		String message = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(message);
		//		Complete this field message should be displayed for last Name fieldStep 
		String actTitle= message;
		String expTitle="Individual \"Ganesh Kumar\" was saved.";
		Assert.assertEquals(actTitle, expTitle);
		boolean displayed =driver.findElement(By.xpath("//input[@placeholder='Last Name']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
	}

}
