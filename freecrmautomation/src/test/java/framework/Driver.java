  package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;
	
	
	private Driver() {		
		
	}
	
	public static WebDriver get() {
		return driver;
	}
	
	public static void initialize(String browser, String url) {
		browser = (browser == null)?"chrome":browser.toLowerCase();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			Assert.assertTrue(false, "Invalid browser name given. Browser name should be either one in 'chrome', 'firefox','ie' or 'edge'");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	

}
