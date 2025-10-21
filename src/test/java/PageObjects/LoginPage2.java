package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	
	public static WebDriver driver;
	public LoginPage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[@type=submi']")WebElement submit;
	
	public void Enter_UserName(String user) {
		username.sendKeys(user);
	}
	public void Enter_Password(String pswd) {
		password.sendKeys(pswd);
	}
	public void click() {
		submit.click();
	}
	
}
