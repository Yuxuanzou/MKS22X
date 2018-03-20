public class merge{
    public static void mergesort(int[] data){
	
    }
    
    public static void msort(int[] data,int[] temp,int lo,int hi){
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
        int end = hi;
	int low = lo;
	for (int i = low + 1;i < mid;i++){
	    if (temp[i] < temp[i - 1]){
		
	    }
	}
    }

    public static void swap(int data,int lo,int hi){
	int temp = data[lo];
	data[lo] = data[hi];
	data[hi] = temp;
    }
}
