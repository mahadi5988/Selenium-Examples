package sslAndADblock;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class adblk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		File ext= new File("C:\\Users\\User\\OneDrive\\Desktop\\SelectorsHub-Chrome-Web-Store.crx");
		options.addExtensions(ext);
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
	}

}
