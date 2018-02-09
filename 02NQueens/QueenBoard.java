public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public String toString(){
	String str = "";
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		if (board[i][c] == 0 || board[i][c] == 1){
		    if (c == board.length - 1){
			str += "_\n";
		    }
		    else {
			str += "_ ";
		    }
		}
		else {
		    str += "Q "; 
		}
	    }
	}
	return str;
    }

    private boolean addQueen(int r, int c){
	if (board[r][c] == 0 || board[r][c] == -1){
	    board[r][c] = -1;
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    board[r][c] = 0;
	    return true;
	}
	return false;
    }

    public static void main(String[] args){
    }
}
