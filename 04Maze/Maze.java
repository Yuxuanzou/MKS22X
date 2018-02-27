import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Maze {
    private char[][] Maze;
    private int col;
    private int row;

    public Maze(String file){
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
    public static void main(String[] args){
	Maze g = new Maze("Maze1.txt");
	System.out.println(g);
    }
}
