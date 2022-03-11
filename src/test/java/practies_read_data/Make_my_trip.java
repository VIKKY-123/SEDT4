package practies_read_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Make_my_trip {

	public static void main(String[] args) {
		System.out.println("Test start");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("SW")).click();
		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();


		driver.findElement(By.xpath("//input[@id=\"fromCity\"]")).click();
		WebElement from=driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		from.sendKeys("vijayawada");
		driver.findElement(By.xpath("//div[.='VGA']")).click();
		
		
		driver.findElement(By.xpath("//span[.='To']")).click();
		WebElement To = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));

		

		//System.out.println(scr);

		

		To.sendKeys("visakhapatnam");

		//System.out.println(dest);
		driver.findElement(By.xpath("//div[.='VTZ']")).click();



	}

}
