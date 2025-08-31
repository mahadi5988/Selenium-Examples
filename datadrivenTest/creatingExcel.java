package datadrivenTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class creatingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file= new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\dd\\testdata\\createdfile.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("sheet1");
		
		XSSFRow row1= sheet.createRow(0);
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue("OOP");
		row1.createCell(2).setCellValue("6 Months");
		
		XSSFRow row2= sheet.createRow(1);
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue("OOP");
		row2.createCell(2).setCellValue("2 Months");
		
		XSSFRow row3= sheet.createRow(2);
		row3.createCell(0).setCellValue("C#");
		row3.createCell(1).setCellValue("OOP");
		row3.createCell(2).setCellValue("4 Months");
		
		
		workbook.write(file);
		workbook.close();
		
		file.close();
		
		System.out.println("File is Created Successfully.....");
	}

}
