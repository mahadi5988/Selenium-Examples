package DDTusingUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class mainTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String filePath= System.getProperty("user.dir")+"\\testdata\\data driven test.xlsx";
		int rowNum= ExcelUtils.getRowCount(filePath, "sheet1");
		
		for(int i=1; i<=rowNum; i++) {
			//read from ecxel
			String price= ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateofinterest= ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1= ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String per2= ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq= ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String Exp= ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//send data to application 
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select perdp= new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdp.selectByVisibleText(per2);
			
			Select frequency= new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			frequency.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			String act_mval= driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(Double.parseDouble(Exp)== Double.parseDouble(act_mval)) {
			
			System.out.println("Test Passed");
			ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
			ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			} else {
				
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
			Thread.sleep(3000);
			
		}
		
		driver.quit();
	}

}
