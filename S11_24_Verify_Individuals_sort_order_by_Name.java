package sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class S11_24_Verify_Individuals_sort_order_by_Name {

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
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);
		WebElement individuals= driver.findElement(By.xpath("//div[contains(@class,'slds-scrollable')]//p[text()='Individuals']"));
		Actions Dropdown = new Actions(driver);
		Dropdown.moveToElement(individuals).click().build().perform();
		//4. Click on the Individuals tab

		WebElement more = driver.findElement(By.xpath("//span[contains(text(),'More')]"));
		Actions Dropdown1 = new Actions(driver);
		Dropdown1.moveToElement(more).click().build().perform();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement individualslist = driver.findElement(By.xpath("//span[contains(text(),'Individuals')][1]"));
		Actions Dropdown3 = new Actions(driver);
		Dropdown3.moveToElement(more).click().build().perform();
		//5. Click the sort arrow in the Name
		//span[text()='Name']/parent::a
		Thread.sleep(2000);
		WebElement newindividual = driver.findElement(By.xpath("//span[contains(text(),'Sort')]/parent::a[1]"));
		Actions Dropdown_a = new Actions(driver);
		Dropdown_a.moveToElement(newindividual).click().build().perform();

		//6. Verify the Individuals displayed in ascending order by Name.

		String Sortedorder=	driver.findElement(By.xpath("//span[contains(text(),'Sorted Ascending')]")).getText();
		System.out.println(Sortedorder);
		//Expected Result:Individual Should be displayed in ascending order by Name.Step 
		String actTitle= Sortedorder;
		String expTitle="Sorted Ascending";
		Assert.assertEquals(actTitle, expTitle);
		boolean displayed =driver.findElement(By.xpath("//span[contains(text(),'Sorted Ascending')]")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
	}


}
