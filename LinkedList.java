package practice;

class Node{
	int data;
	Node next;

	public Node(int data){
		this.data = data;
		next = null;
	}

	public String toString(){
		return data+"";
	}
}

public class LinkedList{

	private static Node head;
	private Node tail;
	private Node newNode;
	private int count = 0;
	private int countForReverse = 0;

	// Constructor
	public LinkedList(){
		head = null;
	}

	// Insert at Beginning Position
	public void insertAtFirstPosition(int value){
		newNode = new Node(value);
		if(head == null){
			head = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
	}

	// For Double Ended LinkdeList
	public void insertAtLastPosition(int value){
		newNode = new Node(value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.next = newNode;
			tail = newNode;
		}
	}

	public Node removeFirstElement(){
		if(!isEmpty()){
			head = head.next;
			return head;
		} else {
			System.out.println("LinkedList is Empty.");
			return null;
		}
	}

	public void removeLastElement(){
		if(!isEmpty()){
			newNode = head;
			// If Only One Element
			if(head.next == null){
				head = null;
			} else { //More than One Element
				while(newNode.next.next != null){
				newNode = newNode.next;
				}
			newNode.next = null;
			}	
		} else {
			System.out.println("LinkedList is Empty.");
		}
	}

	public void removeByIndex(int index){
		newNode = head;
		if(!isEmpty()){
			while(true){
				// Zeroth Index (First Element)
				if(index == 0){
					head = head.next;
					break;
				}
				if(count == index - 1){
					newNode.next = newNode.next.next;
					break;
				}
				newNode = newNode.next;
				++count;
			}
		} else {
			System.out.println("LinkedList is Empty.");
		}
	}

	public Node reverse(Node head){
		if(head.next == null){
			return head;
		}
		
		Node secondElement = head.next;
		head.next = null;
		
		Node last = reverse(secondElement);
		secondElement.next = head;
		return last;
	}

	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}

	public void traverse(Node head){
		newNode = head;
		while(newNode != null){
			System.out.println(newNode.data);
			newNode = newNode.next;
		}
	}

	public static void main(String s[]){
		LinkedList linkedList = new LinkedList();
		
		linkedList.insertAtFirstPosition(45);
		linkedList.insertAtFirstPosition(4);
		linkedList.insertAtFirstPosition(324);
		linkedList.insertAtFirstPosition(97);
		linkedList.insertAtFirstPosition(1);

		// linkedList.insertAtLastPosition(45);
		// linkedList.insertAtLastPosition(4);
		// linkedList.insertAtLastPosition(324);
		// linkedList.insertAtLastPosition(97);
		// linkedList.insertAtLastPosition(1);

		linkedList.traverse(head);
		System.out.println("-----");
//		linkedList.removeFirstElement();
//		linkedList.removeLastElement();
//		linkedList.removeByIndex(2);
		System.out.println("-----");
		Node h =  linkedList.reverse(head);
		linkedList.traverse(h);
	}
}