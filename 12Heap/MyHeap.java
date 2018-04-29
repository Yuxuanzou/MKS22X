import java.util.*;
import java.util.Arrays;

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

    public void add(String str){
	if (size() == heap.length){
	    resize();
	}
	heap[size()] = str;
	pushUp(size());
        size++;
    }



    private void pushDown(int index){
	int left = (index * 2) + 1;
	int right = (index * 2) + 2;
	if (max){
	    while(left < size() && heap[index].compareTo(heap[left]) < 0){
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
	    while(left < size() && heap[index].compareTo(heap[left]) > 0){
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

    public String remove(){
	String str = heap[0];
	swap(0, size()-1);
        size--;
	pushDown(0);
	return str;
    }

    public String peek(){
	return heap[0];
    }

    public void resize(){
	String[] temp = new String[heap.length * 2];
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

    public static void main(String[] args){

    }
}
