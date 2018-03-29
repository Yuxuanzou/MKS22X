public class Node{
    private Node next,prev;
    private int data;
    
    public Node(int d){
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
