package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicElementTest {
	String expItem = "Iphone 6 32gb";
  @Test
  public void dynamicElement() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://demoblaze.com/");
	  Thread.sleep(5000);
	  List <WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
	  
	  
	  
	  for (WebElement item:items) {
		  System.out.println(item);
		  if(item.getText().equalsIgnoreCase(expItem)) {
			  item.click();
			  break;
		  }
	  }
  }
}
