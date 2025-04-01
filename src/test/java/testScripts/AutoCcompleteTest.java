package testScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoCcompleteTest {
	public final String expValue = "JavaScript";
  @Test
  public void autoCompleteTest() {
	  //TODO Auto-generated method
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://jqueryui.com/autocomplete/");
	  WebElement frame1 = driver.findElement(By.cssSelector(".demo-frame"));
	  driver.switchTo().frame(frame1);
	  WebElement inp = driver.findElement(By.cssSelector("#tags"));
	  
	  inp.sendKeys("as");
	  List<WebElement> items = driver.findElements(By.cssSelector("ul#ui-id-1 > li"));
	  //To get the text of each item
	  for(WebElement item : items) {
		  //To get the text of each item
		  System.out.println(item.getText());
		  //To select expected value
		  if(item.getText().equalsIgnoreCase(expValue)) {
			  item.click();
			  break;
		  }
	  }
	  
  }
}
