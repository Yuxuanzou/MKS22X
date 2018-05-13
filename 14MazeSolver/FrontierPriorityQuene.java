public class FrontierPriorityQuene implements Frontier{
    
    private MyHeap<Location> h = new MyHeap<>(false);

    public void add(Location l){
	h.add(l);
    }

    public Location next(){
	return h.remove();
    }

    public boolean hasNext(){
	if (h.size() > 0){
	    return true;
	}
	else{
	    return false;
	}
    }
}
