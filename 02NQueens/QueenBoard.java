public class QueenBoard{
    private int[][] board;
    private int size;

    public QueenBoard(int size){
    this.size = size;
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
	if (board[r][c] == 0){
	    board[r][c] = -1;
        setThreat(r,c);
	    return true;
	}
	return false;
    }
    
    private void setThreat(int r, int c){
        if (r > 0 && r < board.length && c < board[r].length){
        for (int col = c + 1;col < board[r].length;col++){
            board[r][col] += 1;
        }
        for (int row = r + 1, col = c + 1;row < board.length && col < board[row].length; row++,col++){
            board[row][col] += 1;
        }
        }
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    board[r][c] = 0;
        removeThreat(r,c);
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
    
    public boolean solve(){
        return solverHelper(size,0,0,0);
    }
    
    public boolean solverHelper(int n,int r, int c, int numOfQueens){
        if (numOfQueens == n){
            return true;
        }
        for (int col = c; c < board[r].length;c++){
            if (addQueen(r,col)){
                return solverHelper(n,r+1,c + 1,numOfQueens + 1);
            }
            else {
                removeQueen(r,col);
                return solverHelper(n,r, c - 1,numOfQueens - 1)
            }
        }
        return false;
    }


    public static void main(String[] args){
        QueenBoard g = new QueenBoard(10);
        g.solve();
        System.out.println(g);
    }
}
