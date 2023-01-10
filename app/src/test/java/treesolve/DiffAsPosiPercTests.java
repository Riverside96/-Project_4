package treesolve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DiffAsPosiPercTests {
  // Test that the method works as expected when the difference is positive
  @Test
  public void testDiffAsPosiPerc_positive() {
    // Call the method with a positive difference and a target value
    double perc = App.diffAsPosiPerc(10, 100);

    // Check that the method returns the correct percentage
    assertEquals(10, perc, 0.00001);
  }

  // Test that the method works as expected when the difference is negative
  @Test
  public void testDiffAsPosiPerc_negative() {
    // Call the method with a negative difference and a target value
    double perc = App.diffAsPosiPerc(-10, 100);

    // Check that the method returns the correct percentage
    assertEquals(10, perc, 0.00001);
  }

  // Test that the method works as expected when the difference is zero
  @Test
  public void testDiffAsPosiPerc_zero() {
    // Call the method with a zero difference and a target value
    double perc = App.diffAsPosiPerc(0, 100);

    // Check that the method returns 0
    assertEquals(0, perc, 0.00001);
  }

  // Test that the method throws an IllegalArgumentException when the target value is zero
  @Test
  public void testDiffAsPosiPerc_zeroTarget() {
    try {
      // Call the method with a non-zero difference and a zero target value
      App.diffAsPosiPerc(10, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If the exception is thrown, the test has passed
    }
  }
}
