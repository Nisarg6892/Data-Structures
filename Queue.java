package practice;

import java.util.Arrays;

public class Queue {
	
	private int queueSize;
	private String queueArray[];
	private int front = 0 , rear = -1, numberOfItems = 0;
	
	public Queue(int size){
		queueSize = size;
		queueArray = new String[queueSize];
		Arrays.fill(queueArray, "-1");
	}
	
	public void insert(String str){
		if(rear < queueSize-1){
			rear = rear + 1;
			queueArray[rear] = str;
			System.out.println(str+" is added to queue.");
			displayTheQueue();
		}else{
			System.out.println("Queue is Full");
		}
	}
	
	public void remove(){
		if(rear < 0){
			System.out.println("Queue is Empty.");
		}else{
			System.out.println(queueArray[front]+" is removed.");
			for(int i = 0; i < rear; ++i){
				queueArray[i] = queueArray[i+1]; 
			}
			rear = rear - 1;
			displayTheQueue();
		}
	}
	
	public String peek(){
		return queueArray[front];
	}
	
	public void priorityInsert(String str){
		if(rear == -1){
			insert(str);
		}else{
			if(rear < queueSize-1){
				int i;
				for(i=rear; i>= front; --i){
					if(Integer.parseInt(queueArray[i]) <= Integer.parseInt(str)){
						queueArray[i+1] = queueArray[i];
					}else{
						break;
					}
				}
				queueArray[i+1] = str;
				rear = rear + 1;
				displayTheQueue();
			}else{
				System.out.println("Queue is Full.");
			}
		}
	}
	
	public void displayTheQueue(){
		System.out.println("<-----Queue----->");
		for(int i=0; i<= rear; ++i){
			System.out.print(queueArray[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String s[]){
		Queue queue = new Queue(10);
		
		// Normal Insert
//		queue.insert("13");
//		queue.insert("23");
//		queue.insert("44");
//		queue.insert("4");
//		queue.insert("99");
		
		// Priority Insert
		queue.priorityInsert("13");
		queue.priorityInsert("23");
		queue.priorityInsert("44");
		queue.priorityInsert("4");
		queue.priorityInsert("99");
		
		queue.remove();
		queue.remove();
		
		String peekElement = queue.peek();
		System.out.println(peekElement);
	}
}