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
	while (numOfMoves != 0){
	    int r_s = Integer.parseInt(in.next()) - 1;
	    int c_s = Integer.parseInt(in.next()) - 1;
	    int stomp = Integer.parseInt(in.next());
	    int max = 0;
	    System.out.println(r_s);
	    System.out.println(c_s);
	    try {
		for (int i = 0;i < 3;i++){
		    for (int c = 0;c < 3;c++){
			max = Math.max(board[r_s + i][c_s + c],max);
		    }
		}
	    } catch (ArrayIndexOutOfBoundsException e){}
	    System.out.println(max);
	    stomp(r_s,c_s,board,max,stomp);
	    numOfMoves -= 1;
	    System.out.println(toString(board));
	}
	int totalDepth = 0;
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		int h = waterLevel - board[i][c];
		if (h > 0){
		    totalDepth += h;
		}
	    }
	}
	
	return totalDepth * 72 * 72;
    }
    
    public static String toString(char[][] b){
	String str = "";
	for (int i = 0;i < b.length;i++){
	    for (int c = 0;c < b[i].length;c++){
		str += b[i][c];
		str += " ";
	    }
	    str += "\n";
	}
	return str;
    }

    public static String daOne(String[] b){
	String str = "";
	for (int i = 0;i < b.length;i++){
	    str += b[i];
	    str += " ";
	}
	return str;
    }
    
    public static void stomp(int r,int c,int[][] board,int max,int stompNum){
	for (int i = 0;i < 3;i++){
	    for (int d = 0;d < 3;d++){
		if (board[r + i][c + d] > (max - stompNum)){
		    board[r+ i][c + d] = (max - stompNum);
		}
	    }
	}
    } 
    
    public static int silver(String filename) throws FileNotFoundException{
        File f = new File(filename);
	Scanner in = new Scanner(f);
	String[] skrt = in.nextLine().split(" ");
	int row = Integer.parseInt(skrt[0]);
	int col = Integer.parseInt(skrt[1]);
	int numOfMoves = Integer.parseInt(skrt[2]);
	char[][] board = new char[row][col];
	for (int i = 0;i < row;i++){
	    for (int c = 0;c < col;c++){
		board[i][c] = in.next().charAt(0);
	    }
	}
	System.out.println(toString(board));
	return 0;
    }

    public static void main(String[] args){
	try {
	    silver("silver1.txt");
	}catch(FileNotFoundException e){}
    }
}
