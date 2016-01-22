// With Buffer

private boolean b[];
private Node next;
private Node temp;

public Node removeDuplicates(Node head){
	temp = head;
	b = new boolean[128];

	while(head != null){
		if(b[head.next.data] == true){
			head.next = head.next.next;
		} else{
			b[head.next.data] = true;	
		}
		head = head.next;
	}
	return temp;
}

// Buffer Not Allowed

private Node next;
private Node temp;

private Node current;
private Node runner;

public NodeR removeDuplicates(NodeR head){
		temp = head;
		current = head;


		while(current != null){
			runner = current;
			while(runner.next != null){
				if(current.data == runner.next.data){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
				
			}
			current = current.next;
		}

		return temp;
	}