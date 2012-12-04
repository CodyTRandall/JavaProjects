package a5;

import java.util.LinkedList;
import java.util.List;

  /**
      A class that tests the Maze class
      @author Jeff Smith
      @version for Assignment 5, Spring 2012, CS 146, SJSU  
  */

public class A5
{

  /**
       Tests the Maze class 
       @param args is ignored
   */
  
  public static void main(String[] args)                    {
    boolean isDown = true;
    
    Maze g0 = new Maze(5, null);
    List<Pair> result = g0.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
    
    //      + |+ |+  +  +
    //            -     -  
    //      +  + |+  +  +
    //      -        -
    //      +  + |+  + |+
    //      
    //      + |+  +  + |+
    //      -        -
    //      +  +  + |+  +
    
    LinkedList<Barrier> barriers = new LinkedList<Barrier>();
    barriers.add(new Barrier(1,0,isDown)); 
    barriers.add(new Barrier(2,0,isDown)); 
    barriers.add(new Barrier(2,1,isDown)); 
    barriers.add(new Barrier(2,2,isDown)); 
    barriers.add(new Barrier(1,3,isDown)); 
    barriers.add(new Barrier(4,2,isDown)); 
    barriers.add(new Barrier(4,3,isDown)); 
    barriers.add(new Barrier(3,4,isDown)); 
    barriers.add(new Barrier(0,2,!isDown)); 
    barriers.add(new Barrier(3,2,!isDown)); 
    barriers.add(new Barrier(0,4,!isDown)); 
    barriers.add(new Barrier(3,4,!isDown)); 
    barriers.add(new Barrier(2,1,!isDown)); 
    barriers.add(new Barrier(4,1,!isDown)); 
    Maze g1 = new Maze(5, barriers);
    System.out.println(g1); 
    result = g1.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
    
    result = g1.solveMaze();
    System.out.println(result);                        
    System.out.println();                        

    java.util.Random r = new java.util.Random(1);
    barriers.clear();
    int n = 10;
    for (int i=1; i<2*n*n/3; i++)
      barriers.add(
        new Barrier(r.nextInt(n), r.nextInt(n),r.nextBoolean()));
    Maze g2 = new Maze(10, barriers);
    System.out.println(g2); 
    result = g2.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
      
    r = new java.util.Random(1);
    barriers.clear();
    n = 10;
    for (int i=1; i<0.6*n*n; i++)
      barriers.add(
        new Barrier(r.nextInt(n), r.nextInt(n),r.nextBoolean()));
    Maze g3 = new Maze(10, barriers);
    System.out.println(g3); 
    result = g3.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
      
    r = new java.util.Random(1);
    barriers.clear();
    n = 10;
    for (int i=1; i<0.7*n*n; i++)
      barriers.add(
        new Barrier(r.nextInt(n), r.nextInt(n),r.nextBoolean()));
    Maze g4 = new Maze(10, barriers);
    System.out.println(g4); 
    result = g4.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
      
    // from Weiss, 3d. edition, Figure 8.29
    
    r = new java.util.Random(1);
    barriers.clear();
    barriers.add(new Barrier(1,1,isDown)); 
    barriers.add(new Barrier(1,3,isDown)); 
    barriers.add(new Barrier(2,2,isDown)); 
    barriers.add(new Barrier(2,4,isDown)); 
    barriers.add(new Barrier(3,2,isDown)); 
    barriers.add(new Barrier(4,0,isDown)); 
    barriers.add(new Barrier(4,3,isDown)); 
    barriers.add(new Barrier(0,1,!isDown)); 
    barriers.add(new Barrier(2,1,!isDown)); 
    barriers.add(new Barrier(3,1,!isDown)); 
    barriers.add(new Barrier(2,2,!isDown)); 
    barriers.add(new Barrier(3,2,!isDown)); 
    barriers.add(new Barrier(1,3,!isDown)); 
    barriers.add(new Barrier(0,4,!isDown)); 
    barriers.add(new Barrier(3,4,!isDown)); 
    barriers.add(new Barrier(4,4,!isDown)); 
    Maze g5 = new Maze(5, barriers);
    result = g5.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
    
    // the previous example, with an extra barrier
    
    r = new java.util.Random(1);
    barriers.add(new Barrier(3,4,isDown)); 
    Maze g6 = new Maze(5, barriers);
    result = g6.solveMaze();
    System.out.println(result);                        
    System.out.println();                        
    
    
  
  
  }  
}