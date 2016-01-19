package practice;

public class MaxHeap {
	
	private int array[];
	private int arrayLength;
	private int parent;
	private int swapIndex;
	private int arraySorted;
	
	public MaxHeap(int[] a){
		arrayLength = a.length+1;
		array = new int[arrayLength];
		array[0] = -1;
		
		for(int i = 0; i < a.length; ++i){
			array[i+1] = a[i];
		}
	}
	
	public void maxHeap(int val){
		
		while(true){
			
			parent = val / 2;
			arraySorted = 1;
			
//			Termination Logic
			for(int i = parent; i >= 1; --i){
				if(array[2*i] > array[i]){
					arraySorted = 0;
					break;
				}
				if(2*i+1 <= val){
					if(array[2*i+1] > array[i]){
						arraySorted = 0;
						break;
					}
				}
			}
			
			if(arraySorted == 1){
				break;
			}
			
	//		For Each Parent
			while(parent >= 1){
				
	//			Find Biggest Child
				if( (2*parent+1) <= array.length-1){
					if(array[2*parent+1] > array[2*parent]){
						swapIndex = 2*parent+1;
					}else{
						swapIndex = 2*parent;
					}
				}
				
	//			Swap With Parent
				if(array[swapIndex] > array[parent]){
					swap(array, swapIndex, parent);
				}
				--parent;
//				System.out.println(parent);
			}
		}	
		for(int i=1; i<array.length; ++i){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public void swap(int[] array, int first, int second){
		int temp;
		temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
	public static void main(String s[]){
		
		int a[] = {21, 38, 52, 19, 30, 153, 19, 55, 16, 21, 22};
		MaxHeap heap = new MaxHeap(a);
		heap.maxHeap(a.length);
	}
}
