package practice;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DFS_Adjacency_List {
	
	private Map<Integer, List<Integer>> Adjacency_List;
	private Stack<Integer> stack;
	
	public DFS_Adjacency_List(int no_of_vertices){
		Adjacency_List = new HashMap<Integer, List<Integer>>();
		for(int i=1; i<= no_of_vertices; ++i){
			Adjacency_List.put(i, new LinkedList<Integer>());
		}
	}
	
	public void setEdge(int source, int destination){
		List<Integer> slist = Adjacency_List.get(source);
		slist.add(destination);
//		List<Integer> dlist = Adjacency_List.get(destination);
//		dlist.add(source);
	}
	
	public List<Integer> getEdge(int source){
		return Adjacency_List.get(source);
	}
	
	public void dfs(List<Integer>[] l, int start){
		
//		for(int i=0; i<l.length; ++i){
//			for(int j=0; j<l[i].size(); ++j){
//				System.out.print(l[i].get(j)+"\t");
//			}
//			System.out.println();
//		}
		
		stack = new Stack<Integer>();
		int number_of_nodes = l.length-1;
		System.out.println(number_of_nodes+"fd");
		int visited[] = new int[number_of_nodes+1];
		int source = start;
		int destination = start;
		System.out.print(source+"\t");
		visited[start] = 1;
		stack.push(start);
		
		while(!stack.isEmpty()){
			source = stack.peek();
			destination = 1;
			System.out.println(number_of_nodes+"n");
			while(destination <= number_of_nodes){
				if(l[source-1].contains(destination) && visited[destination] != 1){
					stack.push(destination);
					visited[destination] = 1;
					source = destination;
					destination = 1;
					System.out.print(source+"\t");
					continue;
				}
//				else{
				destination++;
//				}
			}
			
			stack.pop();
		}
	}
	
	public static void main(String s[]){
		int no_of_vertices;
		int no_of_edges;
		int source, destination;
		int count = 0;
		List<Integer> array[];
		
		Scanner s1 = new Scanner(System.in);
		try{
			System.out.println("Enter Number of Vertices and Edges:");
			no_of_vertices = s1.nextInt();
			array = (List<Integer>[]) new List[no_of_vertices+1];
			System.out.println(array.length+"length");
			no_of_edges = s1.nextInt();
			DFS_Adjacency_List al = new DFS_Adjacency_List(no_of_vertices);
			
			System.out.println("Enter the Edges in graph format : <Source index> <Destination index>");
			
			while(count < no_of_edges){
				source = s1.nextInt();
				destination = s1.nextInt();
				al.setEdge(source, destination);
				++count;
			}
			
//			System.out.println("The Adjacency List for Graph :");
//			
//			for(int i=1; i<=no_of_vertices; ++i){
//				System.out.print(i+"->");
//				List<Integer> theList = al.getEdge(i);
//				for(int j=0; j<theList.size(); ++j){
//					System.out.print(theList.get(j)+" ");
//				}
//				System.out.println();
//			}
			
			int i=0;
			while(i < no_of_vertices){
				array[i] = al.getEdge(i+1);
				System.out.println(array[i]+" rrrr");
				++i;
			}
			int start = 3;
			al.dfs(array, start);
		}
		catch(InputMismatchException inputMismatch){
			System.out.println("Error in Input Format.");
		}
	}
}
