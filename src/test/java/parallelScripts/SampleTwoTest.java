package parallelScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test
  public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test21 in SampleOne..."+id);
  }
  public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test22 in SampleOne..."+id);
  }
  public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test23 in SampleOne..."+id);
  }
}
