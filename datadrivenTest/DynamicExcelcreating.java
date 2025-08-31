package datadrivenTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicExcelcreating {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file= new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\dd\\testdata\\Dynamicdata.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("sheet1");
		Scanner sc= new Scanner(System.in);
		
		System.out.println("How many rows: ");
		int numberofRows= sc.nextInt();
		
		System.out.println("Number of cells: ");
		int numberofCells= sc.nextInt();
		
		for(int r=0; r<=numberofRows; r++) {
			
			XSSFRow currentRow= sheet.createRow(r);
			
			for(int c=0; c<numberofCells; c++) {
				XSSFCell cell= currentRow.createCell(c);
				cell.setCellValue(sc.next());
			}
			
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is Created Successfully.....");
		
		
	}
}
	

 
