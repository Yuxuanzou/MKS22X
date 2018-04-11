public class MyLinkedList{
    
    private Node first,last;
    private int length;
    
    public MyLinkedList(){
	
    }

    //helper method
    private Node getNode(int index){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	if (index == length - 1){
	    return last;
	}
	else if (index == 0){
	    return first;
	}
	for (int i = 0;i < index;i++){
	    current = current.getNext();
	}
	return current;
    }

    //add to the end
    public boolean add(Integer value){
	Node n = new Node(value);
	if (length == 0){
	    first = n;
	    last = n;
	}
	last.setNext(n);
	n.setPrev(last);
	last = n;
	length ++;
	return true;
    }

    //clear
    public void clear(){
	length = 0;
	first = null;
	last = null;
    }

     //find the size
    public int size(){
	return length;
    }

     //visuals 
    public String toString(){
	Node current = first;
	String str = "[";
	for (int i = 0;i < length;i++){
	    str += current.getValue();
	    if (i < length - 1){
		str += ",";
	    }
	    current = current.getNext();
	}
	str += "]";
	return str;
    }

    //return Node value;
    public Integer get(int index){
	return getNode(index).getValue();
    }

    //set at specific index
    public Integer set(int index,Integer newValue){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
        Node current = getNode(index);
	Integer old = current.getValue();
	current.setValue(newValue);
	return old;
    }

    //find the index, return -1 if not found
    public int indexOf(Integer value){
	int i = -1;
	Node current = first;
	for (int c = 0;c < length;c++){
	    if (current.getValue() == value){
		i = c;
		return i;
	    }
	    current = current.getNext();
	}
	return i;
    }

    public void add(int index, Integer value){
	if (index > length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if (index == length){
	    add(value);
	    return;
	}
	else if (index == 0){
	    Node now = new Node(value);
	    first.setPrev(now);
	    now.setNext(first);
	    first = now;
	    length++;
	    return;
	}
	Node old = getNode(index);
	Node now = new Node(value);
	now.setPrev(old.getPrev());
	now.setNext(old);
	old.getPrev().setNext(now);
	old.setPrev(now);
	length++;
    }

    //remove first occurance
    public boolean remove(Integer value){
	Node current = first;
	for (int i = 0;i < length;i++){
	    if (current.getValue() == value){
		remove(i);
		return true;
	    }
	    current = current.getNext();
	}
	return false;
    }

    //remove at specific index
    public Integer remove(int index){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = getNode(index);
	Integer answer = current.getValue();
	if (index == length - 1){
	    last = current.getPrev();
	    last.setNext(null);
	    length--;
	    return answer;
	}
	else if (index == 0){
	    first = current.getNext();
	    first.setPrev(null);
	    length--;
	    return answer;
	}
	else{
	    Node before = current.getPrev();
	    Node after = current.getNext();
	    before.setNext(after);
	    after.setPrev(before);
	    length--;
	    return answer;
	}
    }

    //Node class
    private class Node{
	private Node next,prev;
	private Integer data;
	
	public Node(Integer d){
	    data = d;
	    next = null;
	    prev = null;
	}
	
	private Node getNext(){
	    return next;
	}
	
	private Node getPrev(){
	    return prev;
	}
	
	private int getValue(){
	    return data;
	}

	private void setValue(Integer value){
	    data = value;
	}
	
	private void setNext(Node next){
	    this.next = next;
	}
	
	private void setPrev(Node prev){
	    this.prev = prev;
	}
	
	public String toString(){
	    String str = "";
	    str += this.getValue();
	    return str;
	}
    }
    /*
     public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
   }
    */
}
