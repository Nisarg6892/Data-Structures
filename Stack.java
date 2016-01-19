package practice;

import java.util.Arrays;

public class Stack {
	
	private int stackSize;
	private String stackArray[];
	private int topOfStack = -1;
	
	public Stack(int size){
		stackSize = size;
		stackArray = new String[stackSize];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String str){
		
		if(topOfStack < stackSize - 1){
			topOfStack = topOfStack + 1;
			stackArray[topOfStack] = str;
			System.out.println(str+" has been added to Stack.");
		}else{
			System.out.println("Stack Overflow.");
		}
		displayTheStack();
	}
	
	public String pop(){
		if(topOfStack > -1){
			System.out.println(stackArray[topOfStack]+" has been popped.");
			String temp = stackArray[topOfStack];
			stackArray[topOfStack] = "-1";
			topOfStack = topOfStack - 1;
			displayTheStack();
			return temp;
		}else{
			System.out.println("Stack UnderFlow.");
			return "-1";
		}
	}
	
	public String peek(){
		return stackArray[topOfStack];
	}
	
	public void pushMany(String multipleStrings){
		String multiple[] = multipleStrings.split(" ");
		for(int i = 0; i < multiple.length; ++i){
			push(multiple[i]);
		}
	}
	
	public void popAll(){
		while(topOfStack >= 0){
			pop();
		}
	}
	
	public void displayTheStack(){
		System.out.println("<-------Stack------->");
		for(int i=topOfStack; i >= 0; --i){
			System.out.println(stackArray[i]);
		}
	}
	
	public static void main(String s[]){
		
		Stack stack = new Stack(10);
		
		stack.push("34");
		stack.push("hello");
		stack.push("66");
		stack.push("please");
		stack.push("09");
		
		String pop_String = stack.pop();
		System.out.println("POP "+pop_String);
		
		String peek_String = stack.peek();
		System.out.println("PEEK "+peek_String);
		
		stack.pushMany("11 22 33 77 88");
		stack.popAll();
	}
}
