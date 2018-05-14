import java.util.*;

public class RunningMedians{
    private int size;
    private MyHeap<Double> min,max;
    
    public RunningMedians(){
	min = new MyHeap<>(true);
	max = new MyHeap<>(false);
	size = 0;
    }

    public void add(Double d){
	if (size == 0){
	    min.add(d);
	    size++;
	    return;
	}
	if (d < min.peek()){
	    min.add(d);
	}
	else {
	    max.add(d);
	}
	if (Math.abs(min.size() - max.size()) > 1){
	    if (min.size() > max.size()){
		max.add(min.remove());
	    }
	    else{
		min.add(max.remove());
	    }
	}
	size++;
    }

    public Double getMedian(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	if (max.size() == min.size()){
	    return ((max.peek() + min.peek()) / 2);
	}
	else if (max.size() > min.size()){
	    return max.peek();
	}
	else {
	    return min.peek();
	}
    }

    public int size(){
	return size;
    }

     public static void main(String[] args){
        
    }
}
