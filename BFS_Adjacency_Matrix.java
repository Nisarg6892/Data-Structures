package practice;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.LinkedList;

public class BFS_Adjacency_Matrix {
	
	Queue<Integer> queue;
	
	public BFS_Adjacency_Matrix(){
		queue = new LinkedList<Integer>(); 
	}
	
	public void bfsMethod(int[][] matrix, int source){
		int nodes_connected_to_source = matrix[source].length-1;
		int visited[] = new int[nodes_connected_to_source+1];
		int element;
		
		queue.add(source);
		visited[source] = 1;
		
		while(!queue.isEmpty()){
			element = queue.remove();
			System.out.println(element);
			for(int j=1; j<visited.length; ++j){
				if (matrix[element][j]==1 && visited[j]==0){
					queue.add(j);
					visited[j] = 1;
				}
			}
		}
	}
	
	public static void main(String s[]){
		int n, source;
		Scanner s1 = null;
		
		try{
			System.out.println("How many Nodes ?:");
			s1 = new Scanner(System.in);
			n = s1.nextInt();
			
			int adjacencyMatrix[][] = new int[n+1][n+1];
			for(int i=1; i<=n; ++i){
				for(int j=1; j<=n; ++j){
					adjacencyMatrix[i][j] = s1.nextInt();
				}
			}
			
			System.out.println("Enter the Source:");
			source = s1.nextInt();
			
			BFS_Adjacency_Matrix bfs = new BFS_Adjacency_Matrix();
			bfs.bfsMethod(adjacencyMatrix, source);
			
		}
		catch(InputMismatchException inputMismatch){
			System.out.println("Wrong Input Format");
		}
		s1.close();
	}
}
