package Chapter8;

public class Point{
	private double x;
	private double y;
	
	public Point(int x, int  y){
		this.x = x;
		this.y = y;
	}
	
	public Point(double x, double  y){
		this.x = x;
		this.y = y;
	}
	
	public int getIntX() {
		return (int) x;
	}
	
	public int getIntY() {
		return (int) y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object p){
		return x == ((Point)p).x && y == ((Point)p).y;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
