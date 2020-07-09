package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dev.Execution.Core;
import com.dev.users.UserProfiles;

public class TestLogin extends Core{

	WebDriverWait wait;
	//UserProfiles profile = new UserProfiles();
	@FindBy(xpath = "//*[contains(text(),'Account & Lists')]")
	WebElement login;
	@FindBy(id = "ap_email")
	WebElement userName;
	@FindBy(id ="continue")
	WebElement continueBtn;
	@FindBy(id="ap_password")
	WebElement password;
	@FindBy(id ="signInSubmit")
	WebElement LoginBtn;
	
	
	@Test (priority=1)
	public void LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Account & Lists')]")));
		login.click();
		System.out.println("Log in to Amazon Account");
		Thread.sleep(3000);	
		
		
		for(int i=1; i<4; i++) {		
			if(driver.getTitle().equals("Amazon Sign In")) {
				System.out.println("Landed in Login Page");
				break;
			}
			else {
				login.click();
				if(driver.getTitle().equals("Amazon Sign In")) {
					System.out.println("Landed in Login Page");
					break;
				}
			}
		}		
	}
	
	@Test(priority=2)
	public void AccountLogin() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(userName));	
		
		userName.sendKeys(profile.getUsername());
		continueBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(profile.getPassword());
		LoginBtn.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Hello, Pradeepta')]")));
			driver.findElement(By.xpath("//*[contains(text(),'Hello, Pradeepta')]"));			
			System.out.println("Login Successful");
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println("Looks differnet");
		}
		
		
	}
	
}
