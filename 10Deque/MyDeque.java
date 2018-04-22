import java.util.*;

public class MyDeque<E>{
    private E[] data;
    private int front,back;
    private int size;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	front = 0;
	back = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[]) new Object[initialCapacity];
	front = 0;
	back = 0;
    }

    //return size
    public int size(){
	return size;
    }

    //resizing
    @SuppressWarnings("unchecked")
   private void resize(){
	E[] temp = (E[]) new Object[size() * 2];
	for (int i = 0;i < size();i++){
	    temp[i] = data[i];
	}
	data = temp;
	front = 0;
	back = size() - 1;
    }
    
    //adding to the front
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
		resize();
	    }
	if (size == 0){
	    data[front] = element;
	}
	else{
	    if (front <= 0){
	        front = front + data.length - 1;
		data[front] = element;
	    }
	    else{
		front -= 1;
		data[front] = element;
	    }
	}
	size += 1;
    }

    //adding to the back
    public void addLast(E element){
	if (size == data.length){
	    resize();
	}
	if (element == null){
	    throw new NullPointerException();
	}
	if (size == 0){
	    data[back] = element;
	}
	else {
	    if (back >= data.length - 1){
		back = back - (data.length - 1);
		data[back] = element;
	    }
	    else{
		back += 1;
		data[back] = element;
	    }
	}
	size += 1;
    }

    //remove from front
    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[front];
	data[front] = null;
	if (front == data.length - 1){
	    front = 0;
	}
	else{
	    front += 1;
	}
        size -= 1;
	return temp;
    }

    //remove from back
    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E temp = data[back];
	data[back] = null;
	if (back == 0){
	    back = data.length - 1;
	}
	else {
	    back -= 1;
	}
        size -= 1;
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

    public String toString(){
    String ans = "[";
    if(front < back){
      for (int i = front; i <= back; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = front; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= back; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

    /*
    public static void main(String[] args) {
	try{
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
	}catch (NoSuchElementException e){
	}
  }
    */
}
