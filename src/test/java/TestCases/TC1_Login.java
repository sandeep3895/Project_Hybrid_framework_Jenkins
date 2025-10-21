package TestCases;

import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.LoginPage;
public class TC1_Login extends BaseClass{
	
	
	@Test
	public void login() {
    LoginPage lp=new LoginPage(driver);
//    lp.Enter_UserName();
//    lp.Enter_Password();
//    lp.click();
	}
    
}
