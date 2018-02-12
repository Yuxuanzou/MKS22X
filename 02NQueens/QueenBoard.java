import java.util.ArrayList;
public class QueenBoard{
    private int[][] board;
    private int size;
    private int numOfSolutions;

    public QueenBoard(int size){
    this.size = size;
	board = new int[size][size];
        for (int i = 0;i < board.length;i++){
            for (int c = 0;c < board[i].length;c++){
                board[i][c] = 0;
            }
        }
     numOfSolutions = 0;
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
        for (int col = c + 1;col < board[r].length;col++){
            board[r][col] += 1;
        }
        for (int row = r + 1,col = c + 1;row < board.length && col < board[r].length;row++,col++){
            board[row][col] += 1;
        }
        for (int row = r - 1,col = c + 1;row >= 0 && col < board[r].length;row--,col++){
            board[row][col] += 1;
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
        for (int col = c + 1;col < board[r].length;col++){
            board[r][col] -= 1;
        }
        for (int row = r + 1,col = c + 1;row < board.length && col < board[r].length;row++,col++){
            board[row][col] -= 1;
        }
        for (int row = r - 1,col = c + 1;row > 0 && col < board[r].length;row--,col++){
            board[row][col] -= 1;
        }
    }
    
    public boolean solve(){
        for (int i = 0;i < board.length;i++){
            for (int c = 0;c < board[i].length;c++){
                if (board[i][c] != 0){
                    throw new IllegalStateException();
                }
            }
        }
        return solverHelper(0,0);
    }
    
    public boolean solverHelper(int r, int c){
        if (c == board.length){
            return true;
        }
        for (int i = 0; i < board.length;i++){
            if (addQueen(i,c)){
                if (solverHelper(r,c + 1)){
                    return true;
                }
                removeQueen(i,c);
            }
        }
        return false;
    }
    
    public int countSolutions(){
        return countHelper(0,0);
    }
    
    public int countHelper(int r, int c){
	if (c == board.length){
	    clear();
            numOfSolutions += 1;
        }
        for (int i = 0; i < board.length;i++){
            if (addQueen(i,c)){
                if (solverHelper(i,c + 1)){
                    continue;
                }
                removeQueen(i,c);
            }
        }
        return numOfSolutions;
    }
    
    public void clear(){
        for (int i = 0;i < board.length; i++){
            for (int c = 0;c < board[i].length;c++){
                board[i][c] = 0;
            }
        }
    }

    public static void main(String[] args){
        QueenBoard g = new QueenBoard(7);
        System.out.println(g.solve());
     System.out.println(g);
     g.clear();
        System.out.println(g.countSolutions());
    }
}
