package sjsu.cs146.taskSet;
import java.util.ArrayList;

/***********
 * Class to sort tasks
 * @author Cody
 * @version 1
 */
public class TaskSet{
	ArrayList<Vertex> v = new ArrayList<Vertex>();

	/**
	 * Creates an empty task
	 */
	public TaskSet()
	{
	}
	
	/**
	 * Adds a task to the taskset
	 * @param the time it takes to complete the task
	 */
	public void addTask(int x)
	{
		v.add(new Vertex(x));
	}
	
	/**
	 * Adds a task constraint
	 * @param i the first
	 * @param k the second
	 */
	public void addTaskConstraint(int i,int k)
	{
		v.get(k).addEdge(k, i);
		v.get(i).addBackEdge(k, i);
	}
	
	/**
	 * Returns the min completion time
	 * @return returns the min completion time
	 */
	public int minCompletionTime()
	{
		int t = 0;
		int temp = 0;
		for(int x=0; x<v.size(); x++)
		{
			temp = getStartTime(x);
			if(temp == -1)
			{
				return -1;
			}
			temp += v.get(x).time;
			if(temp > t)
			{
				t = temp;
			}
		}
		return t;
		
	}
	
	/**
	 * Returns the start time
	 * @param i the node to return
	 * @return the start time of node i
	 */
	public int getStartTime(int i)
	{
		int returnT;
		try
		{
			returnT = getStartTime(v.get(i), -(v.get(i).time));
		}
		catch(StackOverflowError e)
		{
			returnT = -1;
		}
		return returnT;
			
	}
	
	/**
	 * returns the start time, internal recursive methond
	 * @param i the vertex
	 * @param t the current time
	 * @return returns the nodes start time
	 */
	public int getStartTime(Vertex i, int t){
		t += i.time;
		int tempT = t;
		int tempT2 = 0;
		for(int x=0; x<i.b.size(); x++){
			tempT2 = getStartTime(v.get(i.b.get(x).i), t);
			if(tempT2 > tempT){
				tempT = tempT2;
			}
		}
		return tempT;
	}
	
	/**
	 * Internal vertex class
	 * @author Cody
	 *
	 */
	public class Vertex
	{
		int time = 0;
		int n = 0;
		ArrayList<Edge> e = new ArrayList<Edge>();
		ArrayList<Edge> b = new ArrayList<Edge>();
		
		/**
		 * 
		 * @param time
		 */
		public Vertex(int time)
		{
			this.time = time;
		}
		
		/**
		 * 
		 * @param i
		 * @param d
		 */
		public void addEdge(int i,int d)
		{
			e.add(new Edge(i,d));
		}
		
		/**
		 * 
		 * @param i
		 * @param d
		 */
		public void addBackEdge(int i, int d)
		{
			b.add(new Edge(i,d));
		}
	}
	
	/**
	 * 
	 * @author Cody
	 *
	 */
	public class Edge
	{
		int i;
		int d;
		
		/**
		 * 
		 * @param i
		 * @param d
		 */
		public Edge(int i, int d)
		{
			this.i = i;
			this.d = d;
		}
	}
	

}