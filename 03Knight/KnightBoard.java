public class KnightBoard {
    private int[][] board;
    private int[][] xAndY;
    
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
    }

    public String toString(){
	String str = "";
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		if (board[i][c] < 10){
		    if (c == board[i].length){
			str += " " + board[i][c] + "\n";
		    }
		    str += " " + board[i][c];
		}
		else {
		    if (c == board[i].length){
			str += "" + board[i][c] + "\n";
		    }
			str += "" + board[i][c];
		}
	    }
	}
	return str;
    }

    // public void KnightMove(){
	
    // }
    /*
    public boolean solve(int startingRow, int startingCol){
	for (int i = 0; i < board.length;i++){
	    for (int c = 0; c < board[i].length;c++){
		if (board[i][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelper(startingRow, startingCol, 0);
    }

    public boolean solveHelper(int row,int col,int count){
	if (count => (row * col)){
	    return true;
	}
	
	}*/

    // public int countSolutions(int startingRow, int startingCol){
	
    // }
    public static void main(String[] args){
	KnightBoard g = new KnightBoard(10,10);
	System.out.println(g);
    }
}
