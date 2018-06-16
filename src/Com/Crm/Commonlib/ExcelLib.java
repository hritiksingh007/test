package Com.Crm.Commonlib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	public String getExcelData(String sheetName,int rowNum,int colNum) throws Throwable
	{
		FileInputStream fls=new FileInputStream("C:\\Users\\shine solutions\\workspace\\Crm_SeleniumFramework\\testData\\TestData.xlsx");
		//		OR
		//FileInputStream fls=new FileInputStream("./testData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fls);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(colNum);	
		return cel.getStringCellValue();	
	}

}