package practies_read_data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
//		List<WebElement> allops = driver.findElements(By.xpath("//ul[@class=\"trending_list menu-link\"]/li"));
//	// String allops = driver.findElements(By.xpath("//ul[@class=\"trending_list menu-link\"]/li")).toString();
//		for(WebElement singalop:allops) {
//			System.out.println(singalop);
		//}
		Thread.sleep(3000);
		
		
		List<WebElement> allopt = driver.findElements(By.xpath("//ul[@class=\"trending_list menu-link\"]/li"));

        System.out.println(allopt.size());

        for (WebElement webElement : allopt) {
            String name = webElement.getText();
            System.out.println(name);
	}
	}
}
