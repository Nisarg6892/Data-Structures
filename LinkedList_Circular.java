package practice;

class Link_Circular{
	int data;
	
	Link_Circular next;
	
	public Link_Circular(int data){
		this.data = data;
		next = null;
	}
	
	public String toString(){
		return data+"";
	}
}

public class LinkedList_Circular {
	
	Link_Circular firstLink;
	
	Link_Circular slow;
	Link_Circular fast;
	
	public Link_Circular findNodeAtBeginningOfLoop(Link_Circular link){
		slow = firstLink;
		fast = firstLink;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				System.out.println("");
				break;
			}
		}
		
		if(fast == null || fast.next == null){
			return null;
		}
		
		slow = firstLink;
		
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast; 
	}
	
	public static void main(String s[]){
		Link_Circular firstLink = new Link_Circular(12);
		firstLink.next = new Link_Circular(13);
		firstLink.next.next = new Link_Circular(14);
		firstLink.next.next.next = new Link_Circular(15);
		firstLink.next.next.next.next = new Link_Circular(16);
		firstLink.next.next.next.next.next = new Link_Circular(14);
		
		LinkedList_Circular circularLink = new LinkedList_Circular();
		Link_Circular l = circularLink.findNodeAtBeginningOfLoop(firstLink);
		System.out.println(l);
	}
}
