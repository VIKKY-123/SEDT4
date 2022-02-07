package com.Vtiger.TC;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_Test {
	
	public String orgname="ABC_PARK123";

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

	public void Org_Details() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);


		WebElement inst = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		WebElement rati = driver.findElement(By.xpath("//select[@name=\"rating\"]"));


		WebElement type = driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));

		Select sel_inst=new Select(inst);
		sel_inst.selectByVisibleText("Hospitality");

		Select sel_rati = new Select(rati);
		sel_rati.selectByIndex(2);

		Select sel_type=new Select(type);

		sel_type.selectByVisibleText("Customer");


		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	}


	public void verify_Org() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class=\"txtBox\"]")).sendKeys(orgname);

		Select sel=new Select(driver.findElement(By.xpath("//select[@name=\"search_field\"]")));

		sel.selectByVisibleText("Organization Name");

		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[test()='VIKKY']")
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(value);

		if(value.equalsIgnoreCase(orgname))
		{
			System.out.println("testcase is pass");
		}
		else {
			System.out.println("Testcase is fail");
		}






	}


	public void sign_Up() {
		WebElement sp = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions mv=new Actions(driver);
		mv.moveToElement(sp).build().perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();



	}

	public void close_Browser() {
		driver.close();
	}



}
