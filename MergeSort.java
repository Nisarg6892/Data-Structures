package practice;

public class MergeSort {
	
	public void mergeSort(int[] a){
		int helper[] = new int[a.length];
		mergeSort(a, helper, 0, a.length-1);
	}
	
	public void mergeSort(int[] a, int[] helper, int left, int right){
		if(left < right){
			int middle = (left + right)/2;
			mergeSort(a, helper, left, middle); // Sort Left Half
			mergeSort(a, helper, middle+1, right); // Sort Right Half
			merge(a, helper, left, middle, right); // Merge Them
		}
	}
	
	public void merge(int[] a, int[] helper, int left, int middle, int right){
		for(int i=0; i < a.length; ++i){
			helper[i] = a[i];
		}
		
		int helperLeft = left;
		int helperRight = middle+1;
		int current = left;
		
		while(helperLeft <= middle && helperRight <= right){
			if(helper[helperLeft] < helper[helperRight]){
				a[current] = helper[helperLeft];
				++helperLeft;
			}
			else{
				a[current] = helper[helperRight];
				++helperRight;
			}
			++current;
		}
		
		int remaining = middle - helperLeft;
		for(int i=0; i<= remaining; ++i){
			a[current+i] = helper[helperLeft+i];
		}
	}
	
	public static void main(String s[]){
		int a[] = {21, 38, 52, 19, 30, 53, 19, 55, 16, 21};
		
		MergeSort m = new MergeSort();
		m.mergeSort(a);
		
		for(int i=0; i<a.length; ++i){
			System.out.print(a[i]+" ");
		}
	}
}
