package treesolve;
import java.util.TreeMap;

public class TreeMapObj {

  public TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
  public int sum;

 public TreeMapObj(TreeMap<Integer, Integer> map){
   this.map = map;
   this.sum = 0;
  }

 public TreeMapObj(){
   this.map = new TreeMap<Integer, Integer>();
   this.sum = 0;
  }

 
};


