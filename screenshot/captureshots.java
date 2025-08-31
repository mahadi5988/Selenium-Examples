package screenshot;


import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class captureshots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		// ******full page screen shot
  	File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File targetfile= new File(System.getProperty("user.dir")+"\\screenshots\\picture.png");
		
		//********copy file
		sourcefile.renameTo(targetfile);
		
		
		
		//element or specific area screenshot
		WebElement Table= driver.findElement(By.xpath("//div[@id='HTML12']//div[@class='widget-content']"));
		File tableSS= Table.getScreenshotAs(OutputType.FILE);
		File targetF= new File(System.getProperty("user.dir")+"\\screenshots\\table.png");
		
		tableSS.renameTo(targetF);

	}

}
