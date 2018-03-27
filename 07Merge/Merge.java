import java.util.*;

public class Merge{
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	for (int i = 0;i < data.length;i++){
	    temp[i] = data[i];
	}
	msort(data,temp,0,data.length - 1);
    }
    
    public static void msort(int[] data,int[] temp,int lo,int hi){
	if (lo >= hi){
	    return;
	}
	int mid = (hi + lo) / 2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid + 1,hi);
	merge(data,temp,lo,mid,mid + 1,hi);
    }
    
    public static void merge(int[] data,int[] temp,int lo,int mid,int midPlusOne,int hi){
	int low = lo;
	int high = hi;
	int count = lo;
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
	for (int i = low;i < high + 1;i++){
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
       int[] a = new int[]{999,999,999,4,1,0,3,2,999,999,999,0,-1,32};
	int[] ary = new int[]{3,10,-1,0,-10,2,10,3,0,91,-21,-3};
	int[] b = {7,7,6,6,5,5,4,4,9,9,90,90,-1,-1};
	int[] c = {-200, 2, 5, 1, -100, 7, 0, 8, 99, 7, 8};
	int[] d = {};
	mergesort(d);
	mergesort(ary);
	mergesort(a);
	mergesort(b);
	mergesort(c);
	System.out.println(toString(b));
	System.out.println(toString(c));
	System.out.println(toString(ary));
	System.out.println(toString(a));
    }
    
}
