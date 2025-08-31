package checkbox;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		List<WebElement> chkBoxes= driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
//		for(int i=0; i<chkBoxes.size(); i++) {
//			chkBoxes.get(i).click();
//			
//		}
		
		for (WebElement chkBox:chkBoxes) {
			chkBox.click();
		}
		 

	}



}
