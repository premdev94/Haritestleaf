package testleaf;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;

public class CheckStatusBeforeSaveForm extends BaseClass {
	//public WebDriver driver;
	
	@Test
	public void checkstatusbeforesaveform() throws InterruptedException
	{
		Actions a=new Actions(driver);
		WebElement move=driver.findElement(By.xpath("//*[text()='Neue Anfrage']"));
		a.moveToElement(driver.findElement(By.xpath("//*[text()='Neue Anfrage']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Neue Anfrage']")).getText(), "Neue Anfrage");
		System.out.println(driver.findElement(By.xpath("//*[text()='Neue Anfrage']")).getText());
				
	}
}
