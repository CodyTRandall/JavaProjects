package sjsu.cs146.bottomUpTwoThreeFourTree;

import java.util.ArrayList;

public class BottomUpTwoThreeFourTree {

	public Node root = new Node();
	private ArrayList<Integer> intList= new ArrayList<Integer>();
	
	public BottomUpTwoThreeFourTree (){		
	}
	
	public void insert(int x){	
		if(!checkIfExists(x)){
			root.add(x, false);
		}
	}

	public String search(int x){
		return root.search(x);
	}
	public String getFirst(){
		return root.childNodes[0].getFirst();
	}
	private boolean checkIfExists(int x){
		for(int count=0; count<intList.size(); count++){
			if(intList.get(count) == x){
				return true;
			}
		}
		intList.add(x);
		return false;
	}
	
	/*
	 * inner class node that handles the workings of each node and contains the data
	 */
	private class Node{
		private Integer[] values = new Integer[3];
		public Node[] childNodes = new Node[4];

		/*
		 * constructor to create an empty node
		 */
		public Node(){
		}
	
		/*
		 * constructor to create a node with an intial value
		 */
		public Node(int x){
			values[0] = x;
		}
		
		public String getFirst(){
			return ""+values[1];
		}
		
		public int calculateChild(){
			if(childNodes[0] == null){
				return 0;
			}
			if(childNodes[1] == null){
				return 1;
			}
			if(childNodes[2] == null){
				return 2;
			}
			if(childNodes[3] == null){
				return 3;
			}
			return 4;
		}
		public int calculateSize(){
			if(values[0] == null){
				return 0;
			}
			if(values[1] == null){
				return 1;
			}
			if(values[2] == null){
				return 2;
			}
			return 3;
		}
		public boolean add(int x, boolean o){
				//If this isn't a leaf then keep going
				if(calculateChild()>0 && !o){
					//find which node to go to
					for(int count=0; count<calculateSize(); count++){
						if(x<values[count]){
							//make sure the child node exists
							if(childNodes[count] != null){
								childNodes[count].add(x, false);
								break;
							}
						}
						//If this is the last digit then add to last child
						if(count+1 == calculateSize()){
							if(childNodes[count+1] != null){
								childNodes[count+1].add(x, false);
							}
						}
					}
					return true;
				}
				//If this array has reached its max size then break it apart
				if(calculateSize() == 3){
					//Get the middle and put it up, then take the middle and have this be the
					//left tree and take the right and make it be a new child
					int middle = values[1];
					int right = values[2];
					values[1] = null;
					values[2] = null;
					
					//Create the new right child
					Node newRightNode = new Node(right);
					if(childNodes[2] != null){
						newRightNode.childNodes[0] = childNodes[2];
					}
					if(childNodes[3] != null){
						newRightNode.childNodes[1] = childNodes[3];
					}

					//Check if this is the root, if it is then create
					//a new root node if not then add to the above
					if(BottomUpTwoThreeFourTree.this.root != this){
						//sigh, need to try and add to the one above this
						//last.add(x, this, true);
					}else{
						Node newMiddleNode = new Node(middle);
						newMiddleNode.childNodes[0] = this;
						newMiddleNode.childNodes[1] = newRightNode;
						BottomUpTwoThreeFourTree.this.root = newMiddleNode;
						newMiddleNode.add(x, false);
					}
					return true;

				}
				//Add the element to the first empty slot
				values[calculateSize()] = x;
			
				//Sort the array
				sort();
				return true;
			}
		
		public void sort(){

			Integer placeholder = null;
			Integer location = null;

			for(int count=0; count<calculateSize(); count++){
				if(placeholder == null){
					placeholder = values[0];
					location = count;
				}else{
					if(placeholder > values[count]){
						placeholder = values[count];
						location = count;
					}
				}
			}
			
			values[location] = values[0];
			values[0] = placeholder;
			
			if(calculateSize() > 2){
				if(values[1] > values[2]){
					placeholder = values[1];
					values[1] = values[2];
					values[2] = placeholder;
				}
			}
		}
		
		public String search(int x){
			for(int count=0; count<calculateSize(); count++){
				if(values[count] == x){
					return printString();
				}
				if(values[count] > x){
					if(childNodes[count] == null){
						return "none";
					}
					return childNodes[count].search(x);
				}
			}
			if(childNodes[calculateSize()] == null){
				return "none";
			}
			return childNodes[calculateSize()].search(x);
		}
		
		public String printString(){
			String str = "";
			for(int count=0; count<calculateSize(); count++){
				if(count != 0){
					str += " ";
				}
				str += values[count];
			}
			return str;
		}
	}

}
	
