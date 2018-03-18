import java.util.*;

public class Quick{
    public static int partition(int[] data,int start,int end){
	if (start >= end){
	    return end;
	}
	Random rand = new Random();
	int pivotIndex = rand.nextInt(end - start) + start;
	int pivot = data[pivotIndex];
	swap(data,pivotIndex,start);
	int lt = start;
	int gt = end;
	int i = start;
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
        if (lt > 0){
	    return partition(data,start,lt - 1);
	}
	return partition(data,gt + 1,end);
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
	return data[k];
    }

    public static void quicksort(int[] data){
	quicksortHelp(data,0,data.length - 1);
    }

    public static void quicksortHelp(int[] data,int start,int end){
        if (start >= end){
	    return;
	}
	Random rand = new Random();
	int pivotIndex = rand.nextInt(end - start) + start;
	int pivot = data[pivotIndex];
	swap(data,pivotIndex,start);
	int lt = start;
	int gt = end;
	int i = start;
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
        if (lt > 0){
	    quicksortHelp(data,start,lt - 1);
	}
	quicksortHelp(data,gt + 1,end);
	}
    
    /*public static void main(String[] args){
	int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999,0,-1,32};
	//System.out.println(quickselect(ary,0));
	quicksort(ary);
	System.out.println(toString(ary));
	}*/

    /* public static void main(String[] args){
	int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
	quicksort(test);
	System.out.println(toString(test));
	}*/
}

