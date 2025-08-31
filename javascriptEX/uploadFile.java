package javascriptEX;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		driver.manage().window().maximize();
		
		
		//single file
		//driver.findElement(By.xpath("//input[@name='userfile']")).sendKeys("C:\\Users\\User\\OneDrive\\Desktop\\Automation code.txt");
		
		//multiple file
		String file1="C:\\Users\\User\\OneDrive\\Desktop\\Automation code.txt";
		String file2="C:\\Users\\User\\OneDrive\\Desktop\\New Text Document.txt";
		
		driver.findElement(By.xpath("//input[@name='userfile']")).sendKeys(file1+"\n"+file2);
		
		
		
	}

}
