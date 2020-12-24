package testleaf;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.BaseClass;

public class CheckStatusAftersaveform extends BaseClass {

	
	@Test
	public void CheckStatusAfterSaveForm() throws InterruptedException
	{
        driver.findElement(By.xpath("//*[text()='Neue Anfrage']")).isDisplayed();
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Neue Anfrage']")).getText(), "Neue Anfrage");
		System.out.println(driver.findElement(By.xpath("//*[text()='Neue Anfrage']")).getText());
		driver.findElement(By.name("CustomerNumber")).sendKeys("001 Test");
		driver.findElement(By.name("CustomerName")).sendKeys("Test Name");
		driver.findElement(By.name("CustomerMailAddress")).sendKeys("test90@gmail.com");
		driver.findElement(By.name("CustomerAddress")).sendKeys("Content Address");
		driver.findElement(By.name("ContactPersonName")).sendKeys("Test Name");
		driver.findElement(By.name("Landline")).sendKeys("8908909090");
		driver.findElement(By.name("MobileNumber")).sendKeys("9908909090");
		driver.findElement(By.name("Fax")).sendKeys("04456890890");
		driver.findElement(By.name("CustomerBusinessHours")).sendKeys("Test Hours");
		driver.findElement(By.name("WebToolContactEmail")).sendKeys("test90@gmail.com");
		driver.findElement(By.name("WebToolContactSurName")).sendKeys("Test Name");
		driver.findElement(By.name("WebToolContactFirstName")).sendKeys("Name");
		Thread.sleep(2000);
		Assert.assertFalse(driver.findElement(By.xpath("//*[text()='Nein']")).isSelected());
		WebElement gen = driver.findElement(By.xpath("//*[text()='Nein']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", gen);
        System.out.println(driver.findElement(By.xpath("//*[text()='Nein']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Nein']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Nein']")).isDisplayed());
        driver.findElement(By.xpath("//button[@name='submit']")).click();
        Thread.sleep(10000);
        WebElement gen1 = driver.findElement(By.xpath("(//*[text()='Speichern'])[2]"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", gen1);
        driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).isDisplayed();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).getText(), "Anfrage Kunde ohne Gasebezug");
		System.out.println(driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).getText());
       // driver.findElement(By.xpath("//*[text()='Speichern']")).click();
        
	}

}
