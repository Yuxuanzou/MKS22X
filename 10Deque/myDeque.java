import java.util.*;

public class myDeque<E>{
    private E[] data;
    
    @SuppressWarnings("unchecked")
    public myDeque(){
	data = (E[])new Object[10];
    }

    @SuppressWarnings("unchecked")
    public myDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[]) new Object[initialCapacity];
    }

    public int size(){
	return data.length;
    }
    
}
