package treesolve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class IncrementMapValTests {
  // Test that the method works as expected when the map contains the key
  @Test
  public void testIncrementMapVal_existingKey() {
    // TreeMap<Integer, Integer> map = new TreeMap<>();
    TreeMapObj tm = new TreeMapObj();
    tm.map.put(1, 10);
    tm.map.put(2, 20);

   // Call the method with a key that is in the map
    App.incrementMapVal(tm, 1);
   // Check that the value for that key has been incremented by 1
    assertEquals(11, (int) tm.map.get(1));
  }

  // Test that the method works as expected when the map does not contain the key
  @Test
  public void testIncrementMapVal_newKey() {
  // Create a map with some key-value pairs
    // Map<Integer, Integer> map = new HashMap<>();
    TreeMapObj tm = new TreeMapObj();
    tm.map.put(1, 10);
    tm.map.put(2, 20);
    // Call the method with a key that is not in the map
    App.incrementMapVal(tm, 3);
    // Check that the value for that key has been set to 1
    assertEquals(1, (int) tm.map.get(3));
  }

    // Test that the method throws a NullPointerException when the map is null
  @Test
  public void testIncrementMapVal_nullMap() {
    try {
    // Call the method with a null map
      App.incrementMapVal(null, 1);
      fail();
    } catch (NullPointerException e) {
    // If the exception is thrown, the test has passed
    }
  }

    // Test that the method throws a NullPointerException when the value for the key is null
  @Test
  public void testIncrementMapVal_nullValue() {
    // Map<Integer, Integer> map = new HashMap<>();
    TreeMapObj tm = new TreeMapObj();
    tm.map.put(1, null);

    // Call the method with the map and the key
    try {
      App.incrementMapVal(tm, 1);
      fail();
    } catch (NullPointerException e) {
    // If the exception is thrown, the test has passed
    }
  }
}
