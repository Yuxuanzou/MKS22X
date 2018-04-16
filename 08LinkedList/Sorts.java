import java.util.*;

public class Sorts{
    //sorting
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] p = new MyLinkedListImproved[10];
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] n = new MyLinkedListImproved[10];
	for (int b = 0;b < 10;b++){
	    p[b] = new MyLinkedListImproved<Integer>();
	    n[b] = new MyLinkedListImproved<Integer>();
	}
        String big = ("" + data.get(data.max()));
	String small = ("" + Math.abs(data.get(data.min())));
	int numOfComb = Math.max(big.length(),small.length());
	for (int i = 0;i < numOfComb;i++){
	    for (Integer x : data){
		int index = Math.abs(getDigit(i,x));
		if (x >= 0){
		    Integer place = getDigit(i,x);
		    p[index].add(x);
		}
		else {
		    Integer place = getDigit(i,x);
		    n[index].add(x);
		}
	    }
	    data.clear();
	    for (int c = n.length - 1;c >= 0;c--){
		data.extend(n[c]);
	    }
	    for (int d = 0;d < p.length;d++){
		data.extend(p[d]);
	    }
	}
    }

    //helper method to find digit
    private static Integer getDigit(int place, Integer num){
	Integer temp = num;
	if (place == 0){
	    return (temp % 10);
	}
	else {
	    int r = (int)Math.pow(10,place);
	    temp = temp / r;
	    return (temp % 10);
	}
    }

    /*public static void main(String[]args){
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();       
	int[] test = {-1,10,213,-10,-123};
	for (Integer x : test){
	    m.add(x);
	}
	System.out.println(m);
	radixsort(m);
	System.out.println(m);
	
	}*/
}
