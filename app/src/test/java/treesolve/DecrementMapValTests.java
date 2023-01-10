package treesolve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.NoSuchElementException;

import org.junit.Test;

public class DecrementMapValTests {
  // Test that the method works as expected when the map contains the key
  @Test
  public void testDecrementMapVal_existingKey() {
    TreeMapObj tm = new TreeMapObj();

    tm.map.put(1, 10);
    tm.map.put(2, 20);
    App.decrementMapVal(tm, 1);

    // Check that the value for that key has been decremented by 1
    assertEquals(9, (int) tm.map.get(1));
  }

  // Test that the method works as expected when the map does not contain the key
  @Test
  public void testDecrementMapVal_newKey() {
  TreeMapObj tm = new TreeMapObj();
  tm.map.put(1, 10);
  tm.map.put(2, 20);

  try {
    // Call the method with a key that is not in the map
    App.decrementMapVal(tm, 3);
    fail();
  } catch (NoSuchElementException e) {
    // If the exception is thrown, the test has passed
  }
}

  // Test that the method throws an IllegalArgumentException when the map is null
@Test
public void testDecrementMapVal_nullMap() {
  try {
    // Call the method with a null map
    App.decrementMapVal(null, 1);
    fail();
  } catch (IllegalArgumentException e) {
    // If the exception is thrown, the test has passed
  }
}

  // Test that the method throws a NullPointerException when the value for the key is null
  @Test
  public void testDecrementMapVal_nullValue() {
    // Create a map with a key that has a null value
    TreeMapObj tm = new TreeMapObj();
    tm.map.put(1, null);

    try {
      // Call the method with the map and the key
      App.decrementMapVal(tm, 1);
      fail();
    } catch (NullPointerException e) {
      // If the exception is thrown, the test has passed
    }
  }
}
