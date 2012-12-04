
package a5;

import java.util.ArrayList;
import java.util.List;

/**
 * The basic maze class that solves a maze full of pairs and barriers
 * @author Cody Randall
 */
public class Maze {
    int size;
    List<Barrier> b;
    List<Node> nodes = new ArrayList<Node>();
    List<Pair> returnPair = new ArrayList<Pair>();
    
    /*
     * @param Size, the size of the nxn maze
     * @param Barriers, a list of all the barriers in the maze
     */
    public Maze(int size, List barriers){
        this.size = size;
        this.b = barriers;
        //Check for null barrier case, if it is null then define the barrier list
        if(barriers == null){
            b = new ArrayList<Barrier>();
        }
    }
    
    /*
     * Solves the maze with the current barriers
     * @return Returns a list of the pairs in order to reach the end of the maze
     */
    public List solveMaze(){
        //Create all the nodes then start recursive call on first node
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                nodes.add(new Node(x,y));
            }
        }
        
        //Start recursive call on first node
        visit(nodes.get(0));
        
        //Reverse the order of the list then return
        List<Pair> returnPairR = new ArrayList<Pair>();
        for(int z=returnPair.size()-1; z>-1; z--){
            returnPairR.add(returnPair.get(z));
        }
        return returnPairR;
    }
    
    /*
     * To save space and time, this method returns the Adjacency List for the given node.
     * This way we only need to have adjacency lists for nodes that we traverse too instead
     * of creating all of them at the start.
     * @param The node to create the adjacency list for
     * @return returns the Adjacency list
     */
    private List getAdjacent(Node n){
        List returnList = new ArrayList<Node>();
        boolean flag = true;
        
        //Check left if it exists
        if(n.pair.x-1>0){
            //Check if the barrier exists, if it does then do nothing
            for(int x=0; x<b.size(); x++){
                //If there is a barrier in the way then we set the flag to false to not add
                if(b.get(x).x == n.pair.x && b.get(x).y == n.pair.y && b.get(x).vertical == true){
                   flag = false;
                   break;
                }
            }
            //If it exists and there is no barrier, add it to the list
            if(flag){
                returnList.add(findNode(n.pair.x-1,n.pair.y));
            }
        }
        
        //Check right if it exists
        if(n.pair.x+1<size){
            flag = true;
            for(int x=0; x<b.size(); x++){
                //Check if there is a barrier to the right
                if(b.get(x).x == n.pair.x+1 && b.get(x).y == n.pair.y && b.get(x).vertical == true){
                    flag = false;
                    break;
                }
            }
            if(flag){
                 returnList.add(findNode(n.pair.x+1,n.pair.y));
            }
        }
        
        //Check top if it exists
        if(n.pair.y-1>0){
            flag = true;
            for(int x=0; x<b.size(); x++){
                if(b.get(x).x == n.pair.x && b.get(x).y == n.pair.y && b.get(x).vertical == false){
                    flag = false;
                    break;
                }
            }
            if(flag){
               returnList.add(findNode(n.pair.x,n.pair.y-1)); 
            }
        }
        
        //Check bottom if it exists
        flag = true;
        if(n.pair.y+1<size){
            for(int x=0; x<b.size(); x++){
                if(b.get(x).x == n.pair.x && b.get(x).y == n.pair.y+1 && b.get(x).vertical == false){
                    flag = false;
                    break;
                }
            }
            if(flag){
                returnList.add(findNode(n.pair.x,n.pair.y+1));
            }
        }
        return returnList;
    }
    
    /*
     * @param x,y coordinate of the node
     * @return returns the node with the given x and y or null if no node exists
     */
    private Node findNode(int x, int y){
        Node tempNode;
        for(int z=0; z<nodes.size(); z++){
            tempNode = nodes.get(z);
            if(tempNode.pair.x == x && tempNode.pair.y == y){
                return tempNode;
            }
        }
        return null;
    }

    /*
     * The main recursive method, recursivly visits each adjacent node that has not been visited.
     * @param Node n, the node that we are visiting
     * @return true when the node is on the given path to solve the maze
     */
    private boolean visit(Node n) {
        List<Node> adjacent = getAdjacent(n);
        n.visited = true;
        
        if(endOfMaze(n)){
            returnPair.add(n.pair);
            return true;
        }
        
        for(int x=0; x<adjacent.size(); x++){
            if(!adjacent.get(x).visited){
                if(visit(adjacent.get(x))){
                    returnPair.add(n.pair);
                    return true;
                }
            }
        }
        return  false;
    }

    /*
     * @param the node to see if it is the end of the maze
     * @return returns true if the node is the end of the maze, where x and y are equal to the size
     */
    private boolean endOfMaze(Node n) {
        if(n.pair.x == size-1 && n.pair.y == size-1){
            return true;
        }
        return false;
    }
    
    /*
     * @return returns the maze as a string.
     */
    @Override
    public String toString(){
        String s = "";
        boolean flag = true;
        for(int x=0; x<size; x++){
            //Print out all the horizontal barriers
            if(x!=0){
                for(int y=0; y<size; y++){
                    flag = true;
                    for(int z=0; z<b.size(); z++){
                        if(b.get(z).x == y && b.get(z).y == x && b.get(z).vertical == false){
                            s = s+" - ";
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        s = s+"   ";
                    }
                }
                //Print newline
                 s = s+System.getProperty("line.separator");
            }
         
            //Print out all the nodes and barriers
            for(int y=0; y<size; y++){
                flag = true;
                for(int z=0; z<b.size(); z++){
                    if(b.get(z).x == y && b.get(z).y == x && b.get(z).vertical == true){
                        s = s+"|";
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    s = s+" ";
                }
                s = s+"+ ";
            }
            
            //new line
            s = s+System.getProperty("line.separator");
        }
        return s;
    }
    /*
     * Inner node class
     * A node contains a pair and a value if the node has been visited
     * @param x,y the X,Y coordinate of the pair to be represented
     */
    private class Node{
        boolean visited;
        Pair pair;
        
        private Node(int x,int y){
            pair = new Pair(x,y);
        }
        
    }
}
