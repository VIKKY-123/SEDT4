package practies_read_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Non_SelectTag_DD_handling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.icc-cricket.com/");

		driver.findElement(By.xpath("//div[normalize-space()='Fixtures']")).click();

		String addDD = driver.findElement(By.xpath("//a[@href=\"/womens-schedule/list\"]")).getText();

		if(addDD.equalsIgnoreCase("Women's Fixtures")) {

			System.out.println("TC pass");
		}

		else{
			System.out.println("TC is faild");

		}









	}

}
