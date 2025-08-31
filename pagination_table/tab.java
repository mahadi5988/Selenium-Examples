package pagination_table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class tab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		int totalPage= driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		
		
		for(int p=1; p<=totalPage; p++) {
		
		if(p>1) { 
                  WebElement activePage= driver.findElement(By.xpath("//ul[@id='pagination']//*[text()="+p+"]"));
                  activePage.click();
	}
		
		int numOfRows= driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		for(int r=1; r<=numOfRows; r++) {
			String productName= driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
			System.out.println(productName);
                                  }
		
		
		
		
              	}
	}
	

}
