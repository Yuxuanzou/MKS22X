import java.util.Stack;

public class FrontierStack implements Frontier{

    private Stack<Location> l = new Stack<>();

    public void add(Location b){
	l.push(b);
    }

    public Location next(){
	return l.pop();
    }

    public boolean hasNext(){
	if (l.size() > 0){
	    return true;
	}
	return false;
    }
}
