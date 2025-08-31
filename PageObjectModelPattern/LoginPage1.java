package PageObjectModelPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {
	
	//POM without using PageFactory
	
	WebDriver driver;
	
	//Contructor
	LoginPage1 (WebDriver driver){
		this.driver=driver;		
	}
	
	//locators
	By txt_firstname_loc= By.xpath("//input[@placeholder='Username']");
	By password_loc= By.xpath("//input[@placeholder='Password']");
	By loginbtn_loc= By.xpath("//button[normalize-space()='Login']");
	
	//Action Methods
	public void setUsername(String username) {
		
		driver.findElement(txt_firstname_loc).sendKeys(username);
	}
	
   public void setPassword(String pwd) {
		
		driver.findElement(password_loc).sendKeys(pwd);
	}
   
   public void clickLogin() {
	   driver.findElement(loginbtn_loc).click();
   }
   
   
}
