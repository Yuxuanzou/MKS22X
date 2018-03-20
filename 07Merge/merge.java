public class merge{
    public static void murge(int[] data,int start,int end){
	int[] L = new int[(end - start) / 2];
	int[] R = new int[(end - start) / 2];
	int LCount = 0;
	int RCount = 0;
	for (int i = start;i < end;i++){
	    if(i < (start + end) / 2){
	        L[LCount] = data[i];
	    }
	    R[RCount] = data[i];
	}
	LCount = 0;
	RCount = 0;
	for (int i = start;i < end;i ++){
	    if (L[LCount] <= R[RCount]){
		data[i] = L[LCount];
		LCount++;
	    }
	    else {
		data[i] = R[RCount];
		RCount++;
	    }
	}
    }
}
