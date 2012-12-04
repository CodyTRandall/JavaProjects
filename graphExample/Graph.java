package sjsu.cs146.graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Graph {
	ArrayList<Vertex> v = new ArrayList<Vertex>();

	public Graph(int verticies){
		for(int x=0; x<verticies; x++){
			v.add(new Vertex());
		}
	}
	
	public void addEdge(int source, int destination, int weight){
		v.get(source).o.add(new Edge(source,destination,weight));
		v.get(destination).i.add(new Edge(source,destination,weight));
	}
	
	public ArrayList<String> getOutgoingGraphRepresentation(){
		ArrayList<String> returnList = new ArrayList<String>();
		String str = "";
		Boolean flag = false;
		for(int x=0; x<v.size(); x++){
			Collections.sort(v.get(x).o, new dComparator());
			flag = false;
			str = "";	
			for(int y=0; y<v.get(x).o.size(); y++){
				if(flag){
					str += " ";
				}
				str += v.get(x).o.get(y).d+" "+v.get(x).o.get(y).w;
				flag = true;
			}
			returnList.add(str);
		}
		return returnList;
	}
	
	public ArrayList<String> getIncomingGraphRepresentation(){
		ArrayList<String> returnList = new ArrayList<String>();
		String str = "";
		Boolean flag = false;
		for(int x=0; x<v.size(); x++){
			Collections.sort(v.get(x).i, new iComparator());
			flag = false;
			str = "";
			for(int y=0; y<v.get(x).i.size(); y++){
				if(flag){
					str += " ";
				}
				str += v.get(x).i.get(y).s+" "+v.get(x).i.get(y).w;
				flag = true;
			}
			returnList.add(str);
		}
		return returnList;
	}
	
	public boolean hasEdge(int source, int destination){
		Vertex vertex = v.get(source);
		for(int x=0; x<vertex.o.size(); x++){
			if(vertex.o.get(x).d == destination){
				return true;
			}
		}
		
		return false;
	}
	
	public int getEdgeWeight(int source, int destination){
		Vertex vertex = v.get(source);
		for(int x=0; x<vertex.o.size(); x++){
			if(vertex.o.get(x).d == destination){
				return vertex.o.get(x).w;
			}
		}
		return 0;
	}
	
	public int inDegree(int vertexIndex){
		return v.get(vertexIndex).i.size();
	}
	
	public int outDegree(int vertexIndex){
		return v.get(vertexIndex).o.size();
	}
	
	class Vertex{
		ArrayList<Edge> o = new ArrayList<Edge>();
		ArrayList<Edge> i = new ArrayList<Edge>();
		

	}
	class Edge{
		int s,d,w;
		
		public Edge(int source, int destination, int weight){
			this.s = source;
			this.d = destination;
			this.w = weight;
		}
		
	}

	class dComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge arg0, Edge arg1) {
			if(arg0.d < arg1.d){
				return -1;
			}
			if(arg0.d > arg1.d){
				return 1;
			}
			return 0;
			
		}
	}
	
	class iComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge arg0, Edge arg1) {
			if(arg0.s < arg1.s){
				return -1;
			}
			if(arg0.s > arg1.s){
				return 1;
			}
			return 0;
			
		}
	}
	
}
