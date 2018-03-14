import java.util.*;

public class part{
    public static int partition(int[] data,int start,int end){
	Random rand = new Random();
	int pivotIndex = rand.nextInt(end - 1);
	int pivot = data[pivotIndex];
	swap(data,pivotIndex,start);
	int small = start + 1;
	int large = end - 1;
	System.out.println(pivot);
	System.out.println(pivotIndex);
	while (small <= large){
	    if (data[small] <= pivot){
		small++;
	    }
	    else if (data[small] > pivot){
		swap(data,small,large);
		large--;
	    }
	}
	swap(data,start,large);
	return large;
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
	
    }

    public static int helpe(int[] data,int start,int end){
	if (start >= end){
	    return 0;
	}
	
    }

    public static void main(String[] args){
	int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
        partition(ary,0,ary.length - 1);
	System.out.println(toString(ary));
    }
}
