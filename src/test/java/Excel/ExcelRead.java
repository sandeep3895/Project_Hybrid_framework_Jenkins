package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\ExcelFiles\\"+"InputData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row=sheet.getLastRowNum();
		int cell=sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<=row;r++) {
			XSSFRow row1=sheet.getRow(r);
			for(int c=0;c<cell;c++) {
				XSSFCell cell1=row1.getCell(c);
				System.out.print(cell1+" ");
			}
			System.out.println();
		}
		workbook.close();
		fi.close();
	}
}
