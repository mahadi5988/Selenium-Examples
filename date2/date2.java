package date2;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class date2 {
	
	static Month convertMonth(String month) {
		
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth= monthMap.get(month);
		
		if (vmonth == null) {
			System.out.println("Invalid Month....");
		}
		return vmonth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String requiredYear= "2022";
		String requiredMonth= "May";
		String requiredDate= "12";
		
		
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		//select year
		WebElement yearDropDown= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear= new Select(yearDropDown);
		selectYear.selectByVisibleText(requiredYear);
		
		//select month
		while(true) {
			
			String displayMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			//convert requiredMonth & displayMonth into Month obj
			Month expectedMonth=convertMonth(requiredMonth);
			Month currentMonth=convertMonth(displayMonth);
			int result=expectedMonth.compareTo(currentMonth); //0=  months equal, 0>  past, 0<  future
			if(result<0)
			{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();	
			}
			else if(result>0) {
				driver.findElement(By.xpath("//span[@class='ui-icon-Circle-triangle-e']")).click();
			}
			else {
				break;
			}
	}
		
		//date
		List<WebElement> allDates= driver.findElements(By.xpath("//table@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(requiredDate))
			{
				dt.click();
				break;
			}
		}
		
		

	}

}
