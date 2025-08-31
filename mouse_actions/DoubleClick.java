package mouse_actions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DoubleClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Actions act= new Actions(driver);
		
		WebElement dblBtn= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		act.doubleClick(dblBtn).perform();
		
		//get field 2 text
		String textOfField= driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");
		System.out.println(textOfField);

	}

}
