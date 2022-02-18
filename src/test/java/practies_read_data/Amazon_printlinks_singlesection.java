package practies_read_data;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_printlinks_singlesection {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("amazon.in");
		List<WebElement> options = driver.findElements(By.xpath("//div[text()=\"Get to Know Us\"]/../ul/li"));

		System.out.println(options.size());
		for(WebElement singleopt:options) {

			String name = singleopt.getText();

			System.out.println(name);
		}

	}

}
