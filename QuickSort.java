package practice;

public class QuickSort {
	
	public void quickSort(int[] a, int left, int right){
		int index = partition(a, left, right);
		
		if(left < index-1){		// Sort Left Half
			quickSort(a, left, index-1);
		}
		
		if(index < right){		// Sort Right Half
			quickSort(a, index, right);
		}
	}
	
	public int partition(int[] a, int left, int right){
		int pivot = a[(left + right) / 2];
		
		while(left <= right){
			
			while(a[left] < pivot){
				++left;
			}
			
			while(a[right] > pivot){
				--right;
			}
			
			if(left <= right){
				swap(a, left, right);
				++left;
				--right;
			}
		}
		
		return left;
	}
	
	public void swap(int[] a, int left, int right){
		int temp;
		temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	public static void main(String s[]){
		int a[] = {21, 38, 52, 19, 30, 53, 19, 55, 16, 21};
		
		QuickSort q = new QuickSort();
		q.quickSort(a, 0, a.length-1);
		
		for(int i=0; i < a.length; ++i){
			System.out.print(a[i]+" ");
		}
	}
}