import java.util.*;
import java.io.*;

public class Maze {
    private char[][] Maze;
    private int col;
    private int row;
    private boolean animate;
    private int xcorOfS;
    private int ycorOfS;

    public Maze(String file){
	animate = false;
	try {
	    File f = new File(file);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String line = in.nextLine();
	        row += 1;
		col = line.length();
	    }
	    Maze = new char[row][col];
	    Scanner out = new Scanner(f);
	    int r = 0;
	    while (out.hasNext()){
		String outLine = out.nextLine();
		for (int c = 0;c < outLine.length();c++){
		    if (Maze[r][c] == 'S'){
			xcorOfS = c;
			ycorOfS = r;
		    }
		    Maze[r][c] = outLine.charAt(c);
		}
		r += 1;
	    }
	} catch (FileNotFoundException e){
	}
    }

    public String toString(){
	String str = "";
	for (int i = 0;i < row;i++){
	    for (int c = 0;c < col;c++){
		str += Maze[i][c];
	    }
	    str += "\n";
	}
	return str;
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){	
	animate = b;
    }
    
    public void clearTerminal(){
	//erase terminal, go to top left of screen.
	System.out.println("\033[2J\033[1;1H");
    }
    
    public static void main(String[]args){
        Maze f;
        f = new Maze("Maze1.txt");//true animates the maze.

        System.out.println(f);
    }
}
