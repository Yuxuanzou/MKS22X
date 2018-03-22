public class merge{
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length - 1);
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
	System.out.println(toString(data));
	msort(temp,data,mid + 1,hi);
	System.out.println(toString(temp));
	merge(data,temp,lo,mid,mid + 1,hi);
	System.out.println(toString(data));
    }
    
    public static void merge(int[] data,int[] temp,int lo,int mid,int midPlusOne,int hi){
	int low = lo;
	int high = hi;
	int count = 0;
        while(lo <= mid && midPlusOne <= hi && count < temp.length){
	    if(data[lo] <= data[midPlusOne]){
		temp[count] = data[lo];
		lo++;
		count++;
	    }
	    else {
		temp[count] = data[midPlusOne];
		midPlusOne++;
		count++;
	    }
	}
	while(lo <= mid){
	    temp[count] = data[lo];
	    lo++;
	    count++;
	}
	while(midPlusOne <= hi){
	    temp[count] = data[midPlusOne];
	    midPlusOne++;
	    count++;
	}
	for (int i = low;i < high;i++){
	    data[i] = temp[i];
	}
    }

    public static String toString(int[] b){
	String str = "";
	for (int i = 0;i < b.length;i++){
	    str += b[i] + " " ;
	}
	return str;
    }
    
    public static void main(String[] args){
	//int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999,0,-1,32};
	int[] ary = new int[]{3,10,-1,0,-10,2};
	mergesort(ary);
	System.out.println(toString(ary));
    }
}
