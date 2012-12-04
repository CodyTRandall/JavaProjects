
package a5;

/**
 * The pair class that holds the X and Y values
 * @author Cody Randall
 */
public class Pair {
    //First integer is row, second is column number
    int x,y;
    
    /*
     * @param creates a Pair with given x and y
     */
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    /*
     * @return returns string representation of the pair.
     */
    public String toString(){
        return "("+x+","+y+")";
    }

    
    
}
