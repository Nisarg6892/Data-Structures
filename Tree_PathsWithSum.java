package practice;

class Node_Path{
	int data;
	
	Node_Path left;
	Node_Path right;
	
	public Node_Path(int data){
		this.data = data;
		left = null;
		right = null;
	}
	
	public String toString(){
		return data+"";
	}
}

public class Tree_PathsWithSum {
	
	private static int count = 0;
	
	public void findNode(Node_Path node, int targetSum){
		if(node == null){
			return;
		}
		
		findPath(node, 0, targetSum);
		
		findNode(node.left, targetSum);
		findNode(node.right, targetSum);
	}
	
	public void findPath(Node_Path node, int currentSum, int targetSum){
		if(node == null){
			return;
		}
		currentSum = currentSum + node.data;
		
		if(currentSum == targetSum){
			++count;
		}
		findPath(node.left, currentSum, targetSum);
		findPath(node.right, currentSum, targetSum);
	}
	
	public static void main(String s[]){
		Node_Path root = new Node_Path(10);
		
		root.left = new Node_Path(5);
		root.right = new Node_Path(-3);
		
		root.left.left = new Node_Path(3);
		root.left.right = new Node_Path(2);
		
		root.left.left.left = new Node_Path(3);
		root.left.left.right = new Node_Path(-2);
		
		root.left.right.right = new Node_Path(1);
		
		root.right.right = new Node_Path(11);
		
		Tree_PathsWithSum treePath = new Tree_PathsWithSum();
		treePath.findNode(root, 8);
		
		System.out.println(count);
	}
}
