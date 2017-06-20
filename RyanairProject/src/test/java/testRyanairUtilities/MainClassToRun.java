package testRyanairUtilities;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainClassToRun {

	private WebDriver driver;
	public RyanairLogin login;
	public RyanairUtilities util;
	public RyanairDestinationAirport airport;

	@BeforeClass
	public void init() throws Exception{
		
		driver= RyanairSeleniumController.initSelenium();
		login = new RyanairLogin(driver);
		util = new RyanairUtilities(driver);
		airport=new RyanairDestinationAirport(driver);
	}

	@Test
	public void mainPage() throws Exception{
		System.out.println("Before Load Window..................");
		util.openBrowser();		
		System.out.println("After Load Window..................");
		driver.manage().window().maximize();
		System.out.println("Window Maximized..................");
		util.waitFor(By.linkText("Log in"));
		login.clickSignIn();

		util.waitFor(By.name("emailAddress"));
		login.setUsr();

		util.waitFor(By.xpath("//*[@input-name = 'password']/input"));
		login.setPass();
		
		util.waitFor(By.xpath("//*[@translate = 'MYRYANAIR.AUTHORIZATION.LOGIN.LOGIN_AUTHORIZATION']"));
		login.submit();
		
		util.waitFor(By.xpath("//input[@placeholder ='Departure airport']"));
		
		airport.selectFromDestinationAirport();	
		
		airport.selectToDestinationCountry();
		airport.selectToDestinationAirport();
		airport.departureDate();
		driver.findElement(By.id("flight-search-type-option-one-way")).click();

	//	airport.arrivalDate(); //2 ways fly

		airport.confirmFly();
		
		
		util.closeBrowser();
	}
}
