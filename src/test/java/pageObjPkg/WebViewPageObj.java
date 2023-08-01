package pageObjPkg;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;



public class WebViewPageObj {
	AndroidDriver driver;
	public WebViewPageObj(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.Button[@content-desc='Webview']/android.widget.TextView")
	WebElement webview;
	@FindBy(xpath = "//*[contains(@text, 'Native Mobile Support')]")
	WebElement nativetxt;
	
	public void viewText() throws InterruptedException {
		try {
			Thread.sleep(10000);
			
		}catch(Exception e){
			System.out.println("Element not found");
		}finally {
			webview.click();
			Thread.sleep(10000);
			Map<String, Object> args = new HashMap<>();
			args.put("direction", "down");
			args.put("percent", 10.0);
			args.put("left", 100);
			args.put("top", 500);
			args.put("width", 100);
			args.put("height", 1000);
//			args.put("element", nativetxt.getAccessibleName());
			driver.executeScript("mobile: scrollGesture", args);
			driver.executeScript("mobile: scrollGesture", args);
			driver.executeScript("mobile: scrollGesture", args);
			driver.executeScript("mobile: scrollGesture", args);
			driver.executeScript("mobile: scrollGesture", args);
//			Boolean n = true;
//			while(n) {
//				driver.executeScript("mobile: scrollGesture", args);
//				Thread.sleep(3000);
//				if(nativetxt.isDisplayed()) {
//					n = false;
//				}
//			}
			nativetxt.isDisplayed();
			Thread.sleep(10000);
		}
	}
}
