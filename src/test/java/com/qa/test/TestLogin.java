package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.dev.Execution.Core;

public class TestLogin extends Core{

	WebDriverWait wait;
	
	@Test (priority=1)
	public void LoginTest() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Account & Lists')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Account & Lists')]")).click();
		System.out.println("Clicked Successfully");
	}
	
}
