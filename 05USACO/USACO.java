import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){

    }

    public static int bronze(String filename) throws FileNotFoundException{
	File f = new File(filename);
	Scanner in = new Scanner(f);
	String line = in.nextLine();
	String[] ary = line.split(" ");
	int row = Integer.parseInt(ary[0]);
	int col = Integer.parseInt(ary[1]);
	int waterLevel = Integer.parseInt(ary[2]);
	int numOfMoves = Integer.parseInt(ary[3]);
	int[][] board = new int[row][col];
	for (int i = 0;i < row;i++){
	    for (int c = 0;c < col;c++){
		board[i][c] = Integer.parseInt(in.next());
	    }
	}
	while (in.hasNext()){
	    int[] rowStomp = new int[9];
	    int[] colStomp = new int[9];
	    String L = in.nextLine();
	    String[] skrt = line.split(" ");
	    int r_s = Integer.parseInt(skrt[0]);
	    int c_s = Integer.parseInt(skrt[1]);
	    int stomp = Integer.parseInt(skrt[2]);
	    int max = 0;
	    try {
		for (int i = 0;i < 3;i++){
		    for (int c = 0;c < 3;c++){
			max = Math.max(board[r_s + i][c_s + c],max);
		    }
		}
	    } catch (ArrayIndexOutOfBoundsException e){}
	    stomp(r_s,c_s,board,max,stomp);
	}
	int totalDepth = 0;
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		totalDepth += board[i][c];
	    }
	}
	
	return totalDepth;
    }

    public static void stomp(int r,int c,int[][] board,int max,int stompNum){
	try {
	    for (int i = 0;i < 3;i++){
		for (int d = 0;d < 3;d++){
		    int skrt = board[r + i][c + d];
		    if (skrt > max - stompNum){
			skrt = max - stompNum;
		    }
		}
	    }
	} catch (ArrayIndexOutOfBoundsException e){
	}
    }
    
    public static int silver(String filename){
	return 0;
    }

    public static void main(String[] args){
	try{
	    System.out.println(USACO.bronze("makelake.in"));
	}catch(FileNotFoundException e){}
    }
}
