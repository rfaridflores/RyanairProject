package testRyanairUtilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RyanairUtilities {
	private WebDriver driver;
	private static String[] LINKS = null;
	private static int LINKSCOUNT = 0;

	public RyanairUtilities (WebDriver driver)
	{
		this.driver = driver;
	}

	//Opens Browser and redirects to URL
	public void openBrowser()
	{			
		driver.get(RyanairSuiteListener.parameter.getUrl());			
	}		

	//Check Title
	public void checkTitle(String title)
	{
		String actual = driver.getTitle();	
		Assert.assertEquals(title, actual);
	}

	//Test navigation in the whole website	


	//Check Successful login message
	public void successLogin()
	{
		Assert.assertEquals(driver.getPageSource().contains("Thanks for signin"), true);
	}

	//waiting to load
	public void waitFor(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	//waiting to load
	public void backHome()
	{				
		driver.navigate().to(RyanairSuiteListener.parameter.getUrl());
	}

	//close browser
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
	}

	////Methods for DD and RB
	public void lookupOptionsByValueDD (String Name, WebDriver driver, String Values[])
	{
		WebElement select = null;
		List<WebElement> options= null;
		int i = 0;

		select = driver.findElement(By.name(Name));
		options = select.findElements(By.tagName("option"));		
		System.out.println("Total of values for dropdown: "+options.size());

		for (i = 0; i < options.size(); i++ )
		{				
			String currentOption = options.get(i).getAttribute("value");
			if ( currentOption.equalsIgnoreCase(Values[i]) == true)
				System.out.println((i+1)+". Option of dropdown with value: "+Values[i]+" Just as Expected");					
		}		
	}

	public void selectOptionByValueRB (String Name, WebDriver driver, String selection)
	{		
		List<WebElement> options = null;
		int i = 0;


		options = driver.findElements(By.name(Name));		
		System.out.println("Total of values for selection: "+options.size());

		for (i = 0; i < options.size(); i++ )
		{				
			String currentOption = options.get(i).getAttribute("value");			
			if (currentOption.equalsIgnoreCase(selection) == true)
			{
				System.out.println("Value selected: "+options.get(i).getAttribute("value"));
				options.get(i).click();
			}				
		}		
	}

	public void selectOptionByValueDD (String Name, WebDriver driver, String selection)
	{		
		WebElement select = null;
		List<WebElement> options= null;
		int i = 0;


		select = driver.findElement(By.name(Name));
		options = select.findElements(By.tagName("option"));				
		System.out.println("Total of values for selection: "+options.size());

		for (i = 0; i < options.size(); i++ )
		{				
			String currentOption = options.get(i).getAttribute("value");			
			if (currentOption.equalsIgnoreCase(selection) == true)
			{
				System.out.println("Value selected: "+options.get(i).getAttribute("value"));
				options.get(i).click();
			}				
		}		
	}
}
