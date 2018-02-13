public class KnightBoard {
    private int[][] board;
    
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
		if (board[i][c] == 0){
		    str += "_ ";
		}
	    }
	}
	return str;
    }

    public boolean solve(int startingRow, int startingCol){
	for (int i = 0; i < board.length;i++){
	    for (int c = 0; c < board[i].length;c++){
		if (board[i][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
    }

    public int countSolutions(int startingRow, int startingCol){
	
    }
}
