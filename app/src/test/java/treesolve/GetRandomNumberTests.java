package treesolve;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GetRandomNumberTests {
  // Test that the method returns a value within the specified range
  @Test
  public void testGetRandomNumber_withinRange() {
    int min = 1;
    int max = 10;

    for (int i = 0; i < 100; i++) {
      // Call the method multiple times with the same range
      int num = App.getRandomNumber(min, max);

      // Check that each returned value is within the range
      assertTrue(num >= min && num <= max);
    }
  }

  // Test that the method returns the minimum and maximum values
  @Test
  public void testGetRandomNumber_minMax() {
    int min = 1;
    int max = 10;

    for (int i = 0; i < 100; i++) {
      // Call the method with a range that includes the minimum and maximum values
      int num = App.getRandomNumber(min, max);

      // If the returned value is either the minimum or maximum value, the test has passed
      if (num == min || num == max) {
        return;
      }
    }

    // If the loop completes, none of the returned values were the minimum or maximum
    fail();
  }

  // Test that the method throws an IllegalArgumentException when the minimum value is greater than the maximum value
  @Test
  public void testGetRandomNumber_invalidRange() {
    try {
      // Call the method with a range where the minimum value is greater than the maximum value
      App.getRandomNumber(10, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // If the exception is thrown, the test has passed
    }
  }
}
