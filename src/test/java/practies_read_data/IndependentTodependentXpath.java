package practies_read_data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndependentTodependentXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("POCO mobiles");
		driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
		
		driver.findElement(By.xpath("//div[text()='POCO F1 (Rosso Red, 64 GB)']/ancestor::a[@class=\"_1fQZEK\"]//span[text()='Add to Compare']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='POCO F1 (Graphite Black, 256 GB)']/ancestor::a[@class=\"_1fQZEK\"]//span[text()='Add to Compare']")).click();

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
		
	}

}
