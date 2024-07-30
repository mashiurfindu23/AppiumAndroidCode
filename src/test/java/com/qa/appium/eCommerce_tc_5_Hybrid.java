package com.qa.appium;


import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class eCommerce_tc_5_Hybrid extends BaseTest {

	@Test
	public void addToCart() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Munia Hossain");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text","Cart"));
			
			List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
			int productCount= productPrices.size();
			double totalSum=0;
			for(int i=0; i<productCount;i++) {
				String amountString=productPrices.get(i).getText();
				double price=Double.parseDouble(amountString.substring(1));
				totalSum= totalSum+price;
				
			}
		String displaySum= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double newDisplaySum=Double.parseDouble(displaySum.substring(1));
		Assert.assertEquals(totalSum, newDisplaySum);
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		
		Set<String> contexts=driver.getContextHandles();
		
		
		for(String contextName: contexts) {
			System.out.println(contextName);
			
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("naveenautomationlabs");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		
		}

	}

