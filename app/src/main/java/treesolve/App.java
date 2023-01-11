package treesolve;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class App {


public static int getRandomNumber(int min, int max) {
  if (min > max) {throw new IllegalArgumentException("Minimum value must be less than or equal to maximum value.");}
  return (int) ((Math.random() * (max - min)) + min);
}

public static void printMapKVP(Map<Integer, Integer> map){
  for(Map.Entry<Integer, Integer> kvp : map.entrySet()){
      System.out.println(kvp);
    }
  }
public static boolean isEven(int x) {
  return Math.abs(x) % 2 == 0;
}

// be mindful of this one, we are now adding a new kvp will could alter the logic.
public static void incrementMapVal(TreeMapObj obj, int key) {
  if (obj.map == null) {
    throw new NullPointerException("Map cannot be null.");
  }
  if (obj.map.containsKey(key)) {
    obj.map.put(key, obj.map.get(key) + 1);
  } else {
    obj.map.put(key, 1);
  }
  obj.sum+=key;
}


public static double fitnessFunction(int aSum, int bSum, int target, int brickSum) {
    try {
        if (!isEven(brickSum)) {
            if (aSum == target || aSum == target + 1 || bSum == target || bSum == target + 1) return 0;
        } else {
            if (aSum == target || bSum == target) return 0;
        }
        return diffAsPosiPerc(smallestDiff(aSum, bSum, target), target);
    } catch (Exception e) {
        System.out.println("An error occurred while calculating the fitness function: " + e.getMessage());
        return 0;
    }
}

public static boolean fitnessEvaluator(double fitness){
      return fitness < 0.3 ? true : false;  
  }

public static void decrementMapVal(TreeMapObj obj, int key){
    if (obj == null) {throw new IllegalArgumentException("The obj argument cannot be null.");}
    if (obj.map == null) {throw new IllegalArgumentException("The obj map argument cannot be null.");}
    if (!obj.map.containsKey(key)) {throw new NoSuchElementException("The key is not present in the map.");}
    // Decrement the value of the key in the map
    obj.map.put(key, obj.map.get(key) - 1);
    obj.sum-=key;
    if(obj.map.get(key)==0)
      obj.map.remove(key);
  }


public static int smallestDiff(int x, int y, int target) {
  return Math.min(Math.abs(x - target), Math.abs(y - target));
}


public static double diffAsPosiPerc(int diff, int target) {
  if (target == 0) {
    throw new IllegalArgumentException("The target value cannot be zero.");
  }
  // Calculate the percentage using floating point division
  double perc = (diff * 100.0 / target);
  // If the percentage is negative, multiply it by -1 to make it positive
  return (perc < 0) ? perc * -1 : perc;
}




public static void resetTreeSums(TreeMapObj t1, TreeMapObj t2){
    t1.sum = 0;
    t2.sum = 0;
  }

// public static void mutate(TreeMapObj a, TreeMapObj b, Stack<Integer>bricks){
//     a.map = new TreeMap<Integer, Integer>();
//     b.map = new TreeMap<Integer, Integer>();
//     resetTreeSums(a, b);
//     shuffleBricks(bricks);
//     populateTrees(a, b, bricks);
//   }

public static void mutate(TreeMapObj a, TreeMapObj b, Stack<Integer> bricks) {
    try {
        int random = getRandomNumber(3, 7);

        List<Integer> keysMatchingPredicate = 
        a.map.keySet().stream()
          .filter(key -> isEven(key%random))
          .collect(Collectors.toList());

        for(Integer key : keysMatchingPredicate) {
           incrementMapVal(b, key);
            decrementMapVal(a, key);
        }
    } catch (Exception e) {
        // Catch any exceptions that may occur
        System.out.println("An error occurred while mutating the TreeMap objects: " + e.getMessage());
    }
}

public static int smallChange(TreeMapObj lhs, TreeMapObj rhs, int diff) throws IllegalArgumentException{
 
    if (lhs == null || rhs == null) throw new IllegalArgumentException("lhs and rhs cannot be null.");
    if (diff < 0) throw new IllegalArgumentException("diff cannot be negative.");
  
    if(lhs.map.floorEntry(diff)!=null){
    int closestLower = lhs.map.floorEntry(diff).getKey();
    incrementMapVal(rhs, closestLower);
    decrementMapVal(lhs, closestLower);
    return closestLower;
    }
    return 0;
  }

public static Stack<Integer> getBricks(){
      Stack<Integer> bricks = new Stack<Integer>();
  for(int i=0; i<20; i++){
     bricks.add(getRandomNumber(1, 50));
    }
    return bricks;
  }

public static void shuffleBricks(Stack<Integer> bricks){
    Collections.shuffle(bricks);
  }

public static void populateTrees(TreeMapObj a, TreeMapObj b, Stack<Integer> bricks){
 for(int pile : bricks){
   if (a.sum <= b.sum){
        incrementMapVal(a, pile);}
    else{incrementMapVal(b, pile);}
  }
}

public static void saveState(TreeMapObj t1, TreeMapObj t2, int[] resultSums){
      resultSums[0] = t1.sum;
      resultSums[1] = t2.sum;
  }

public static boolean betterThanLastFitness(double fitness, double lastfitness){
    return fitness < lastfitness ? true : false;
  }

public static void presentResults(int t1Sum, int t2Sum, int target, int iterations, double fitness){
  System.out.println("target: "+target);
  System.out.println("A sum =" + t1Sum);
  System.out.println("B Sum = "+t2Sum);
  System.out.println("This sort took a total of "+iterations+ " iterations");
  System.out.printf("Resulting in a differnce of  %.4f",fitness);
  System.out.println("% difference from the target value");
  }

public static boolean globalMaximaFound(TreeMapObj deficientT, TreeMapObj greedyT, int diff, int target, int brickSum){
    if(greedyT.map.containsKey(diff)){
      incrementMapVal(deficientT, diff);
      decrementMapVal(greedyT, diff);
      return true;
      }
    if(!isEven(brickSum)){
      if(greedyT.map.containsKey(target+1)){
        incrementMapVal(deficientT, target+1);
        decrementMapVal(greedyT, target+1);
        return true;
      }
    }return false;
  }



public static int updatedDiff(int aSum, int bSum, int target){
  return (smallestDiff(aSum, bSum, target));
}

public static double[] saveResults(double[] result, int t1Sum, int t2Sum, int target, int iterations, double fitness){
    result[0] = t1Sum;
    result[1] = t2Sum;
    result[2] = target;
    result[3] = iterations;
    result[4] = fitness;
    return result;
  }



public static double[] hillClimbing(){
    Stack<Integer> bricks = getBricks();
    final int brickSum = bricks.stream().reduce(0, Integer::sum);
    TreeMapObj a = new TreeMapObj(new TreeMap<Integer, Integer>());
    TreeMapObj b = new TreeMapObj(new TreeMap<Integer, Integer>());
    populateTrees(a, b, bricks);
    int resultSums[] = new int[2];
  
    int target = (a.sum + b.sum)/2;
    int diff = (smallestDiff(a.sum, b.sum, target));
    double fitness=0, bestFitness=(Double.MAX_VALUE);

    int iterations = 1, change = 0;
    
    do{
      
      // indicates perfect solution 
      if (globalMaximaFound(a, b, diff, target, brickSum)){
        saveState(a, b, resultSums);
        bestFitness = fitnessFunction(a.sum, b.sum, target, brickSum);
        diff = updatedDiff(a.sum, b.sum, diff);
        
        break;
      }

      // small change is default
      if(a.sum > b.sum)  change = smallChange(a, b, diff);
      else change = smallChange(b, a, diff);

      //no change indicates local maxima
      if (change == 0) mutate(a, b, bricks);

      // determine fitness, evaluate, save if new best fitness
      fitness = fitnessFunction(a.sum, b.sum, target, brickSum);
      if (betterThanLastFitness(fitness, bestFitness)){
        saveState(a, b, resultSums);
        bestFitness = fitness;
      }
      
      // break if fitness within defined threshold
      if (fitnessEvaluator(fitness)){
      break;
      }


    diff = updatedDiff(a.sum, b.sum, target);
    iterations++;
    } while(iterations < 100); 

    double[] toReturn = new double[5];
    toReturn = saveResults(toReturn, resultSums[0], resultSums[1], target, iterations, bestFitness);
    presentResults(resultSums[0], resultSums[1], target, iterations, bestFitness);
    
    return toReturn;
    }





//================================================================================================//
    public static void main(String[] args) {
    TimerObj timer = new TimerObj();

    double[] results = new double[5];
    for(int i=0; i<1; i++){
    results = hillClimbing();
    String fitnessFormatted = String.format("%.2f", results[4]);
    System.out.println(fitnessFormatted);
    }
    timer.endTimer();
    // System.out.println("time:"+timer.getDurationAsMillis());

  }  
}
