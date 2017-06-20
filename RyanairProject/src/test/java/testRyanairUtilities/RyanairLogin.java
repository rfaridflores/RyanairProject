package testRyanairUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RyanairLogin {

	private WebDriver driver;
	
	public RyanairLogin(WebDriver driver){
		
		this.driver = driver;
	}

	//clicking Sign In link
	public void clickSignIn() throws Exception
	{	
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[@id='myryanair-auth-login']/a/span")));	
	}
	
	//set user	
	public void setUsr()
	{	
		driver.findElement(By.name("emailAddress")).sendKeys(RyanairSuiteListener.parameter.getUser());
	}
	
	//set password
	public void setPass()
	{
		driver.findElement(By.xpath("//*[@input-name = 'password']/input")).sendKeys(RyanairSuiteListener.parameter.getPass());
	}
	
	//submit info
	public void submit()
	{	
		driver.findElement(By.xpath("//*[@translate = 'MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']")).click();	//core-btn-primary	
	}	
	
	//Logout
		public void clickLogOut()
	{	
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[1]/div[1]/header/div[1]/div/div[2]/div/ul/li[1]/ul/li/a")));
			//((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", driver.findElement(By.xpath("//div[1]/div[1]/header/div[1]/div/div[2]/div/ul/li[1]/ul/li/a")));
			
	}
}

