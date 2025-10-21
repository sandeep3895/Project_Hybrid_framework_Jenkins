package Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\Excelfiles\\"+"write.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sandeep");
        /*
         * XSSFRow row0=sheet.createRow(0); 
         * XSSFCell cell0=row0.createCell(0);
           cell0.setCellValue("S.no");
           XSSFCell cell1 =row0.createCell(1);
		   cell1.setCellValue("Name");
           XSSFRow row1= sheet.createRow(1);
		   XSSFCell r1c0=row1.createCell(0);
		   r1c0.setCellValue("1");

         * XSSFCell r1c1=  row1.createCell(1);
          r1c1.setCellValue("SANDEEP");
         */
        Scanner sc=new Scanner(System.in);
        for(int r=0;r<=1;r++) {
        	XSSFRow row=sheet.createRow(r);
        	for(int c=0;c<=4;c++) {
        		System.out.println("Enter the data");
        		String input=sc.next();
        		XSSFCell cell=row.createCell(c);
        		cell.setCellValue(input);
        	}
        }
        workbook.write(fo);
        workbook.close();
        fo.close();
	}

}
