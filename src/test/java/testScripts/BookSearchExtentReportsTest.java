package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BookSearchExtentReportsTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("teset-output/SparkReport1.html");
		extentReports.attachReporter(spark);
	}
	
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
	
	 @Test
	  public void horrorSearch() {
		  extentReports.createTest("Horror Search Test");
		  driver.findElement(By.xpath("//a[contains(text(), 'Horror')]")).click();
		  String strUrl = driver.getCurrentUrl();
		  Assert.assertTrue(strUrl.contains("horror"));
	  }

	  @Test
	  public void storiesSearch() {
		  extentReports.createTest("Novel & Stories Search Test");
		  driver.findElement(By.xpath("//a[contains(text(), 'Novel')]")).click();
		  String strUrl = driver.getCurrentUrl();
		  Assert.assertTrue(strUrl.contains("novel"));
		  //Assert.assertTrue(strUrl.contains("novel Stories"));
	  }
	  
	  
  
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
  
  
  
}
