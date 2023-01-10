package treesolve;
import java.util.List;
import java.util.TreeMap;

//for passing to bricksorter(no refs :())
public class brickSorterObj {

    List<Integer> bricks;
  TreeMap<Integer, Integer> a;
  TreeMap<Integer, Integer> b; 
  int aSum;
  int bSum;

  // constructor
  public brickSorterObj
  (List<Integer> bricks, TreeMap<Integer, Integer> a, TreeMap<Integer, Integer> b, int aSum, int bSum){
  this.bricks = bricks;
  this.a = a;
  this.b = b;
  this.aSum = aSum;
  this.bSum = bSum;
  }








}


