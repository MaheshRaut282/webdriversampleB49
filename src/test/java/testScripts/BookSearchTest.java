package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookSearchTest {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://danube-webshop.herokuapp.com/");
	}
	

//	@BeforeMethod
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("https://danube-webshop.herokuapp.com/");
//	}
  @Test(alwaysRun = false, dependsOnMethods="fantasySearch")
  public void crimeNovelSearch() {
	  driver.findElement(By.xpath("//a[contains(text(), 'Crime & Thrillers')]")).click();
	  String strUrl = driver.getCurrentUrl();
	  Assert.assertTrue(strUrl.contains("crime"));
  }
  
  @Test
  public void storiesSearch() {
	  driver.findElement(By.xpath("//a[contains(text(), 'Novel')]")).click();
	  String strUrl = driver.getCurrentUrl();
	  Assert.assertTrue(strUrl.contains("novel"));
	  //Assert.assertTrue(strUrl.contains("novel Stories"));
  }
  
  //@Test{enabled=false}
  @Test
  public void fantasySearch() {
//	  WebDriver driver = new ChromeDriver();
//	  driver.get("https://danube-webshop.herokuapp.com/");
	  driver.findElement(By.xpath("//a[contains(text(), 'Fantasy')]")).click();
	  String strUrl = driver.getCurrentUrl();
	  Assert.assertTrue(strUrl.contains("fantasy"));
  }
  
  @Test(priority=1)
  public void horrorSearch() {
//	  WebDriver driver = new ChromeDriver();
//	  driver.get("https://danube-webshop.herokuapp.com/");
	  driver.findElement(By.xpath("//a[contains(text(), 'Horror')]")).click();
	  String strUrl = driver.getCurrentUrl();
	  Assert.assertTrue(strUrl.contains("horror"));
  }
  
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
}
