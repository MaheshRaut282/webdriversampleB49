package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExpWaitTest {
  @Test
  public void waitTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://uitestingplayground.com/ajax");
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	  driver.findElement(By.id("ajaxButton")).click();
	  wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div#content")), "Data loaded with AJAX get request."));
	  
	  String strTxt = driver.findElement(By.cssSelector("div#content")).getText();
	  System.out.println(strTxt);
	  
  }
}
