public class RunningMedians{
    private int size;
    private MyHeap<Double> min,max;
    
    public RunningMedian(){
	min = new MyHeap<>(false);
	max = new MyHeap<>(true);
	size = 0;
    }

    public void add(Double d){
	if (size == 0){
	    min.add(d);
	}
	
    }

    public Double getMedian(){
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

    private int bigOrSmall(Double a, Double b){
	return a.compareTo(b);
    }
}
