package pageObjPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;


public class LoginPageObj {
	
	AndroidDriver driver;
	public LoginPageObj(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.Button[@content-desc='Login']/android.widget.TextView[1]")
	WebElement login;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"input-email\"]")
	WebElement email;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"input-password\"]")
	WebElement pwd;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]")
	WebElement butlgn;
	
	@FindBy(id="android:id/button1")
	WebElement ok;
	
	public void login() throws InterruptedException {
		Thread.sleep(10000);
		try {
			if(!login.isDisplayed()) {
				login();
			}
		}
		catch(Exception e) {
			System.out.println("Need more time to login or Element not found");
		}
		finally {
			if(login.isDisplayed()) {
				login.click();
				Thread.sleep(5000);
				email.click();
				email.clear();
				email.sendKeys("mmanian@yopmail.com");
				pwd.click();
				pwd.clear();
				pwd.sendKeys("admin@123");
				butlgn.click();
				Thread.sleep(5000);
				ok.click();
			}
		}
		
	}
	
}
