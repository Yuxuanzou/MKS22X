public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
        for (int i = 0;i < board.length;i++){
            for (int c = 0;c < board[i].length;c++){
                board[i][c] = 0;
            }
        }
    }

    public String toString(){
	String str = "";
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		if (board[i][c] == -1){
		    if (c == board.length - 1){
			str += "Q\n";
		    }
		    else {
			str += "Q ";
		    }
		}
		else {
		    if (c == board.length - 1){
			str += "_\n";
		    }
		    else {
			str += "_ ";
		    }
		}
	    }
	}
	return str;
    }

    private boolean addQueen(int r, int c){
	if (board[r][c] > 0){
	    board[r][c] = -1;
	    return true;
	}
	return false;
    }
    
    private void setThreat(int r, int c){
        for (int col = c;col < board[col].length;col++){
            board[r][col] += 1;
        }
        for (int row = r, col = c;row < board.length && col < board[row].length; row++,col++){
            board[row][col] += 1;
        }
        for (int row = r, col = c;row < board.length && col < board[row].length; row--,col++){
            board[row][col] += 1;
        }
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    board[r][c] = 0;
	    return true;
	}
	return false;
    }
    
    private void removeThreat(int r, int c){
        for (int col = c;col < board[col].length;col++){
            board[r][col] -= 1;
        }
        for (int row = r, col = c;row < board.length && col < board[row].length; row++,col++){
            board[row][col] -= 1;
        }
        for (int row = r, col = c;row < board.length && col < board[row].length; row--,col++){
            board[row][col] -= 1;
        }
    }


    public static void main(String[] args){
        QueenBoard g = new QueenBoard(4);
        System.out.println(g);
    }
}
