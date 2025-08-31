package practisetestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver;
	  
  @Test(priority=1)
   void openApp() {
	  driver= new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }
  @Test(priority=2)
  void login() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	  
  }
  @Test(priority=3)
  void logout() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
  }
}

