
public class Heapsort {
	private static int[] heap = {3,7, 1, 8, 2, 5, 9, 4, 6};
	
	public static void main(String[] args) {
		
		printArray(heap);
		sort(heap);
		printArray(heap);
	
	}
	
	public static void printArray(int[] array) {
		for(int i = 0; i<array.length; i++) {
			
			System.out.println(i + ") " + array[i] + "\n");
			
		}
	}
	
	public static void sort(int[] elements) {
		buildHeap(elements);
		
		for(int swapToPos = elements.length - 1; swapToPos > 0; swapToPos--) {
			swap(elements, 0, swapToPos);
			heapify(elements, swapToPos, 0);	
		}
	}
	
	public static void heapify(int[] heap, int length, int posParent) {
		
		//Es muss innerhalb der Elemente das Größte Element gefunden werden
		//Das Eltern Element wird dann mit dem von dem Eltern Element und den Kind Elementen
		//das größte Element getauscht.
		while(true) {
			int posLeftChild = 2*posParent +1;
			int posRightChild = 2*posParent +2;
			int posLargest = posParent;
			
			if(posLeftChild < length && heap[posLeftChild] > heap[posLargest]) {
				posLargest = posLeftChild;
			}
			
			if(posRightChild < length && heap[posRightChild] > heap[posLargest]) {
				posLargest = posRightChild;
			}
			
			if(posLargest == posParent) {
				break;
			}
			
			swap(heap, posParent, posLargest);
			
			posParent = posLargest;
		}
	}
	
	public static void buildHeap(int[] elements) {
		//Berechnet das letzte Eltern Element
		int lastParentNode = elements.length / 2 -1;
		
		for(int i = lastParentNode; i>= 0; i--) {
			heapify(elements, elements.length, i);
		}
	}
	
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
