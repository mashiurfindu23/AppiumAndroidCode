package com.qa.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDropDemo extends BaseTest {

	@Test
	public void dragDropTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement srcFile=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) srcFile).getId(),
			    "endX", 629,
			    "endY", 580
			));	
		
		String actualText=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(actualText);
		
		Assert.assertEquals(actualText, "Dropped!");
		
		Thread.sleep(3000);
		
	}
	
	

	
}
