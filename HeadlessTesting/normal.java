package HeadlessTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class normal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
		System.out.println("Hello Its running");

	}

}
