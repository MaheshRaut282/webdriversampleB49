package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
  /**
 * 
 */
@Test
  public void selectValue() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  Select sel = new Select(driver.findElement(By.id("country")));
//	  sel.selectByValue("India");
	  sel.selectByIndex(9);
	  
	  Select mulsel = new Select(driver.findElement(By.id("colors")));
	  if(mulsel.isMultiple()) {
		  mulsel.selectByIndex(0);
		  mulsel.selectByValue("green");
		  mulsel.selectByVisibleText("Red");
		  
		  List<WebElement> items = mulsel.getAllSelectedOptions();
		  System.out.println(items.size());
		  mulsel.deselectByValue("green");
	  }
  }
}
