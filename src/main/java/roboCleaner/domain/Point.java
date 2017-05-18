package roboCleaner.domain;

public class Point {

	private int x;
	private int y;
	
	public Point( int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) {
			return true;
		}
		
		if (!( obj instanceof Point )) {
			return false;
		}
		Point p = (Point) obj;
		if ( this.x != p.x ) {
			return false;
		}
		if ( this.y != p.y ) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + x;
		result = result * 31 + y;
		return result;
	}
	@Override
	public String toString() {
		return " x = " + this.x + " y = " + this.y;
	}
	
}
