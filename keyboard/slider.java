package keyboard;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class slider {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		
		
		driver.switchTo().frame(0);
		Actions act= new Actions(driver);
		
		
		WebElement slider= driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		System.out.println("Current position" +slider.getLocation());
		
		act.dragAndDropBy(slider, 100, 4).perform();
		
		System.out.println("position after change" +slider.getLocation());
	}

}
