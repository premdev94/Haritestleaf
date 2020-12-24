package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	
	public static WebDriver driver;
	//public static Loginpage_digigas lp;
	
	@BeforeTest
	public void priconditions() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://maargasystems007.sharepoint.com/sites/DigiGasProduction/SitePages/Neue_anfrage.aspx#/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("premkumar_u@maargasystems.com");
		
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Password@#0956");
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Yes']")).click();
		
		//driver.findElement(By.xpath("(//div[@class='buttonClass'])[1]")).click();
		
	}
	
   @AfterTest
	public void postconditions() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	

}

