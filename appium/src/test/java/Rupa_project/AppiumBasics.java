package Rupa_project;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics {
	AppiumDriver driver;
	
	@Test
	public void AppiumTest() throws MalformedURLException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Rupaemulator");
		options.setApp("C://Users//msi//eclipse-workspace//appium//src//test//java//resources//ApiDemos-debug.apk");
		
		 driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), options);
		
	}

}
