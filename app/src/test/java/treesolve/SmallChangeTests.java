package treesolve;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SmallChangeTests {

    @Test
    public void testSmallChange_closestLowerInLhs() {
        TreeMapObj lhs = new TreeMapObj();
        lhs.map.put(3, 1);
        TreeMapObj rhs = new TreeMapObj();
        int diff = 5;

        int result = App.smallChange(lhs, rhs, diff);

        assertEquals(3, result);
        assertFalse(lhs.map.containsKey(3));
        assertTrue(rhs.map.containsKey(3));
    }

    @Test
    public void testSmallChange_noClosestLowerInLhs() {
        TreeMapObj lhs = new TreeMapObj();
        lhs.map.put(6, 1);
        TreeMapObj rhs = new TreeMapObj();
        int diff = 5;

        int result = App.smallChange(lhs, rhs, diff);

        assertEquals(0, result);
        assertTrue(lhs.map.containsKey(6));
        assertFalse(rhs.map.containsKey(6));
    }

    @Test
    public void testSmallChange_emptyLhs() {
        TreeMapObj lhs = new TreeMapObj();
        TreeMapObj rhs = new TreeMapObj();
        int diff = 5;

        int result = App.smallChange(lhs, rhs, diff);

        assertEquals(0, result);
        assertTrue(lhs.map.isEmpty());
        assertTrue(rhs.map.isEmpty());
    }










}
