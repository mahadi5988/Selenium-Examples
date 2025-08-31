package datadrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\book_purchases.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
		int numofRows= sheet.getLastRowNum();
		int numofCells= sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows:"+numofRows+ "Number of cells:" +numofCells);
		
		for(int r=0; r<=numofRows; r++) {
				XSSFRow currentRow= sheet.getRow(r);
			for(int c=0; c<numofCells; c++) {
				
				XSSFCell cell= currentRow.getCell(c);
				System.out.print(cell.toString() +"\t"); 
				
				}
			System.out.println();
		}
	
				workbook.close();
	
	
	}

}
