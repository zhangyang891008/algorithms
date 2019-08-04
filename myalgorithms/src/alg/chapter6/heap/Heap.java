package alg.chapter6.heap;
/**
 * heap sort :
 * 20190804
 * @author zy
 *
 */
public class Heap {
	
	public static int heapSize = 0;
	
	public void buildMaxHeap(int[] arr, int heapSize) {
		this.heapSize = heapSize;
		for(int i = arr.length>>1; i>0; i--) {		
			heapify(arr, i);
		}
	}
	
	public void sort(int[] arr, int heapSize) {
		this.heapSize = heapSize;
		for(int i = arr.length-1; i > 1; i--) {
			swap(arr, 1, i);
			this.heapSize--;
			heapify(arr, 1);
		}
		this.heapSize = heapSize;
	}
	
	public int executeMax(int[] arr, int heapSize) {
		this.heapSize = heapSize;
		int max = arr[1];
		//arr[1] = arr[heapSize];
		swap(arr, 1, heapSize);
		this.heapSize = heapSize - 1;
		arr[0] = this.heapSize;
		heapify(arr, 1);
		return max;
	}
	
	public void heapify(int[] arr, int pos) {	
		int largest = pos;
		int left = pos*2;
		int right = pos*2 + 1;
		if(left <= heapSize && arr[left] > arr[pos]) {
			largest = left;
		}
		if(right <= heapSize && arr[right] > arr[largest]) {
			largest = right;
		}
		if(largest != pos) {
			//需要调整
			swap(arr, largest, pos);
			heapify(arr, largest);
		}
	}
	
	private void swap(int[] arr, int largest, int pos) {
		int temp = arr[largest];
		arr[largest] = arr[pos];
		arr[pos] = temp;
	}
	
	private void print(int[] arr) {
		System.out.println("*******current size:"+arr[0]);
		for(int i = 1; i <= arr[0]; i++) {
			System.out.println(arr[i]);
		}
	}


	public static void main(String[] args) {
		int[] arr = {-1,0,6,1,4,3,2};
		arr[0] = arr.length - 1;
		Heap heap = new Heap();
		heap.buildMaxHeap(arr, arr[0]);
		heap.print(arr);
		
		//sort
		heap.sort(arr, arr.length-1);
		heap.print(arr);
		
		//executeMax
		heap.buildMaxHeap(arr, arr[0]);
		int max = heap.executeMax(arr, arr[0]);
		System.out.println("**"+max);
		heap.print(arr);
	}

}
