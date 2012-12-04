package a4; 
import java.util.Comparator;

 


/**
    This class provides a method for comparing Strings,
      and keeps track of the number of String comparisons
      that it makes
     @author Jeff Smith
     @version for Assignment 1, CS 146, SJSU, Spring 2012
 */
// No explicit constructor is needed; the implicit
//   constructor is enough


public class CountingComparator implements Comparator<String>
{
    // a counter for the number of comparisons
    private int counter;

    
    /**
        Compares two Strings according to the contract
          for Comparator.compare
        @param n1 the first string
        @param n2 the second string
        @return an integer according to the contract
          for Comparator.compare
     */

    public int compare(String n1, String n2)        {
      counter++;
      return n1.compareTo/*IgnoreCase*/(n2);            }
     
      
    /**
        Sets the comparison counter to 0 
     */
    
    public void resetCounter()       {
      counter = 0;                   }

      
    /**
        Gets the current comparison count
        @return the current comparison count  
     */
    
    public int getCounter()         {
      return counter;               }
}