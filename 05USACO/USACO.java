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
	    stomp(r_s,c_s,board,max,stomp);
	    numOfMoves -= 1;
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
    
    public static String toString(int[][] b){
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

    public static int silver(String filename)throws FileNotFoundException{
        File f = new File(filename);
	Scanner in = new Scanner(f);
	String[] skrt = in.nextLine().split(" ");
	int row = Integer.parseInt(skrt[0]);
	int col = Integer.parseInt(skrt[1]);
	int numOfMoves = Integer.parseInt(skrt[2]);
	char[][] board = new char[row][col];
	for (int i = 0;i < row;i++){
	    String line = in.nextLine();
	    for (int c = 0;c < col;c++){
		board[i][c] = line.charAt(c);
	    }
	}
	String[] cords = in.nextLine().split(" ");
	int r1 = Integer.parseInt(cords[0]);
	int c1 = Integer.parseInt(cords[1]);
	int r2 = Integer.parseInt(cords[2]);
	int c2 = Integer.parseInt(cords[3]);
	int[][] helperBoard = new int[row][col];
	int[][] helper2Board = new int[row][col];
	for (int i = 0;i < row;i++){
	    for (int c = 0;c < col;c++){
		if (board[i][c] == '*'){
		    helperBoard[i][c] = -1;
		    helper2Board[i][c] = -1;
		}
		else if (i == (r1 - 1) && c == (c1 - 1)){
		    helperBoard[i][c] = 1;
		    helper2Board[i][c] = 1;
		}
		else {
		    helperBoard[i][c] = 0;
		    helper2Board[i][c] = 0;
		}
	    }
	}
	for (int m = 0;m < numOfMoves;m++){
	    for (int i = 0;i < row;i++){
		for (int c = 0;c < col;c++){
		    helperBoard[i][c] =  helper2Board[i][c];
		}
	    }
	    for (int i = 0;i < row;i++){
		for (int c = 0;c < col;c++){
		    try{
			if (helper2Board[i][c] != -1){
			    helper2Board[i][c] = sumN(i,c,helperBoard);
			}
		    }catch (ArrayIndexOutOfBoundsException e){
		    }
		}
	    }
	}
	return  helper2Board[r2 - 1][c2 - 1];
    }

    private static int sumN(int x, int y, int[][] board){
	int[] row = new int[]{0,0,1,-1};
	int[] col = new int[]{-1,1,0,0};
        int sum = 0;
	for (int i = 0;i < 4;i++){
	    if (isValid(x + row[i],y + col[i],board)){
		sum += board[x + row[i]][y + col[i]];
	    }
	}
        return sum;
    }

    private static boolean isValid(int x, int y, int[][] board){
        return !(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == -1);
    }

    public static void main(String[] args){
	try{
	    int b = silver("silver1.txt");
	    System.out.println(b);
	}catch(FileNotFoundException e){}
    }
}
