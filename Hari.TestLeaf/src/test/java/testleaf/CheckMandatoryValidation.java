package testleaf;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import utils.BaseClass;

public class CheckMandatoryValidation extends BaseClass{
	//public WebDriver driver;
	
	@Test
	public void clicksavebuttonwithoutenteringdata() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='buttonClass'])[1]")).click();
		//Assert.assertTrue(false);
	}
	}
	
	
	


