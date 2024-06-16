package sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class S11_22_Delete_Individuals {

	public static void main(String[] args) throws Exception {
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

		//2. Click on the toggle menu button from the left corner
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		//3. Click View All and click Individuals from App Launcher
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		//- Add an implicit wait to ensure the web page elements are fully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);
		WebElement individuals= driver.findElement(By.xpath("//div[contains(@class,'slds-scrollable')]//p[text()='Individuals']"));
		Actions Dropdown = new Actions(driver);
		Dropdown.moveToElement(individuals).click().build().perform();

		//4. Click on the Individuals tab 
		Thread.sleep(4000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement individualslist = driver.findElement(By.xpath("//span[contains(text(),'Individuals')][1]"));
		Actions Dropdown3 = new Actions(driver);
		Dropdown3.moveToElement(individualslist).click().build().perform();

		//5. Search the Individuals 'Kumar'

		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Kumar"+Keys.ENTER);

		//6. Click on the Dropdown icon and Select Delete
		Thread.sleep(4000);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//table/tbody/tr[8]/td[6]")).click();
		Thread.sleep(2000);

		WebElement SelDelete1 = driver.findElement(By.xpath("//a[@title='Delete']"));
		Actions Delete_b = new Actions(driver);
		Delete_b.moveToElement(SelDelete1).perform();
		SelDelete1.click();
		//	//	7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		// //			8. Verify Whether Individual is Deleted using Individual last nameExpected result:The Individual is deleted Successfully Step
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(message);
		String actTitle= message;
		String expTitle="Individual \"Ganesh Kumar\" was deleted. Undo";
		Assert.assertEquals(actTitle, expTitle);
		boolean displayed =driver.findElement(By.xpath("//input[@placeholder='Last Name']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
	}
	//Individual "GaneshGanesh Kumar" was deleted. Undo

}
