public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    
    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

  //Default to BFS
    public boolean solve(){ return solve(0); }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	boolean aStar;
	if (mode == 0){
	    frontier = new FrontierQuene();
	    aStar = false;
	}
	else if (mode == 1){
	    frontier = new FrontierStack();
	    aStar = false;
	}
	else if (mode == 2){
	    frontier = new FrontierPriorityQuene();
	    maze.setAStar(false);
	}
	else if (mode == 3){
	    frontier = new FrontierPriorityQuene();
	    maze.setAStar(true);
	}
	frontier.add(maze.getStart());
	Location current = null;
	while(frontier.hasNext()){
	    if(animate){
		clearTerminal();
		System.out.println(this);
		wait(50);
	    }
	    current = frontier.next();
	    if (checkEnd(current,maze.getEnd())){
		current = current.getPrev();
		while(current.getPrev() != null){
		    maze.set(current.getX(),current.getY(),'@');
		    current = current.getPrev();
		}
		maze.set(current.getX(),current.getY(),'@');
		maze.set(maze.getEnd().getX(),maze.getEnd().getY(),'E');
		return true;
	    }
	    maze.set(current.getX(),current.getY(),'.');
	    Location[] neighbors = maze.getNeighbors(current);
	    for (int i = 0;i < neighbors.length;i++){
		if (neighbors[i] != null){
		    if (neighbors[i].equals(maze.getEnd())){
		      return true;
		    }
		    else{
			frontier.add(neighbors[i]);
			maze.set(neighbors[i].getX(),neighbors[i].getY(),'?');
		    }
		}
	    }
	}
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	return false;
    }
    
    private boolean checkEnd(Location a, Location b){
	return (a.getX() == b.getX() && a.getY() == b.getY());
    }
    
    public String toString(){
	return maze.toStringColor();
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
    
    /*public static void main(String[] args){
	MazeSolver x = new MazeSolver("maze1.txt");
	x.setAnimate(true);
	System.out.println(x.solve(0));
	System.out.println(x);
    }
    */
}
