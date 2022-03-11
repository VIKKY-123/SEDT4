package com.openbrowser.vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicMethod {
	
	public WebDriver driver;
	
	public void openThebrowser() {
WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
	}
	
	public void enterUrl() {
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	}
	
	
	public void login_D() {
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	}
	
	public void wait_se() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void close() {
		driver.close();
	}

}
