package com.qa.appium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;




public class MobileBrowserTest extends BrowserBaseTest {
	

	
	@Test
	public void browserTest() {
		driver.get("https://www.google.ca/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.name("q")).sendKeys("mobile testing");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	
		
	}

}
