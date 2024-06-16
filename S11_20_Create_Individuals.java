package sprint_01;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
public class S11_20_Create_Individuals {
	public static void main(String[] args) throws InterruptedException {


		//Handle notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver(options);

		// 1.Load the url

		driver.get("https://login.salesforce.com");
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

		//2.Click on the toggle menu button from the left corner

		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();

		//3. Click View All and click Individuals from App Launcher
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();

		//Click on the Dropdown icon in the Individuals tab
		Thread.sleep(4000);
		WebElement individuals= driver.findElement(By.xpath("//div[contains(@class,'slds-scrollable')]//p[text()='Individuals']"));
		Actions Dropdown = new Actions(driver);
		Dropdown.moveToElement(individuals).click().build().perform();

		//4. Click on the Dropdown icon in the Individuals tab

		WebElement more = driver.findElement(By.xpath("//span[contains(text(),'More')]"));
		Actions Dropdown1 = new Actions(driver);
		Dropdown1.moveToElement(more).click().build().perform();

		//to select option of  individuals
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement individualslist = driver.findElement(By.xpath("//span[contains(text(),'Individuals')][1]"));
		Actions Dropdown3 = new Actions(driver);
		Dropdown3.moveToElement(more).click().build().perform();


		//5. Click on New Individual
		//locate the source dropdown and select New Individual

		WebElement newindividuals = driver.findElement(By.xpath("//div[contains(text(),'New')]"));
		Actions Dropdown5 = new Actions(driver);
		Dropdown5.moveToElement(newindividuals).click().build().perform();

		//6. Enter the Last Name as 'Kumar'


		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//div[contains(@class,'slds-text-align_right')]//span[text()='Save']")).click();
		//7.Click save and verify Individuals NameExpected result:The Individuals is created SuccessfullyStep 
		//System.out.println(driver.getTitle());
		String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(message);

		String actTitle= message;
		String expTitle="Individual \"Kumar\" was created.";
		Assert.assertEquals(actTitle, expTitle);
		boolean displayed =driver.findElement(By.xpath("//input[@placeholder='Last Name']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
	driver.quit();
	}
}


