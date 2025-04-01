package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDOMTest {
  @Test
  public void shadowDOM() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://the-internet.herokuapp.com/shadowdom");
	  
	  WebElement shadowHost = driver.findElement(By.xpath("(//my-paragraph)[1]"));
	  SearchContext context = shadowHost.getShadowRoot();
	  WebElement txt = context.findElement(By.cssSelector("slot[name='my-text']"));
//	  WebElement txt = driver.findElement(By.cssSelector("slot[name='my-text']"));
	  System.out.println(txt.getText());
	  
	  String strTxt = driver.findElement(By.xpath("//span[contains(text(), 'different')]")).getText();
	  System.out.println(strTxt);
  }
}
