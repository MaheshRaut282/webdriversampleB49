package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
  @Test
  public void practice() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  List <WebElement> items = driver.findElements(By.xpath("//td[contains(text(),'Master In Selenium')]//following-sibling::td"));
	  System.out.println("Details of book: ");
	  for (WebElement item:items) {
		  System.out.println(item.getText());
	  }
	  
	 WebElement book = driver.findElement(By.xpath("//td[contains(text(),'2000')]//preceding-sibling::td[3]"));
	 System.out.println(book.getText());
	  
	 WebElement book2 = driver.findElement(By.xpath("//td[contains(text(),'Amit')]//following-sibling::td[1]"));
	 System.out.println(book2.getText());
	  driver.quit();
  }
}
