package practies_read_data;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://business.linkedin.com/marketing-solutions/cx/17/06/advertise-on-linkedin?trk=sem_lms_gaw&src=go-pa&veh=LMS-S_APAC_IN_High_EN_SEM_SEM_GoogleAds_NA_ALL_NA_NA_Core_SelfServeLP_CatchAll1_Brand_Exact_545760797737__business%20linkedin_c__kwd-308640612916_14649643598&mcid=6843969601940799566&cname=LMS-S_APAC_IN_High_EN_SEM_SEM_GoogleAds_NA_ALL_NA_NA_Core_SelfServeLP_CatchAll1_Brand_Exact&camid=14649643598&asid=127700687232&targetid=kwd-308640612916&crid=545760797737&placement=&dev=c&ends=1&gclid=CjwKCAiAo4OQBhBBEiwA5KWu_6fJj-O-JqJL74mv21jKtefoDnpsMsjhO3hL5m8SF4Zu3gcasoauNRoCzE8QAvD_BwE&gclsrc=aw.ds");

		driver.findElement(By.xpath("//a[contains(text(), 'Cookie Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Privacy Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'User Agreement')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Accessibility')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Sitemap')]")).click();
		
		Set<String> allwin = driver.getWindowHandles();
		String text;
		
		for(String singlewin:allwin) {
			
			String title = driver.switchTo().window(singlewin).getTitle();
			if(title.equalsIgnoreCase("Accessibility")) {
				//driver.switchTo().window(title);	
				System.out.println(title);
				break;
				
			
			}
			
		 
			
			
			
			
		}
		Thread.sleep(3000);
		text = driver.findElement(By.tagName("(//h2)[3]")).getText();
		System.out.println(text);
		
		
	}

}
