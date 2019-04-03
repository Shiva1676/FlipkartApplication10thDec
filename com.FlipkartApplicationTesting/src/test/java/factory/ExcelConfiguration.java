/**
 * 
 */
package factory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lenovo
 *
 */
public class ExcelConfiguration {

	XSSFWorkbook wb;

	public ExcelConfiguration() {

		String path = System.getProperty("user.dir") + "/TestData/Data.xlsx";

		try {
			File src = new File(path);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("========Unable to load excel==========");

			System.out.println(e.getMessage());
		}

	}

	public int getRow(String sheetname) {

		int rows = wb.getSheet(sheetname).getPhysicalNumberOfRows();

		return rows;

	}

	public int getColumn(String sheetname) {

		int rows = wb.getSheet(sheetname).getRow(0).getLastCellNum();

		return rows;

	}

	public String getExcelData(String sheetname, int row, int column){
		
		String data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	
}
