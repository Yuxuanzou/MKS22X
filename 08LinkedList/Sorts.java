import java.util.*;

public class Sorts{
    //sorting
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if (data.size() == 0){
	    return;
	}
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] p = new MyLinkedListImproved[20];
	for (int b = 0;b < 20;b++){
	    p[b] = new MyLinkedListImproved<Integer>();
	}
        String big = ("" + data.get(data.max()));
	String small = ("" + Math.abs(data.get(data.min())));
	int numOfComb = Math.max(big.length(),small.length());
	for (int i = 0;i < numOfComb;i++){
	    MyLinkedListImproved<Integer> temp = data;
	    for (Integer x : temp){
		int index = getDigit(i,x);
		if (x >= 0){
		    Integer place = getDigit(i,x);
		    p[index + 9].add(x);
		}
		else {
		    p[index + 9].add(x);
		}
	    }
	    temp.clear();
	    for (int d = 0;d < p.length;d++){
		temp.extend(p[d]);
	    }
	    data = temp;
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
	int[] test = {1};
	for (Integer x : test){
	    m.add(x);
	}
	System.out.println(m);
	radixsort(m);
	System.out.println(m);
	
	}*/
}
