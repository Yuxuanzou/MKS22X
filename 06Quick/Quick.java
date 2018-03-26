import java.util.*;
import java.util.Arrays;
 
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
	    if((lt - start - 1) < 30){
		insertionSort(data,start,lt - 1);
	    }else{
		quicksortHelp(data,start,lt - 1);
	    }
	}
	if (end - (gt + 1) < 8){
	    insertionSort(data,gt + 1,end);
	}
	else{
	    quicksortHelp(data,gt + 1,end);
	}
    }
    
    public static void insertionSort(int [] data,int lo,int hi){
       int index;
       int num;
	   for (int i = lo;i < hi;i++){
           index = i;
           num = data[i];
           for (int c = index; c > lo; c--){
                if (num < data[c-1]){
                    data[index] = data[c - 1];
                    index = index - 1;
                    data[index] = num;
		}
           }
	   }
    }

    /*public static void main(String[] args){
	int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999,0,-1,32};
	//System.out.println(quickselect(ary,0));
	quicksort(ary);
	System.out.println(toString(ary));
    }
    */
}
    /*
     //Sort testing code
    private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static final int EMPTY = 4;

  private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    if(type == EMPTY){
      ans = new int[0];
    }
    return ans;
  }

  public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    
     
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
    }else{
      System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
  }
    
    public static void main(String[] args){
	int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999,0,-1,32};
	//System.out.println(quickselect(ary,0));
	quicksort(ary);
	System.out.println(toString(ary));
	}

    /* public static void main(String[] args){
	int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
	quicksort(test);
	System.out.println(toString(test));
	}*/

