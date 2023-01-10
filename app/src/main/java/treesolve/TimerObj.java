package treesolve;
public class TimerObj {
  long startTime;
  long endTime;
  long duration;

  public TimerObj(){
    this.startTime = System.nanoTime();
    this.endTime = 0;
  };
  public long getDurationAsMillis(){
    return (endTime -startTime)/1000000;
  }
  public void endTimer(){
    this.endTime = System.nanoTime();
  }
}

