package testNGdataP;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {

	WebDriver driver;
	@BeforeClass
	void setup(){
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	@Test(dataProvider="dp")
	void testing(String name, String pwd) throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	    Boolean logo=driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).isDisplayed();
	    
	    if(logo==true) {
	    	Thread.sleep(5000);
	  	  driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	  	  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	  	  Assert.assertTrue(true);
	    } else {
	    	
	    	Assert.fail();
	    }
	    
	    
	}
	@AfterClass
	void teardown() {
		driver.close();
	}
	//if i put indices it will take only 0 and 2 number data if i dont write indices then all will run
	@DataProvider(name="dp", indices= {0,2})
	Object[][] data() {
		Object dt[][]= {
				{"mehedi","123"},
				{"Admin","admin123"},
				{"Ad","ad123"},
				{"Badman","Bad"},
				{"man","man123"}
		};		
		
		
		return dt;
	}
}
