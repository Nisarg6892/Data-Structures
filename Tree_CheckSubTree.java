package practice;

class Node_Check{
	int data;
	
	Node_Check left;
	Node_Check right;
	
	public Node_Check(int data){
		this.data = data;
	}
	
	public String toString(){
		return data+"";
	}
}

public class Tree_CheckSubTree {
	
	static Node_Check root1;
	static Node_Check root2;
	boolean result;
	
	public boolean containsTree(Node_Check root1, Node_Check root2){
		if(root2 == null){
			return true;
		}
		return checkNode(root1, root2);
	}
	
	public boolean checkNode(Node_Check root1, Node_Check root2){
		if(root1 == null){
			return false;
		}
		else if(root1.data == root2.data){
			result = checkSubTree(root1, root2);
			if(result == true){
				return true;
			}
		}
		return checkNode(root1.left, root2) || checkNode(root1.right, root2);
	}
	
	public boolean checkSubTree(Node_Check root1, Node_Check root2){
		if(root1 == null && root2 == null){
			return true;
		}
		else if(root1 == null || root2 == null){
			return false;
		}
		else if(root1.data != root2.data){
			return false;
		}
		else{
			return checkSubTree(root1.left, root2.left) && checkSubTree(root1.right, root2.right);
		}
	}
	
	public static void main(String s[]){
		
		Tree_CheckSubTree tcs = new Tree_CheckSubTree();
		
//		First Tree
		root1 = new Node_Check(20);
		
		root1.left = new Node_Check(8);
		root1.right = new Node_Check(22);
		
		root1.left.left = new Node_Check(4);
		root1.left.right = new Node_Check(12);
		
		root1.left.right.left = new Node_Check(10);
		root1.left.right.right = new Node_Check(14);
		
//		Second Tree
		root2 = new Node_Check(12);
		
		root2.left = new Node_Check(10);
		root2.right = new Node_Check(14);
		
		boolean result = tcs.containsTree(root1, root2);
		System.out.println(result);
		
	}
}
