package practice;

class Node{
	String name;
	int id;
	
	Node leftChild;
	Node rightChild;
	
	Node(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public String toString(){
		return name+" has "+id;
	}
}

public class Tree {
	
	Node root;
	
	public void addNode(String name, int id){
		
		Node newNode = new Node(name, id);
		
		if(root == null){
			root = newNode;
		}
		else{
			Node focusNode = root;
			Node parent;
			
			while(true){
				parent = focusNode;
				if(id < focusNode.id){
					focusNode = focusNode.leftChild;
					
					if(focusNode == null){
						parent.leftChild = newNode;
//						focusNode = newNode;
						System.out.println("entered left");
						return;
					}
				}
				else{
					focusNode = focusNode.rightChild;
					
					if(focusNode == null){
						parent.rightChild = newNode;
//						focusNode = newNode;
						System.out.println("entered right");
						return;
					}
				}
			}
		}
	}
	
//	public void removeElement(int id){
//		if(id == root.id){
//			root.rightChild.leftChild = root.leftChild;
//			root = root.rightChild;
//		}
//	}
	
	public void traverseInOrder(Node node){
		
		if(node != null){
			traverseInOrder(node.leftChild);
			System.out.println(node);
			traverseInOrder(node.rightChild);
		}
	}
	
	public void traversePreOrder(Node node){
			
			if(node != null){
				System.out.println(node);
				traversePreOrder(node.leftChild);
				traversePreOrder(node.rightChild);
			}
		}

	public void traversePostOrder(Node node){
		
		if(node != null){
			traversePostOrder(node.leftChild);
			traversePostOrder(node.rightChild);
			System.out.println(node);
		}
	}
	
	public boolean checkBST(Node n){
		return checkBST(n, null, null);
	}
	
	public boolean checkBST(Node n, Integer min, Integer max){
		if(n==null){
			return true;
		}
		if((min!=null && n.id <= min) || (max!=null && n.id > max))
		{
			return false;
		}
		if(!checkBST(n.leftChild, min, n.id) || !checkBST(n.rightChild, n.id, max)){
			return false;
		}
		return true;
	}
	
	public int getHeight(Node root){
		if(root==null){
			return 0;
		}
		return Math.max(getHeight(root.leftChild), getHeight(root.rightChild))+1;//Recursion
	}
	
	public boolean isBalanced(Node root){
		if(root==null){//Base Case
			return true;
		}
		int heightDifference = getHeight(root.leftChild) - getHeight(root.rightChild);
		
		if(Math.abs(heightDifference) > 1){
			return false;
		}else{//Recursion
			return isBalanced(root.leftChild) && isBalanced(root.rightChild);
		}
	}
	
	public static void main(String s[]){
		Tree t = new Tree();
		
		t.addNode("hi",20);
		t.addNode("hie",10);
		t.addNode("hey",30);
		t.addNode("heya",5);
		t.addNode("huii",15);
		t.addNode("hello",3);
		t.addNode("hello",7);
		t.addNode("hello",17);
	
		t.traverseInOrder(t.root);
		t.traversePreOrder(t.root);
		t.traversePostOrder(t.root);
		
//		t.removeElement(50);
		System.out.println("------------------");
//		t.traverseInOrder(t.root);
		
		boolean b = t.checkBST(t.root);
		System.out.println(b);
		boolean bal = t.isBalanced(t.root);
		System.out.println(bal);
	}
}
