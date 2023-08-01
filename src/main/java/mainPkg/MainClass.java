package mainPkg;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class MainClass {
	
	public static AndroidDriver driver;
	
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:enableWebviewDetailsCollection", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
	    desiredCapabilities.setCapability("appium:shouldTerminateApp", true);
	    desiredCapabilities.setCapability("appium:dontStopAppOnReset", false);

	    URL remoteUrl = new URL("http://localhost:4723");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    
	    if(!driver.isAppInstalled("com.wdiodemoapp")) {
	    	driver.installApp("D:\\Testing\\appium\\Android-NativeDemoApp-0.4.0.apk");
	    }
	    
	    driver.activateApp("com.wdiodemoapp");
		
	}
	
	
	@AfterTest
	  public void tearDown() {
	    driver.terminateApp("com.wdiodemoapp");
	    driver.quit();
	  }
	
}
