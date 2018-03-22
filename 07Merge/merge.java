public class merge{
    public static void mergesort(int[] data){
	
    }
    
    public static void msort(int[] data,int[] temp,int lo,int hi){
	temp = new int[hi - lo + 1]
	if (lo >= hi){
	    return;
	}
	for (int i = lo;i < hi;i++){
	    temp[i] = data[i];
	}
	int mid = (hi + lo) / 2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid + 1,hi);
	merge(data,temp,lo,mid,mid + 1,hi);
    }
    
    public static void merge(int[] data,int[] temp,int lo,int mid,int midPlusOne,int hi){
	int tick = 0;
        while(lo <= mid && midPlusOne <= hi && tick < temp.length){
	    if(data[lo] <= data[midPlusOne]){
		temp[count] = data[lo];
		lo++;
		count++;
	    }
	    num[count] = data[midPlusOne];
	    midPlusOne++;
	    count++
	}
    }

    public static void swap(int data,int lo,int hi){
	int temp = data[lo];
	data[lo] = data[hi];
	data[hi] = temp;
    }
}
