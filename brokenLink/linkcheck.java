package brokenLink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linkcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		int noofBrokenLNK=0;
		
		driver.manage().window().maximize();
		
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
	
		
		for(WebElement link:links) {
			String website=link.getAttribute("href");
			
			if(website==null || website.isEmpty()) {
				
				System.out.println("The link doesnot exist");
				continue;
			}
			
			try {
				URL weblink= new URL(website);                                              //converting string into URL
				HttpURLConnection conn= (HttpURLConnection) weblink.openConnection();       //open connection to the server
				conn.connect();                                                             //connect to server and sent request to the server
				
				if(conn.getResponseCode() >= 400) 
				{
					System.out.println(weblink+ " The link is broken");
					noofBrokenLNK++;
				} else
				{
					System.out.println(weblink+ " The link is completely fine");
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			
	}
		System.out.println("No of broken Links: "+noofBrokenLNK);

}
	}


