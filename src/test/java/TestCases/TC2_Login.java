package TestCases;

import org.testng.annotations.Test;

import Base.BaseClass2;
import PageObjects.LoginPage2;

public class TC2_Login extends BaseClass2{
    @Test
	public void login() {
		log.info("***********Login Function**************");
		LoginPage2 lp=new LoginPage2(driver);
		lp.Enter_UserName(rb.getString("username"));
		log.info("Entering the username done");

		lp.Enter_Password(rb.getString("password"));
		log.info("Entering password done");
		lp.click();
		
		log.info("Submitted the username and password by clicking.");
	}
}
