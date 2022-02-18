package practies_read_data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amozon_links_img {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
			String link = links.get(i).getAttribute("href");
			System.out.println(link);
			verifyLinkActive(link);
		}
		
		


//		List<WebElement> imglinks = driver.findElements(By.tagName("img"));
//		System.out.println(imglinks.size());
//		for(int i=0;i<imglinks.size();i++) {
//			String link = imglinks.get(i).getAttribute("src");
//			System.out.println(link);
//
//		}



	}
	
	public static void verifyLinkActive(String linkUrl) throws IOException {
		try {
			URL url = new URL(linkUrl);
			
			HttpURLConnection urlconnector = (HttpURLConnection)url.openConnection();
			urlconnector.setConnectTimeout(3000);
			urlconnector.connect();
			
			if(urlconnector.getResponseCode()==200) {
				System.out.println(urlconnector.getResponseMessage());
			}
			else if(urlconnector.getResponseCode()==urlconnector.HTTP_NOT_FOUND) {
				System.out.println(urlconnector.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
