package treesolve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PrintMapKVPTests {
  @Test
  public void testPrintMapKVP() {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 10);
    map.put(2, 20);

    // Use a ByteArrayOutputStream to capture the output of the method
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Call the method with the map
    App.printMapKVP(map);

    // Use assertions to check that the method printed the expected key-value pairs
    assertEquals("1=10\n2=20\n", outContent.toString());
  }

  @Test
  public void testPrintMapKVP_emptyMap() {
    Map<Integer, Integer> map = new HashMap<>();

    // Use a ByteArrayOutputStream to capture the output of the method
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Call the method with the empty map
    App.printMapKVP(map);

    // Check that the method did not print anything
    assertEquals("", outContent.toString());
  }

  @Test
  public void testPrintMapKVP_nullMap() {
    try {
      // Call the method with a null map
      App.printMapKVP(null);
      fail();
    } catch (NullPointerException e) {
      // If the exception is thrown, the test has passed
    }
  }
}
