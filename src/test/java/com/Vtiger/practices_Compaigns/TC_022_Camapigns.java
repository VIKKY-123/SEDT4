package com.Vtiger.practices_Compaigns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_022_Camapigns {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Login Vtiger
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(3000);

		//Click on Campaigns
		WebElement we1 = driver.findElement(By.xpath("//a[text()='More']"));

		Actions ac = new Actions(driver);
		ac.moveToElement(we1).build().perform();

		driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();


		//Navigate to Advance  Search option

		driver.findElement(By.xpath("//a[text()='Go to Advanced Search']")).click();

		//In first dropdown select "Expected Close Date"

		Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"fcol0\"]")));

		sel.selectByVisibleText("Expected Close Date");

		//In Second dropdown select "equals"
		Select sel02=new Select(driver.findElement(By.xpath("//select[@name=\"fop0\"]")));

		sel02.selectByVisibleText("equals");


		//Navigate to Clander Image Icon And Enter Select Time and Date

		//driver.findElement(By.xpath("//img[@id=\"jscal_trigger_fval0\"]")).click();



		driver.findElement(By.xpath("//input[@id=\"fval0\"]")).sendKeys("17-05-2018");


		System.out.println("TC is pass");


		WebElement sp = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions mv=new Actions(driver);
		mv.moveToElement(sp).build().perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		Thread.sleep(10000);


		driver.close();

	}

}
