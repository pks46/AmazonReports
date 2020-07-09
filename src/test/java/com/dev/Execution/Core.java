package com.dev.Execution;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.dev.users.UserProfiles;

public class Core {
	
	public WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	
	UserProfiles profile = new UserProfiles();
	
	@BeforeSuite
	public void BeforeStart() {
		try {
			File details = new File(System.getProperty("user.dir")+"/src/main/Resources/userdetails.properties");
			FileInputStream file = new FileInputStream(details);
			prop = new Properties();
			prop.load(file);
			file.close();
			profile.setUsername("USER_ID");
			profile.setPassword("PASSWORD");
			
		}catch(Exception e) {
			System.out.println("File doesn't exists!");
		}
		
		
		//Opening Chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();	
		System.out.println(driver.getTitle());
		
	}
	
	@AfterSuite
	public void AtLast() {
		System.out.println("Closing all the drivers");
		driver.close();
		driver.quit();
	}
	
	

}
