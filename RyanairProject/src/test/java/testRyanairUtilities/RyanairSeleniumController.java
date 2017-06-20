package testRyanairUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class RyanairSeleniumController {
	
	private  static WebDriver driver = null;
	
	public enum BrowserType{BrowserType_IE ("ie"), BrowserType_FX ("fx");
	
	private String browserType; 
	
	private BrowserType(String browserType){
		this.browserType = browserType;
	}
	
	public String getBrowsertype(){
		return this.browserType;
	}	
	
	}
	public static WebDriver initSelenium(){	
		if(RyanairSuiteListener.parameter.getDriverType().equals(BrowserType.BrowserType_IE.getBrowsertype())){
			driver = new InternetExplorerDriver();
		}
		else if(RyanairSuiteListener.parameter.getDriverType().equals(BrowserType.BrowserType_FX.getBrowsertype())){
			driver = new FirefoxDriver();
		}
		return driver;
	}
}
