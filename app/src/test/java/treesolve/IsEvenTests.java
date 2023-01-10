package treesolve;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsEvenTests {
  // Test that the method returns true for even numbers
  @Test
  public void testIsEven_even() {
    // Call the method with a few even numbers
    assertTrue(App.isEven(2));
    assertTrue(App.isEven(4));
    assertTrue(App.isEven(6));
  }

  // Test that the method returns false for odd numbers
  @Test
  public void testIsEven_odd() {
    // Call the method with a few odd numbers
    assertFalse(App.isEven(1));
    assertFalse(App.isEven(3));
    assertFalse(App.isEven(5));
  }

  // Test that the method returns true for the minimum and maximum values of the int data type
  @Test
  public void testIsEven_minMax() {
    // Call the method with the minimum and maximum values of the int data type
    assertTrue(App.isEven(Integer.MIN_VALUE));
    assertFalse(App.isEven(Integer.MAX_VALUE));
  }

  // Test that the method returns true for zero
  @Test
  public void testIsEven_zero() {
    // Call the method with zero
    assertTrue(App.isEven(0));
  }
}
