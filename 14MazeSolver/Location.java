public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceNeeded,distanceSoFar;
    private boolean aStar;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }
    public Location(int _x, int _y, Location prev,int s,int f,boolean a){
	x = _x;
	y = _y;
	previous = prev;
	distanceSoFar = s;
	distanceNeeded = f;
	aStar = a;
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

    public int getDistanceNeeded(){
	return distanceNeeded;
    }

    public int getDistanceSoFar(){
	return distanceSoFar;
    }

    public int compareTo(Location other){
	if (aStar){
	    return (getDistanceNeeded() + getDistanceSoFar()) - (other.getDistanceNeeded() + other.getDistanceSoFar());
	}
	return (getDistanceNeeded() - other.getDistanceNeeded());
    }
}
