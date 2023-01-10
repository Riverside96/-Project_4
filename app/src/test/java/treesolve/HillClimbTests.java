package treesolve;
import static org.junit.Assert.*;
import org.junit.Test;

public class HillClimbTests {
    // Test that the function returns an array of the expected length
    @Test
    public void testHillClimbing_arrayLength() {
        double[] result = App.hillClimbing();
        assertEquals(5, result.length);
    }

    // ensure sum of return sums /2 = target
    @Test
    public void testHillClimbing_sums() {
        double[] result = App.hillClimbing();
        int sum1 = (int) result[0];
        int sum2 = (int) result[1];
        assertTrue(((sum1 + sum2)/2) == (int) result[2]);
    }

    // ensure function returns an array with the expected number of iterations
    @Test
    public void testHillClimbing_iterations() {
        double[] result = App.hillClimbing();
        assertTrue(result[3] > 0);
    }

    // Test that the function returns an array with the expected best fitness value
    @Test
    public void testHillClimbing_bestFitness() {
        double[] result = App.hillClimbing();
        assertTrue(result[4] >= 0);
    }
}
