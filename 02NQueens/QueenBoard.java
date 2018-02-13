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
        for (int i = 1;c + i < board.length;i++){
            board[r][c + i] += 1;
            if (r + i <= board.length - 1){
            board[r + i][c + i] += 1;
            }
            if (r - i >= 0){
            board[r - i][c + i] += 1;
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
        for (int i = 1;c + i < board.length;i++){
            board[r][c + i] -= 1;
            if (r + i <= board.length - 1){
            board[r + i][c + i] -= 1;
            }
            if (r - i >= 0){
            board[r - i][c + i] -= 1;
            }
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
	for (int i = 0;i < board.length;i++){
            for (int c = 0;c < board[i].length;c++){
                if (board[i][c] != 0){
                    throw new IllegalStateException();
                }
            }
        }
        return countHelper(0,0);
    }
    
    public int countHelper(int r, int c){
	if (c == board.length){
        numOfSolutions += 1;
        return numOfSolutions;
    }
        for (int i = 0; i < board.length;i++){
            if (addQueen(i,c)){
                countHelper(i,c + 1);
                removeQueen(i,c);
            }
        }
        return numOfSolutions;
    }

    /*
    public void clear(){
        for (int i = 0;i < board.length; i++){
            for (int c = 0;c < board[i].length;c++){
                board[i][c] = 0;
            }
        }
    }
    
    
    public static void main(String[] args){
    QueenBoard b = new QueenBoard(4);

    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
      /*          Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      */ /*
      System.out.println(a); //prints out an empty i by i grid of underscores
      */
}
