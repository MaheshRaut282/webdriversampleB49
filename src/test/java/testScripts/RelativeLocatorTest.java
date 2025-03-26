package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class RelativeLocatorTest {
  @Test
  public void relativeLoc() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://automationbookstore.dev/");
	  String strid = driver.findElement(with(By.tagName("li"))
			  .toLeftOf(By.id("pid6"))
			  .below(By.id("pid1")))
		//	  .getAttribute("id");
			  .getDomAttribute("id");
	  System.out.println(strid);
	  
	  
  }
}
