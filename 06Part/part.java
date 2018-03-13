import java.util.*;

public class part{
    public static int partition(int[] data,int start,int end){
	Random rand = new Random();
	int pivotIndex = rand.nextInt(end - 1);
	int pivot = data[pivotIndex];
	swap(data,pivotIndex,start);
	int small = start + 1;
	int large = end - 1;
	while (small <= large){
	    System.out.println(pivot);
	    System.out.println(toString(data));
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

    public static void main(String[] args){
	
    }
}
