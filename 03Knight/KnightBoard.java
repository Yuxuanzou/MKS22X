public class KnightBoard {
    private int[][] board;
    private int[] x;
    private int[] y;
    private int maxRow;
    private int maxCol;
    private int numOfSolutions;
    
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
	x = new int[] {-1,-1,1,1,-2,-2,2,2};
	y = new int[] {-2,2,-2,2,-1,1,-1,1};
	maxRow = startingRows;
	maxCol = startingCols;
    }

    public String toString(){
	String str = "";
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		if (board[i][c] == 0){
		    str += "_ ";
		}
		else if (board[i][c] < 10 && board[i][c] >= 1){
		    str += "_" + board[i][c] + " ";
		}
		else {
		    str += "" + board[i][c] + " ";
		}
	    }
	    str += "\n";
	}
	return str;
    }

    public boolean checkBoard(){
	for (int i = 0; i < board.length;i++){
	    for (int c = 0; c < board[i].length;c++){
		if (board[i][c] != 0){
		    return false;
		}
	    }
	}
	return true;
    }
    
    public boolean solve(int startingRow, int startingCol){
        if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
	    throw new IllegalArgumentException();
	}
        else if (checkBoard() == false){
	    throw new IllegalStateException();
	}
	return solveHelper(startingRow, startingCol, 1);
    }

    public boolean solveHelper(int row,int col,int count){
	if (count == (maxRow * maxCol)){
	    board[row][col] = count;
	    return true;
	}
	for (int i = 0;i < x.length;i++){
	    board[row][col] = count;
	    try {
		if (board[row + x[i]][col + y[i]] == 0){
		    if (solveHelper(row + x[i],col + y[i],count + 1)){
			return true;
		    }
		    board[row + x[i]][col + y[i]] = 0;
		}
	    } catch (ArrayIndexOutOfBoundsException e){
	    }
	}
	board[row][col] = count;
	return false;
    }

    public void clear(){
	for (int i = 0;i < board.length;i++){
	    for (int c = 0;c < board[i].length;c++){
		board[i][c] = 0;
	    }
	}
    }
    
    public int countSolutions(int startingRow, int startingCol){
	if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
	    throw new IllegalArgumentException();
	}
        else if (checkBoard() == false){
	    throw new IllegalStateException();
	}
	numOfSolutions = 0;
	numOfSolutions = helperCount(startingRow,startingCol,1);
	board[startingRow][startingCol] = 0;
	return numOfSolutions;
    }

    public int helperCount(int row,int col, int count){
	if (count == (maxRow * maxCol)){
	    numOfSolutions += 1;
	    return numOfSolutions;
	}
	for (int i = 0;i < x.length;i++){
	    board[row][col] = count;
	    try {
		if (board[row + x[i]][col + y[i]] == 0){
		    helperCount(row + x[i],col + y[i],count + 1);
		    board[row + x[i]][col + y[i]] = 0;
		}
	    } catch (ArrayIndexOutOfBoundsException e){
	    }
	}
	return numOfSolutions;
    }

    /*
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3,3);

    System.out.println(a);
     Prints
      _ _ _
      _ _ _
      _ _ _

    try{
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (a.solve(i,j)){
          System.out.println("There is an error with your solve method");
        }
      }
    }} catch (IllegalStateException e){
    }//prints nothing
    try{
    System.out.println(a.countSolutions(0,0)); //prints 0
    } catch (IllegalStateException e){
    }



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
    
    try{
	b.countSolutions(0,0);
    }catch(IllegalStateException e){
	System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    
    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    


    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
    }
    
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
	  totalSol += c.countSolutions(i,j);
      }
    }

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
    System.out.println(d.countSolutions(0,0)); //prints 304
  }*/
}
