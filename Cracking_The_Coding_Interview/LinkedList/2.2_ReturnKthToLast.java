// Recursive
private int number;
private int count = 0;
private int answer;

public int returnKthToLast(Node head, int k){
	number = k;
	return returnKthToLast(head);
}

public int returnKthToLast(Node head){
	if(head == null){
		return 0;
	}

	returnKthToLast(head.next);
	count = count + 1;
	if(count == number){
		answer = head.data;
	}
	return answer;
}

// Itertive

NodeR first;
NodeR second;

public int returnKthToLast(Node head, int k){

	first = head;
	second = head;
	number = k;
	int count = 0;
	while(count < k){
		second = second.next;
		count++;
	}

	while(second != null){
		second = second.next;
		first = first.next;
	}

	System.out.println(second.next.data);
}

