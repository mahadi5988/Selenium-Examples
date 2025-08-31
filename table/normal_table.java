package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public abstract class normal_table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//WebElement table= driver.findElement(By.xpath("//table[@name='BookTable']"));
		//System.out.println(table);
		
		int rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int cols= driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		
		for(int r=2; r<=rows; r++) {
			
			for(int c=1; c<=cols; c++) {
				
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+ " \t");
				
			}
			System.out.println();
		}
		
		

	}

}
