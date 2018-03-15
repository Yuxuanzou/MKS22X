import java.util.*;

public class Quick{
    public static int partition(int[] data,int start,int end){
	Random rand = new Random();
	int pivotIndex = rand.nextInt(end - start) + start;
	int pivot = data[pivotIndex];
	swap(data,pivotIndex,start);
	int lt = start;
	int gt = end;
	int i = start + 1
	while (i <= gt){
	    if (data[i] == pivot){
		i++;
	    }
	    else if (data[i] > pivot){
		swap(data,i,gt);
		gt--;
	    }
	    else {
		swap(data,i,lt);
		i++;
		lt++;
	    }
	}
	partition(data,start,
    }

    public static String toString(int[] b){
	String str = "";
	for (int i = 0;i < b.length;i++){
	    str += b[i] + " " ;
	}
	return str;
    }

    public static void swap(int[] data,int start,int end){
	int temp = data[start];
	data[start] = data[end];
	data[end] = temp;
    }

    public static int quickselect(int[] data,int k){
	return quickHelp(data,k,0,data.length - 1);
    }

    public static int quickHelp(int[] data,int k,int start,int end){
	int pivotIndex = partition(data,start,end);
        while (pivotIndex != k){
	    if (pivotIndex > k){
	        return quickHelp(data,k,start,pivotIndex - 1);
	    }
	    if (pivotIndex < k){
		return quickHelp(data,k,pivotIndex + 1,end);
	    }
	}
	return data[pivotIndex];
    }

    public static void quicksort(int[] ary){
	quicksortHelp(ary,0,ary.length - 1);
    }

    public static void quicksortHelp(int[] ary,int start,int end){
        if (start < end){
	    int pivot = partition(ary,start,end);
	    quicksortHelp(ary,pivot + 1,end);
	    quicksortHelp(ary,start,pivot - 1);
	}
	}
    /*
    public static void main(String[] args){
	int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(quickselect(ary,2));
			   //quicksort(ary);
	System.out.println(toString(ary));
	}
    */
}
