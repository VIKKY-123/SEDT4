package practies_read_data;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.erp.Vtiger.WebDriverUility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart_task_001 {

	public String furnasing;
	public List<WebElement> homefur;
	public List<WebElement> subfur;
	public String text2;

	@Test
	public void flipkart_Task() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();

		WebElement element = driver.findElement(By.xpath("//img[@alt=\"Home\"]"));
		Thread.sleep(3000);
		WebDriverUility webutil=new WebDriverUility();
		webutil.movetoElement(driver, element);


		homefur = driver.findElements(By.xpath("//div[@class=\"_3XS_gI _7qr1OC\"]/a"));
		subfur = driver.findElements(By.xpath("//div[@class=\"_3XS_gI\"]/a"));





		for(WebElement text:homefur) {

			furnasing = text.getText();
			System.out.println(furnasing);

			
			for (int i = 1; i < homefur.size(); i++) {

				WebElement ele = driver.findElement(By.xpath("//div[@class=\"_3XS_gI _7qr1OC\"]/a["+i+"]"));
				webutil.movetoElement(driver, ele);


				for(WebElement singlesubfur:subfur) {
					

					text2=singlesubfur.getText();
					System.out.println(text2);
				}



			}

				}


			//		 
			//		 Actions action=new Actions(driver);
			//
			//for (int i = 0; i < homefur.size(); i++) {
			//	 WebElement homefur1 = driver.findElement(By.xpath("//div[@class=\"_3XS_gI _7qr1OC\"]/a["+i+"]"));
			//	
			//	
			//	action.moveToElement(homefur1).build().perform();
			//	System.out.println(homefur.get(i).getText());
			//	for (int j = 0; j < subfur.size(); j++) {
			//		
			//		System.out.println(subfur.get(j).getText());
			//		
			//	}
			//}
			//		 

		}

	}
