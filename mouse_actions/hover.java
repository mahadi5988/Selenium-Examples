package mouse_actions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class hover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement button= driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		WebElement mobileBtn= driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		
		Actions act= new Actions(driver);
		
		//hover
		act.moveToElement(button).moveToElement(mobileBtn).click().perform();
		
		//right click
		//act.contextClick(button).perform();
		
		
		

	}

}
