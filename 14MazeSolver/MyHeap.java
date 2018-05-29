import java.util.*;
import java.util.Arrays;

public class MyHeap <T extends Comparable<T>>{
    private int size;
    private T[] heap;
    private boolean max;

    //construct a max heap size 10
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (T[])new Comparable[10];
	max = true;
    }

    //construct max or min heap based on boolean
    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	if (b){
	    max = true;
	}
	else {
	    max = false;
	}
	heap = (T[])new Comparable[10];
    }

    //helper method, swap two indices
    private void swap(int a,int b){
        T temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    //size of heap
    public int size(){
	return size;
    }

    //helper method
    private void pushUp(int index){
	if (max && index >= 1){
	    while(heap[index].compareTo(heap[(index - 1)/2]) > 0){
		swap(index,(index - 1)/2);
		index = (index - 1)/2;
	    }
	}
	else {
	    if (!max && index >= 1){
		while(heap[index].compareTo(heap[(index - 1)/2]) < 0){
		    swap(index,(index - 1)/2);
		    index = (index - 1)/2;
		}
	    }
	}
    }

    //add a string
    public void add(T value){
	if (size() == heap.length){
	    resize();
	}
	heap[size()] = value;
	pushUp(size());
        size++;
    }

    //helper method
    private void pushDown(int index){
	if (max){
	    while((index * 2) + 2 < size() && (heap[index].compareTo(heap[(index * 2) + 1]) < 0 || heap[index].compareTo(heap[(index * 2) + 2]) < 0)){
		int left = (index * 2) + 1;
		int right = (index * 2) + 2;
		if (heap[right].compareTo(heap[left]) <= 0 || right >= size()){
		    swap(index,left);
		    index = left;
		}
		else {
		    swap(index,right);
		    index = right;
		}
	    }
	}	    
	else if (!max){
	    while((index * 2) + 2 < size() && (heap[index].compareTo(heap[(index * 2) + 1]) > 0 || heap[index].compareTo(heap[(index * 2) + 2]) > 0)){
		int left = (index * 2) + 1;
		int right = (index * 2) + 2;
		if (heap[right].compareTo(heap[left]) >= 0 || right >= size()){
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

    //remove a string
    public T remove(){
	T value = heap[0];
	swap(0, size()-1);
        size--;
	pushDown(0);
	return value;
    }

    //peek 0
    public T peek(){
	return heap[0];
    }

    //resize
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[])new Comparable[size*2];
	for(int i = 0; i < size(); i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    public String toString(){
	String result = "";
	for(int i = 0; i < size(); i++){
	    result += "[" + heap[i] + "]";
	}
	return result;
    }

    /*public static void main(String[] args) {
    MyHeap<String> a = new MyHeap<>(false);
    String[] b = new String[20];
    for(int i = 0; i < 20; i++){
      int temp = (int)(Math.random() * 26) + 97;
      char value = (char)temp;
      a.add("" + value);
      b[i] = "" + value;
    }
    Arrays.sort(b);
    System.out.println("MyHeap: " + a);
    System.out.println("Arrays: "+ Arrays.toString(b));
    boolean isCorrect = true;
    for(int i = 0; i < 20; i++){
      //System.out.println("size: " + a.size());
      //System.out.println("heap before: " + a.toT());
      String temp = a.remove();
      if(!(temp.equals(b[i]))){
        System.out.println("there is an error");
        System.out.println(temp);
        System.out.println(b[i]);
        System.out.println(a);
        isCorrect = false;
      }
    }
    if(isCorrect){
      System.out.println("Your heap is correct!");
    }
    else{
      System.out.println("There are error(s)");
    }
  }
    */
}
