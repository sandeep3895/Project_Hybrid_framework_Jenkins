package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Base.BaseClass;
import PageObjects.LoginPage;
import Utilities.ExcelUtilities;

public class TC3_Login extends BaseClass{

	@Test
	public void login() throws IOException, InterruptedException {
		LoginPage lp=new LoginPage(driver);
		String xlfile=System.getProperty("user.dir")+"\\ExcelFiles\\"+"Login_Details.xlsx";
		//System.out.println(xlfile);
		int xlrows=ExcelUtilities.getRowCount(xlfile,"Sandeep");
		System.out.println(xlrows);
		
		for(int r=0;r<=xlrows;r++) {
			String user=ExcelUtilities.getCellData(xlfile,"Sandeep", r, 0);
			System.out.println(user);
			String psw=ExcelUtilities.getCellData(xlfile, "Sandeep", r, 1);
			//Thread.sleep(3000);
			lp.Enter_UserName(user);
			//Thread.sleep(3000);
			lp.Enter_Password(psw);
			//Thread.sleep(3000);
			lp.click();
			Thread.sleep(5000);
			
			String actual=driver.getTitle();
			String expected="OrangeHRM";
			System.out.println(actual);
			if(actual.equals(expected)) {
				ExcelUtilities.setCellData(xlfile,"Sandeep",r,2,"Pass");
				ExcelUtilities.FillGreenColour(xlfile, "Sandeep", r, 2);
			}
			else {
				ExcelUtilities.setCellData(xlfile, "Sandeep", r, 2, "Fail");
				ExcelUtilities.FillRedColour(xlfile, "Sandeep", r, 2);
			}
			break;
		}
		
		
	}
}
