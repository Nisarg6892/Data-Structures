package practice;

import java.util.Scanner;

public class Strings_Check_Permutation {
	
	private Scanner scanner;
	private static String first;
	private static String second;
	private int c[];
	
	public void takeTwoStringsFromUser(){
		scanner = new Scanner(System.in);
		
		System.out.println("Enter First String");
		first = scanner.nextLine();
		
		System.out.println("Enter Second String");
		second = scanner.nextLine();
	}
	
	public boolean checkPermutation(String first, String second){
		if(first.length() != second.length()){
			return false;
		}
		c = new int[128];
		for(int i = 0; i < first.length(); ++i){
			c[(int)first.charAt(i)]++;
		}
		
		for(int i = 0; i < second.length(); ++i){
			c[(int)second.charAt(i)]--;
			if(c[(int)second.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String s[]){
		Strings_Check_Permutation scp = new Strings_Check_Permutation();
		scp.takeTwoStringsFromUser();
		boolean result = scp.checkPermutation(first, second);
		System.out.println(result);
	}
}
