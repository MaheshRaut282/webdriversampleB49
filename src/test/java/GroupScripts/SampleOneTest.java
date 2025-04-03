package GroupScripts;

import org.testng.annotations.Test;

public class SampleOneTest {
  @Test(groups="featureOne")
  public void testOne() {
	  System.out.println("Test 11 in SampleOne");  
  }
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  System.out.println("Test 12 in SampleTwo");  
  }
  
  @Test
  public void testThree() {
	  System.out.println("Test 13 in SampleThree");  
  }
}
