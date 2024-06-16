package sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class S11_21_Edit_Individuals {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Handle notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver(options);

		//1. Login to https://login.salesforce.com
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

		//2. Click on the toggle menu button from the left corner
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		//3. Click View All and click Individuals from App Launcher
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		//- Add an implicit wait to ensure the web page elements are fully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);
		WebElement individuals= driver.findElement(By.xpath("//div[contains(@class,'slds-scrollable')]//p[text()='Individuals']"));
		Actions Dropdown = new Actions(driver);
		Dropdown.moveToElement(individuals).click().build().perform();

		//4. Click on the Individuals tab 

		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement individualslist = driver.findElement(By.xpath("//span[contains(text(),'Individuals')][1]"));
		Actions Dropdown3 = new Actions(driver);
		Dropdown3.moveToElement(individualslist).click().build().perform();

		//5. Search the Individuals 'Kumar'
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Kumar",Keys.ENTER);

		//6. Click on the Dropdown icon and Select Edit
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement Selbutton = driver.findElement(By.xpath("//table/tbody/tr[6]/td[6]"));
		Actions Dropdown_a = new Actions(driver);
		Dropdown_a.moveToElement(Selbutton).click().build().perform();

		//driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement SelEdit1=driver.findElement(By.xpath("//a[@title='Edit']"));
		Actions edit_a = new Actions(driver);
		edit_a.moveToElement(SelEdit1).click().build().perform();

		//7.Select Salutation as 'Mr'
		Thread.sleep(2000);
		WebElement buttonSalutation=driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]"));
		Actions Salutation = new Actions(driver);
		Salutation.moveToElement(buttonSalutation).click().build().perform();

		Thread.sleep(2000);
		WebElement Sel_Mr = driver.findElement(By.xpath("//a[@title='Mr.']"));
		Actions Mr = new Actions(driver);
		Mr.moveToElement(Sel_Mr).click().build().perform();

		//8.Enter the first name as 'Ganesh'.
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ganesh");

		//9. Click on Save and Verify the first name as 'Ganesh'Expected Result:The Individuals is Edited SuccessfullyStep 
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'slds-text-align_right')]//span[text()='Save']")).click();
		//verify the first name as 'Ganesh'Expected Result:The Individuals is Edited SuccessfullyStep 
		String message = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(message);

		String actTitle= message;
		String expTitle="Individual \"Ganesh Kumar\" was saved.";
		Assert.assertEquals(actTitle, expTitle);
		boolean displayed =driver.findElement(By.xpath("//input[@placeholder='First Name']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
	}


}
