package practies_TestNG_methods;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest_Using_Dataproveder {



	WebDriver driver;


	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("SW")).click();
		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();


	}


	@Test(dataProvider = "city")

	public void makeMyTripTest_Using_Dataproveder(String scr, String dest) throws InterruptedException { 

		System.out.println("Test start");

		Date date =new Date();
		String[] correctdate = date.toString().split(" ");

		String day =correctdate[0];
		String  mounth=correctdate[1];
		String todaydate =correctdate[2];
		String year =correctdate[5];

		String xpath=day+" "+mounth+" "+todaydate+" "+year;
		System.out.println(xpath);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	


		driver.findElement(By.xpath("//input[@id=\"fromCity\"]")).click();
		WebElement from=driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		from.sendKeys(scr);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[.='Vijayawada, India']")).click();

		System.out.println(scr);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[.='To']")).click();
		WebElement To = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));

		To.sendKeys(dest);

		System.out.println(dest);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[.='Visakhapatnam, India']")).click();



		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='"+xpath+"']")).click();		


	}




	@AfterMethod
	public void afterMethod() {

		driver.close();
	}

	@DataProvider
	public Object[][] city() {
		Object arr[] []=new Object[1] [2];

		arr[0] [0]="vijayawada";
		arr[0] [1]="visakhapatnam";



		//		arr[1] [0]="hyb";
		//		arr[1] [1]="vijayawada";

		//
		//		arr[2] [0]="hyb";
		//		arr[2] [1]="blr";
		//
		//
		//		arr[3] [0]="hyb";
		//		arr[3] [1]="pune";


		return arr;



	}


}
