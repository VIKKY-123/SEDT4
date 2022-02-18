package com.erp.Vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * 
 * This class is Write the WebDriver methods 
 * @author DELL
 *
 */
public class WebDriverUility {
	/**
	 * 
	 * This Method is wait untill webpage loaded
	 * 
	 * @param driver
	 */

	public void pageloadedwait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 * this method is handling drop down
	 * @param element
	 * @param text
	 */

	public void selectfromDD( WebElement element, String text) {

		Select select=new Select(element);
		select.selectByVisibleText(text);

	}

	public void selectfromDD(String value, WebElement element ) {

		Select select=new Select(element);
		select.selectByValue(value);

	}
	public void selectfromDD( WebElement element, int index) {

		Select select=new Select(element);
		select.selectByIndex(index);

	}
	/**
	 * 
	 * @param driver
	 * @param title
	 */
	
	public void handlingWindows(WebDriver driver, String title) {
		
		 Set<String> allwin = driver.getWindowHandles();
		
		for(String singlewin:allwin) {
			String correcttitle = driver.switchTo().window(singlewin).getTitle();
			if(correcttitle.contains(title)) {
				break;
				
			}
			
			
		}
		
		
		
	}
	/**
	 * This method is handling to mousehover
	 * @param driver
	 * @param element
	 */
	
	public void movetoElement(WebDriver driver, WebElement element) {
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	/**
	 * this method is handling to the frames on webpage
	 * @param driver
	 * @param index
	 */
	
	
	public void switchtoframe(WebDriver driver, int index) {
	driver.switchTo().frame(index);	
	}
	

	public void switchtoframe(WebDriver driver, String value) {
	driver.switchTo().frame(value);
	}
	

	public void switchtoframe(WebDriver driver, WebElement element) {
	driver.switchTo().frame(element);	
	}
	
	
	

}
