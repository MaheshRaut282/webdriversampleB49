package GroupScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test(groups="featureOne")
  public void testOne() {
	  System.out.println("Test 21 in SampleOne");  
  }
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  System.out.println("Test 22 in SampleTwo");  
  }
  
  @Test
  public void testThree() {
	  System.out.println("Test 23 in SampleThree");  
  }
}
