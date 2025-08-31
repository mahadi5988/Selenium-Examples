package mouse_actions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class dragANDdrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Actions act= new Actions(driver);
		
		WebElement drag= driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop= driver.findElement(By.xpath("//div[@id='droppable']"));
		Thread.sleep(5000);
		
		//act.dragAndDrop(drag, drop).perform();
		
		//Another mehod
		Action myaction= act.dragAndDrop(drag, drop).build();
		myaction.perform();
	}

}
