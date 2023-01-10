package treesolve;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmallestDiffTests {
  @Test
  public void Test_Cases() {
      // Test for the case where x is smaller than y and target is between x and y
      assertEquals(App.smallestDiff(1, 5, 3), 2);
      // Test for the case where x is smaller than y and target is greater than y
      assertEquals(App.smallestDiff(1, 5, 7), 2);
      // Test for the case where x is greater than y and target is between y and x
      assertEquals(App.smallestDiff(5, 1, 3), 2);
      // Test for the case where x is greater than y and target is less than y
      assertEquals(App.smallestDiff(5, 1, 0), 1);
      // Test for the case where x and y are equal
      assertEquals(App.smallestDiff(5, 5, 3), 2);
  }
}



