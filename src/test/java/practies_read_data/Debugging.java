package practies_read_data;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.erp.Vtiger.FileLib;
import com.erp.Vtiger.ObjectRepo.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Debugging  {
	WebDriver driver;
	@Test
	public void debugging() throws IOException, InterruptedException {
		
		
					//FileLib fil=new FileLib();
					WebDriverManager.chromedriver().setup();

					WebDriver driver = new ChromeDriver();
					driver.get("http://localhost:8888/index.php?action=Login&module=Users");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					//Login Vtiger
					driver.findElement(By.name("user_name")).sendKeys("admin");
					driver.findElement(By.name("userpassword")).sendKeys("admin");
					driver.findElement(By.id("submitButton")).click();
					
					String title = driver.getTitle();
					System.out.println(title);
					
					Thread.sleep(3000);
					Homepage homepage=new Homepage(driver);
					
					WebElement sp = homepage.getSingupimg();
					Actions mv=new Actions(driver);
					mv.moveToElement(sp).build().perform();
					homepage.getSingupbtn().click();
					
					Thread.sleep(10000);
					
					driver.close();
		

	}
		
		
		
		
		
	}


