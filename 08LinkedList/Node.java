public class Node{
    private Node next,prev;
    private int data;
    
    public Node(int d,Node next,Node prev){
        data = d;
	this.next = next;
	this.prev = prev;
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

    public String toString(){
	String str = "";
	str += this.getValue();
	return str;
    }
}
