package PageObjectModelPattern;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	//POM using PageFactory
	WebDriver driver;
	
	//Contructor
	LoginPage2 (WebDriver driver){
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txt_firstname_loc;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password_loc;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbtn_loc;
	

	
	//Action Methods
	public void setUsername(String username) {
		
		txt_firstname_loc.sendKeys(username);
	}
	
   public void setPassword(String pwd) {
		
		password_loc.sendKeys(pwd);
	}
   
   public void clickLogin() {
	   loginbtn_loc.click();
   }
   
   
}
