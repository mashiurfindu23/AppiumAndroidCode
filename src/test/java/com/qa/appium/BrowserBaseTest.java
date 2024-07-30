package com.qa.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserBaseTest {
	
	public  AndroidDriver driver;

	@BeforeClass
	public void confiqureAppium() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NoDemo");
		options.setChromedriverExecutable("C:\\Users\\Mashiur\\Documents\\ChromeDriver.exe");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@AfterClass
	public void tearDown() {

		 driver.quit();

	}

}
