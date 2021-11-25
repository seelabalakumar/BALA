package framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventMethods {
	
	public void clickElement(By by, int timeout) {
		WebElement elem = getElement(by, timeout);
		if (elem == null) {
			
		} else {
			
		}
		
	}
	
	
	public static WebElement getElement(By by, int timeout) {
		WebElement elem = null;
		
		try {
			WebDriverWait  wait = new WebDriverWait(GlobalVariables.driver, timeout);
			wait.pollingEvery(Duration.ofMillis(200));
			elem = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return elem;
		} catch(Exception e) {
			return null;
		}
		
	}

}
