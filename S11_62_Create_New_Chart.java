package sprint_01;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class S11_62_Create_New_Chart {

	public static void main(String[] args) throws InterruptedException {
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
		//			4. Click on the drop down and select Refunds
		driver.findElement(By.xpath("//mark[text()='Refunds']")).click();
		//			5.Click on drop down near Recently viewed and change into 'All'.
		driver.findElement(By.xpath("//button[@role='button' and @title='Select a List View: Refunds']")).click();
		driver.findElement(By.xpath("//span[text()='All Refunds']")).click();
		//			6. Click on Chart icon under New Button

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement showchart=driver.findElement((By.xpath("//button[@title='Show charts']")));
		wait.until(ExpectedConditions.visibilityOf(showchart));
		Actions charts = new Actions(driver);
		charts.moveToElement(showchart).click().perform();
		Thread.sleep(2000);
		WebElement newchart=driver.findElement((By.xpath("//span[text()='New Chart']")));
		wait.until(ExpectedConditions.visibilityOf(newchart));
		Actions chart = new Actions(driver);
		chart.moveToElement(newchart).click().perform();


		//			8. Give Chart Name and Select Chart Type
		driver.findElement((By.xpath("//input[@class='slds-input' and@type='text']"))).sendKeys("Aishwarya");
		driver.findElement((By.xpath("(//button[@role='combobox'])[1]"))).click();
		driver.findElement((By.xpath("//span[text()='Horizontal Bar Chart']"))).click();
		//			9. Select Aggregate Type as Average and ggregate Field as Amount
		WebElement  Sel_Average = driver.findElement((By.xpath("(//button[@role='combobox'])[2]")));
		Actions Avg = new Actions(driver);
		Avg.moveToElement(Sel_Average).click().perform();
		driver.findElement((By.xpath("(//span[text()='Average'])[1]"))).click();
		driver.findElement((By.xpath("(//button[@role='combobox'])[3]"))).click();
		WebElement  Sel_Amount =driver.findElement((By.xpath("(//span[text()='Amount'])")));
		Actions Amount = new Actions(driver);
		Avg.moveToElement(Sel_Amount).click().perform();
		
		WebElement  Sel_scroll =	driver.findElement((By.xpath("//div[contains(@class,'modal-body scrollable')]//button[@name='groupByPicklist']")));
				Actions scroll = new Actions(driver);
				scroll.moveToElement(Sel_scroll).click().perform();
		//driver.findElement((By.xpath("(//button[@role='combobox'])[4]"))).click();
		//		//			10. Select Grouping Field as Account and click Save11. Click on settings icon and change the Chart TypeExpected
WebElement  Sel_Account=driver.findElement((By.xpath("(//span[text()='Account'])[3]")));
	Actions Account = new Actions(driver);
	Avg.moveToElement(Sel_Account).click().build().perform();
driver.findElement(By.xpath("(//button[@title='Save'])[1]")).click();
driver.findElement(By.xpath("//div[@class='chartSettings uiMenu']")).click();
		driver.findElement(By.xpath("//a[@title='Donut Chart']")).click();
		driver.findElement(By.xpath("//div[@class='chartSettings uiMenu']")).click();
		
		driver.findElement(By.xpath("//a[@title='Delete Chart']")).click();
		
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		//		//			Result:The Chart type should be changedStep
		//	}
		//
		//
		//
	}
}