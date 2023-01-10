// package treesolve;
// import static org.junit.Assert.assertEquals;
// import java.util.Stack;
// import org.junit.Test;

// public class MutateTests {

//     @Test
//     void testMutate() {
//         // Create a TreeMapObj and add some key-value pairs to it
//         TreeMapObj a = new TreeMapObj();
//         a.map.put(1, 3);
//         a.map.put(2, 5);
//         a.map.put(3, 7);
//         a.map.put(4, 9);

//         // Create another TreeMapObj
//         TreeMapObj b = new TreeMapObj();

//         // Create a stack of bricks
//         Stack<Integer> bricks = new Stack<>();
//         bricks.push(1);
//         bricks.push(2);
//         bricks.push(3);

//         // Call the mutate function
//         App.mutate(a, b, bricks);

//         // Verify that the values in the two TreeMap objects are as expected
//         assertEquals(2,(int)a.map.get(1));
//         assertEquals(4, (int)a.map.get(2));
//         assertEquals(6, (int)a.map.get(3));
//         assertEquals(8, (int)a.map.get(4));

//         assertEquals(1, (int)b.map.get(1));
//         assertEquals(2, (int)b.map.get(2));
//         assertEquals(3, (int)b.map.get(3));
//         assertEquals(null, b.map.get(4));
//     }
// }
