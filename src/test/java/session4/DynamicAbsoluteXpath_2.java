package session4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicAbsoluteXpath_2 {
	
	WebDriver driver;
	String TextToBeClicked = "Pepe Tshirt";
	String textToBeSearched = "pepe";
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void searchboxTest() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchBox.sendKeys(textToBeSearched);
		
		Thread.sleep(3000);
		
		WebElement searchItem = driver.findElement(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null' and text()='"+TextToBeClicked+"']"));
		
		searchItem.click();
		
		Thread.sleep(3000);

	}
	@After
	public void teardown()
	{
		driver.quit();
	}
}
