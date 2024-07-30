package com.qa.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	public  AndroidDriver driver;

	@BeforeClass
	public void confiqureAppium() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NoDemo");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
		options.setChromedriverExecutable("C:\\Users\\Mashiur\\Documents\\Drivers\\chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void longPressAction(WebElement ele) {
		
		
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of(
			"elementId",((RemoteWebElement) ele).getId()),"duration", 2000);
	
		
	}
	
	public void swipeAction(WebElement ele, String direcction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direcction,
			    "percent", 0.75
			));
		
		
	}

	@AfterClass
	public void tearDown() {

		// driver.quit();

	}

}
