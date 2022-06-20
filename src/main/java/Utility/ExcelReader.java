package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	static FileInputStream file;
	static Workbook book;
	
	public static Object[][] readExcelData(String sheetName){
		
		try {
			file = new FileInputStream("./Excel Sheets/Login Credentials.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int x=0; x<sheet.getLastRowNum(); x++) {
			for(int y=0; y<sheet.getRow(0).getLastCellNum(); y++) {
				data[x][y] = sheet.getRow(x+1).getCell(y).toString();
			}
		}
		return data;
	}
}
