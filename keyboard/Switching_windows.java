package keyboard;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Switching_windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		

        WebElement home= driver.findElement(By.xpath("//div[@id='PageList2']//a[normalize-space()='Home']"));
		
		Actions act= new Actions(driver);
		
		act.keyDown(Keys.CONTROL).click(home).keyUp(Keys.CONTROL).perform();
		
		List<String> ids= new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1));
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Mehedi");}}