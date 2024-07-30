package com.qa.appium;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;




public class AppiumBasics extends BaseTest {

	@Test
	public void wifySettingsName() throws MalformedURLException {
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("NoDemo");
//		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//
//		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		// xpath, id, accessabilityID, classname, androidUiautomator

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertText = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alertText);
		Assert.assertEquals(alertText, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Mashiur wifi");
		driver.findElement(By.id("android:id/button1")).click();

	}
}
