import java.util.*;

public class Sorts{
    public static void heapSort(Integer[] d){
	MyHeap<Integer> h = new MyHeap<>(false);
	Integer[] temp = new Integer[d.length];

	for (int i = 0;i < d.length;i++){
	    h.add(d[i]);
	}

	for (int c = 0;c < temp.length;c ++){
	    d[c] = h.remove();
	}
    }

     public static void main(String[] args) {

     }
}
