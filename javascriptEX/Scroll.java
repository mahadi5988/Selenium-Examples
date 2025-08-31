package javascriptEX;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement ele= driver.findElement(By.xpath("//h2[normalize-space()='Form']"));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//scroll till element is visible
		
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(3000);
		
		
		//scroll till end of page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll at the beginning of page
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		js.executeScript("document.body.style.zoom='50%'");
		
		
	}

}
