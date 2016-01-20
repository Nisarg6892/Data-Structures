package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

public class Tree_Max_Sum_to_Root {
	
	int data;
	int maxSum = -100000;
	static Tree_Max_Sum_to_Root maxLeaf;
	int sum = 0;
	ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
	
	Tree_Max_Sum_to_Root leftChild;
	Tree_Max_Sum_to_Root rightChild;
	
	Tree_Max_Sum_to_Root(){
		// Constructor
	}
	
	Tree_Max_Sum_to_Root(int data){
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	public int maxSum(Tree_Max_Sum_to_Root node, int sum){
		if(node == null){
			return 0; // Base Case
		}
		sum = sum + node.data;
		if(sum > maxSum && node.leftChild == null && node.rightChild == null){
			System.out.println("Sum = "+sum);
			maxSum = sum;
			maxLeaf = node;
		}
		
		System.out.println(node.data);
		maxSum(node.leftChild, sum);
		maxSum(node.rightChild, sum);
		return maxSum;
	}
	
	public boolean findPath(Tree_Max_Sum_to_Root root, Tree_Max_Sum_to_Root node){
		if(root == null){
			return false;
		}
		if(root == node || findPath(root.leftChild, node) || findPath(root.rightChild, node)){
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	
	public void findLevel(Tree_Max_Sum_to_Root node, int level){
		if(node == null){
			return;
		}
		level = level + 1;
		System.out.println(node.data+" : Level "+level);
		a.get(level-1).add(level-1, new Integer(node.data));
		findLevel(node.leftChild, level);
		findLevel(node.rightChild, level);
		
//		return 0;
	}
	
	public static void main(String s[]){
		Tree_Max_Sum_to_Root root = new Tree_Max_Sum_to_Root(1);
		root.leftChild = new Tree_Max_Sum_to_Root(2);
		root.rightChild = new Tree_Max_Sum_to_Root(3);
		root.leftChild.leftChild = new Tree_Max_Sum_to_Root(4);
		root.leftChild.rightChild = new Tree_Max_Sum_to_Root(5);
		root.rightChild.leftChild = new Tree_Max_Sum_to_Root(6);
		root.rightChild.rightChild = new Tree_Max_Sum_to_Root(9);
//		root.rightChild.rightChild.rightChild = new Tree_Max_Sum_to_Root(56);
		
		Tree_Max_Sum_to_Root t = new Tree_Max_Sum_to_Root();
//		int maxSum = t.maxSum(root, 0);
//		System.out.println("Maximum Sum = "+maxSum);
		
		t.findLevel(root, 0);
		
//		t.findPath(root, maxLeaf);
	}
}
