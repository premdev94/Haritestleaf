package testleaf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.BaseClass;


public class ExcelDataReadandWrite extends BaseClass {

	//WebDriver driver;
    WebDriverWait wait;
    
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    
	@Test
	public void ExcelCheckStatusAfterSaveForm() throws InterruptedException, IOException
	{
		File src=new File("C:\\Users\\premkumar_u\\Downloads\\ReadWriteExcel\\Search.xlsx");   
		
		FileInputStream fis = new FileInputStream(src);
		
		 workbook = new XSSFWorkbook(fis);
		 
		 sheet= workbook.getSheetAt(0);
		 for(int i=1; i<=sheet.getLastRowNum(); i++)
		 {
		driver.get("https://maargasystems007.sharepoint.com/sites/DigiGasProduction/SitePages/Neue_anfrage.aspx#/");
	    cell = sheet.getRow(i).getCell(0);
	    driver.findElement(By.name("CustomerNumber")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(1);
		driver.findElement(By.name("CustomerName")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(2);
		driver.findElement(By.name("CustomerMailAddress")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(3);
		driver.findElement(By.name("CustomerAddress")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(4);
		driver.findElement(By.name("ContactPersonName")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(5);
		driver.findElement(By.name("Landline")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(6);
		driver.findElement(By.name("MobileNumber")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(7);
		driver.findElement(By.name("Fax")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(8);
		driver.findElement(By.name("CustomerBusinessHours")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(9);
		driver.findElement(By.name("WebToolContactEmail")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(10);
		driver.findElement(By.name("WebToolContactSurName")).sendKeys(cell.getStringCellValue());
		cell = sheet.getRow(i).getCell(11);
		driver.findElement(By.name("WebToolContactFirstName")).sendKeys(cell.getStringCellValue());
		Thread.sleep(2000);
        
        WebElement gen = driver.findElement(By.xpath("//*[text()='Nein']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", gen);
        
        driver.findElement(By.xpath("//button[@name='submit']")).click();
        Thread.sleep(5000);
        WebElement gen1 = driver.findElement(By.xpath("(//*[text()='Speichern'])[2]"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", gen1);
        driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).isDisplayed();
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).getText(), "Anfrage Kunde ohne Gasebezug123");
		System.out.println(driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).getText());
		 
		
		String searchText =  driver.findElement(By.xpath("//*[text()='Anfrage Kunde ohne Gasebezug']")).getText();
        

        if(searchText.equalsIgnoreCase("Anfrage Kunde ohne Gasebezug123")){
       	 String message = "Pass";
       	 sheet.getRow(i).createCell(12).setCellValue(message);
        } else {
       	 String message = "Fail";
       	 sheet.getRow(i).createCell(12).setCellValue(message);
        }
       // driver.findElement(By.xpath("//*[text()='Speichern']")).click();
		//String message = "Data Import";
         
         // Create cell where data needs to be written.
         //sheet.getRow(i).createCell(12).setCellValue(message);
           
         // Specify the file in which data needs to be written.
         FileOutputStream fileOutput = new FileOutputStream(src);
       
         // finally write content
         workbook.write(fileOutput);
          
          // close the file
         fileOutput.close();
			 }
			 }

}
