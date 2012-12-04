
package a5;

/**
 *
 * @author Cody Randall
 */
public class Barrier {
    int x,y;
    boolean vertical;
    
    public Barrier(int x,int y, boolean isDown){
        this.x = x;
        this.y = y;
        this.vertical = isDown;
    }
}
