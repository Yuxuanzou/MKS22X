public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private double distance,distanceSoFar;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location other){
	return (this.getX() + this.getY()) - (other.getX() + other.getY());
    }
}
