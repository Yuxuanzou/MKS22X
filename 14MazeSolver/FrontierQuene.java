import java.util.LinkedList;

public class FrontierQuene implements Frontier{

    private LinkedList<Location> l = new LinkedList<>();

    public void add (Location b){
	l.addLast(b);
    }

    public Location next(){
	return l.remove();
    }

    public boolean hasNext(){
        if (l.size() > 0){
	    return true;
	}
	else{
	    return false;
	}
    }
}
