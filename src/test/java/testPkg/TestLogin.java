package testPkg;

import org.testng.annotations.Test;

import mainPkg.MainClass;
import pageObjPkg.LoginPageObj;
import pageObjPkg.WebViewPageObj;

public class TestLogin extends MainClass{
	
	@Test
	public void loginApp() throws InterruptedException {
		
		LoginPageObj obj1 = new LoginPageObj(driver);
		obj1.login();
	}
	
	@Test
	public void webViewApp() throws InterruptedException {
		WebViewPageObj obj1 = new WebViewPageObj(driver);
		obj1.viewText();
	}
	
}
