package testRyanairUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RyanairDestinationAirport {

	private WebDriver driver;
	public RyanairUtilities util=new RyanairUtilities(driver);

	public RyanairDestinationAirport(WebDriver driver){

		this.driver = driver;
	}

	//Select From Airport
	public void selectFromDestinationAirport()
	{	
		driver.findElement(By.xpath("//input[@placeholder ='Departure airport']")).click();
	}
	//Select Destination Country
	public void selectToDestinationCountry()
	{	
		WebElement destinationCountry=null;
		List<WebElement> countries=null;
		System.out.println("Selecting Destination Country------------>");
		driver.findElement(By.xpath("//input[@placeholder ='Destination airport']")).click();
		destinationCountry=driver.findElement(By.xpath("//*[@class ='core-list-small three-cols']"));
		countries=destinationCountry.findElements(By.tagName("div"));
		boolean flag=true;
		int i=0;
		while(flag)
		{
			if (!countries.get(i).getAttribute("class").contains("unavailable") && !countries.get(i).getAttribute("class").contains("ng-hide")) {
				System.out.println("DestinationCountry------------> "+countries.get(i).getText());
				countries.get(i).click();
				flag=false;
			}
			i+=1;

		}
	}

	//Select To Airport
	public void selectToDestinationAirport()
	{	
		WebElement destinationAirport=null;
		List<WebElement> airports=null;
		System.out.println("Selecting Destination Airport ---------->");
		destinationAirport=driver.findElement(By.xpath("//*[@class ='pane right']"));
		airports=destinationAirport.findElements(By.tagName("span"));
		int i=0;
		airports.get(i).click();
	}

	//Select Departure Date
	public void departureDate() throws InterruptedException{	
		WebElement dateElement=null;
		List<WebElement> dates=null;
		System.out.println("Select Departure Date--------");
		dateElement=driver.findElement(By.xpath("//*[@class ='calendar-view']"));
		dates=dateElement.findElements(By.tagName("ul"));
		int i=0;//days
		boolean flag=true;

		while(flag)
		{
			//Getting Days
			if (dates.get(i).getAttribute("class").equalsIgnoreCase("days")) 
			{
				dates = dates.get(i).findElements(By.tagName("li"));
				//Each day of month
				for (WebElement day : dates)
				{
					if(!(day.getAttribute("class").contains("unavailable"))){
						day.click();
						flag=false;
						break;
					}
				}
			}
			i+=1;
			// click on 'Next Month' if we are not able to pick a date from current month
			if(i==33){

				i=0;
				driver.findElement(By.xpath("//*[@class ='arrow right']")).click();
				departureDate();
			}
		}
	}

	//Select arrival Date
	public void arrivalDate() throws InterruptedException{	
		WebElement dateElement=null;
		List<WebElement> dates=null;
		System.out.println("Select Departure Date--------");
		dateElement=driver.findElement(By.xpath("//*[@class ='calendar-view']"));
		dates=dateElement.findElements(By.tagName("ul"));
		int i=0;//days
		boolean flag=true;

		while(flag)
		{
			//Getting Days
			if (dates.get(i).getAttribute("class").equalsIgnoreCase("days")) 
			{
				dates = dates.get(i).findElements(By.tagName("li"));
				//Each day of month
				for (WebElement day : dates)
				{
					if(!(day.getAttribute("class").contains("unavailable")) && !(day.getAttribute("class").contains("select"))){
						day.click();
						flag=false;
						break;
					}
				}
			}
			i+=1;
			// click on 'Next Month' if we are not able to pick a date from current month
			if(i==33){

				i=0;
				driver.findElement(By.xpath("//*[@class ='arrow right']")).click();
				util.waitFor(By.xpath("//*[@class ='calendar-view']"));
				departureDate();
			}
		}
	}

	//confirm Fly
	public void confirmFly() throws InterruptedException{	
		WebElement dateElement=null;
		List<WebElement> dates=null;
		System.out.println("Confirming Flying--------");
		dateElement=driver.findElement(By.xpath("//*[@class ='scroller']"));
		dates=dateElement.findElements(By.tagName("div"));
		int i=0;
		boolean flag=true;

		while(flag)
		{
			//Getting Each slide
			if (dates.get(i).getAttribute("class").equalsIgnoreCase("slide")) 
			{
				dates = dates.get(i).findElements(By.tagName("div"));
				System.out.println("Confirminf Flying------------"+dates.get(i));
				//Each day of month
				for (WebElement day : dates)
				{
					if(!(day.getAttribute("class").contains("unavailable"))){
						day.click();
						flag=false;
						break;
					}
				}
			}
			i+=1;
		}
	}



}

