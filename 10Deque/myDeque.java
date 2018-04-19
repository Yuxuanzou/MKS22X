import java.util.*;

public class myDeque<E>{
    private E[] data;
    private int front,back;
    private int avaliableSpace;
    
    @SuppressWarnings("unchecked")
    public myDeque(){
	data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public myDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[]) new Object[initialCapacity];
    }

    //return size
    public int size(){
	return data.length;
    }

    //resizing
    @SuppressWarnings("unchecked")
    private void resize(){
	E[] temp = (E[]) new Object[size() * 2];
	for (int i = 0;i < size();i++){
	    temp[i] = data[i];
	}
	data = temp;
    }

    //adding to the front
    public void addFirst(E element){
	if (avaliableSpace == size()){
	    resize();
	}
	if (element == null){
	    throw new NullPointerException();
	}
	data[front - 1] = element;
	front -= 1;
	avaliableSpace += 1;
    }

    //adding to the back
    public void addLast(E element){
	if (avaliableSpace == size()){
	    resize();
	}
	if (element == null){
	    throw new NullPointerException();
	}
	data[back + 1] = element;
	back += 1;
	avaliableSpace += 1;
    }

    //remove from front
    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[front - 1];
	data[front - 1] = null;
	front += 1;
	avaliableSpace -= 1;
	return temp;
    }

    //remove from back
    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[back + 1];
	data[back + 1] = null;
	back += 1;
	avaliableSpace -= 1;
	return temp;
    }

    //get the front
    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[front];
    }

    //get the back 
    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[back];
    }
}
