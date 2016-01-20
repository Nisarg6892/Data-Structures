package practice;

import java.util.Scanner;
import java.util.Arrays;

public class String_Unique_Characters {
	
	private Scanner scanner;
	private String ss;
	private boolean b[];
	private int unique = 1;
	
	public void takeStringFromUser(){
		scanner = new Scanner(System.in);
		System.out.println("Enter the String :");
		ss = scanner.nextLine();
	}
	
	public int isUniqueString(){
		b = new boolean[128];
		Arrays.fill(b, false);
		
		for(int i = 0; i < ss.length(); ++i){
			if(b[ss.charAt(i)] == true){
				unique = 0;
				break;
			}
			b[ss.charAt(i)] = true;
		}
		
		if(unique == 0){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static void main(String s[]){
		
		String_Unique_Characters suc = new String_Unique_Characters();
		suc.takeStringFromUser();
		int result = suc.isUniqueString();
		if(result == 0){
			System.out.println("String Not Unique");
		}else{
			System.out.println("String Unique");
		}
		
	}
}
