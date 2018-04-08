public class MyLinkedList{
    
    private Node first,last;
    private int length;
    
    public MyLinkedList(){
	
    }

    //helper method
    private Node getNode(int index){
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
    public boolean add(int value){
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
	if (index == length){
	    add(value);
	    length++;
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
		length--;
		return remove(i);
	    }
	    current = current.getNext();
	}
	return false;
    }

    //remove at specific index
    public boolean remove(int index){
	Node current = getNode(index);
	if (index == length){
	    last = current.getPrev();
	    last.setNext(null);
	    length--;
	    return true;
	}
	else if (index == 0){
	    first = current.getNext();
	    first.setPrev(null);
	    length--;
	    return true;
	}
	else{
	    Node before = current.getPrev();
	    Node after = current.getNext();
	    before.setNext(after);
	    after.setPrev(before);
	    length--;
	    return true;
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
}
