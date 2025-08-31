package alerting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shwAlrt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        //driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(5000);
     // driver.switchTo().alert().accept();
        
       Alert mylert= driver.switchTo().alert();
       
       mylert.sendKeys("hello");
       
       mylert.accept();
      // myAlert.dismiss();
        
       // driver.switchTo().alert().accept();
    // driver.switchTo().alert().getText();
    // driver.switchTo().alert().sendKeys();
	}

}
