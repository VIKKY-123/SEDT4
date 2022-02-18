package practies_read_data;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_svg_tag {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.noon.com/uae-en/");
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @class=\"sc-ljsmAU jFDlvU\"]")).click();
		
		driver.close();
		
		
		

	}

}
