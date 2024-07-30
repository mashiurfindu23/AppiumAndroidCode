package com.qa.appium;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;


public class MiscellaneousAppiumAction extends BaseTest {
	
	@Test
	public void wifySettingsName() throws MalformedURLException {
	
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape= new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
	
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertText=driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alertText);
		
		
		//copy paste
		//copy to clipboard, paste to clipboard
		
		driver.setClipboardText("Mashiur wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("android:id/button1")).click();
		
		// prees key for back button foword button
		
		
		
	}


}
