public class MyHeap{
    private int size;
    private String[] heap;
    private boolean max;

    //construct a max heap size 10
    public MyHeap(){
	heap = new String[10];
	max = true;
    }

    //construct max or min heap based on boolean
    public MyHeap(boolean b){
	if (b){
	    max = true;
	}
	else {
	    max = false;
	}
	heap = new String[10];
    }

    private void swap(int a,int b){
	String temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    public int size(){
	return size;
    }
    
    private void pushUp(int index){
	if (max){
	    while(index > 1 && heap[index].compareTo(heap[index / 2]) > 0){
		swap(index,index / 2);
		index = index / 2;
	    }
	}
	else {
	    while(index != 1 && heap[index].compareTo(heap[index / 2]) < 0){
		swap(index,index / 2);
		index = index / 2;
	    }
	}
    }

    private void pushDown(int index){
	int left = (index * 2) + 1;
	int right = (index * 2) + 2;
	if (max && left < size() && right < size()){
	    while(heap[index].compareTo(heap[left]) > 0 || heap[index].compareTo(heap[right]) > 0){
		if (heap[index].compareTo(heap[left]) > 0){
		    swap(index,left);
		    index = left;
		}
		else {
		    swap(index,right);
		    index = right;
		}
	    }
	}
	else {
	    while(heap[index].compareTo(heap[left]) < 0 || heap[index].compareTo(heap[right]) < 0){
		if (heap[index].compareTo(heap[left]) < 0){
		    swap(index,left);
		    index = left;
		}
		else {
		    swap(index,right);
		    index = right;
		}
	    }
	}
    }

}
