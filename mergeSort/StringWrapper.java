package a4; 
 

/**
    This class is a wrapper class for strings that also contains 
      a comparator object that counts the number of comparisons
      performed by the string. 
    @author Jeff Smith 
    @version for Assignment 1, CS 146, Section 3, SJSU, Spring 2012
 */

public class StringWrapper implements Comparable<StringWrapper>
{
    private String string;          // the string to be wrapped
    private CountingComparator cc;  
       // the comparator to be used for string comparisons
     
 
    /**
         Constructs a wrapper for a given string that uses a given
           counting comparator for string comparisons.  Null arguments
           are accepted
         @param s the string to be wrapped
         @param cc the comparator to be used for string comparisons
     */
    
    public StringWrapper(String s, CountingComparator cc)
    {
        this.string = s;
        this.cc = cc;
    }

    
    /**
         Compares this StringWrapper object with another for order. 
         Null arguments and CountingComparators are not checked for.
         @return a negative integer, zero, or a positive integer 
          as this object is less than, equal to, or greater than the specified object.
     */
    public int compareTo(StringWrapper y)
    {
        return cc.compare(string, y.string);
    }

    
    /**
       Indicates whether some other object is "equal to" this one. 
       @param  y   the object to be compared to 
       @return <code>true</code> if and only if y is a StringWrapper
         wrapping a string that is equal (case-sensitively) 
         to the string wrapped by this object
     */
    
    public boolean equals(Object otherObject)                     {
      if (otherObject == null) return false;
      if (getClass() != otherObject.getClass())
        return false;
      StringWrapper other = (StringWrapper) otherObject;
      return compareTo(other)==0;                                 }

    
    /**
        Returns a hash code value for the object.
        No null check is made for the string being represented
        @return the hash code of the string being represented 
     */

    public int hashCode()
    {
        return string.hashCode();
    }

    
    /**
        Sets the comparison counter of the counting comparator to 0.
        No check is made whether this counting comparator is null
     */
    
    public void resetCounter()       {
      cc.resetCounter();             }

      
    /**
        Gets the current comparison count of the counting comparator 
        No check is made whether this counting comparator is null
        @return the current comparison count  
     */
    
    public int getCounter()         {
      return cc.getCounter();       }
    
    /**
     *  
     * @return the current string
     */
    public String toString(){
        return string;
    }
    
}