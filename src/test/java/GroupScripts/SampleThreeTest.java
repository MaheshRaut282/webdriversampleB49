package GroupScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test(groups="featureOne")
  public void testOne() {
	  System.out.println("Test 31 in SampleOne");  
  }
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  System.out.println("Test 32 in SampleTwo");  
  }
  
  @Test
  public void testThree() {
	  System.out.println("Test 33 in SampleThree");  
  }
}
