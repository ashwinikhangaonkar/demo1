package basic_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Singletest1 
{
	WebDriver driver;
	
	@BeforeSuite
	public void openbroser()
	{
		System.out.println("open browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void url()
	{
		System.out.println("enter url");
		driver.get("https://www.mercurytravels.co.in/");
	}
	
	@BeforeClass
	public void maximize()
	{
		System.out.println("max browser");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("gt cookies");
	}
	
	
	@Test
	public void BusinessLogic_one() throws InterruptedException
	{
		Actions act= new Actions(driver);
		act.click(driver.findElement(By.xpath("(//li[@class=\"dropdown loggedout\"])[2]"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@data-target=\"#modalLogin\"])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("sign_user_email")).sendKeys("ashwinikhangaonkar30@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("sign_user_password")).sendKeys("ashwini");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(text(),'Log in')])[1]")).click();
		
		WebElement x=driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		boolean TTrue=x.isDisplayed();
		if(TTrue)
		{
			x.click();
			Thread.sleep(2000);
			driver.findElement(By.id("sign_user_email")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("sign_user_password")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("sign_user_email")).sendKeys("ashwinikhangaonkar30@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.id("sign_user_password")).sendKeys("Ovee220122");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(text(),'Log in')])[1]")).click();
			Thread.sleep(2000);
		}
		
	}
	
	@AfterMethod
	public void takescreenshot()
	{
		System.out.println("Take screenshot");
	}
	@AfterClass
	public void dltcookies()
	{
		System.out.println("dlt cookies");
	}
	
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("dbconnection");
	}
	
	@AfterSuite
	public void closebrowser()
	{
		System.out.println("CloseBrowser");
		//driver.close();
	}
	
	
}
