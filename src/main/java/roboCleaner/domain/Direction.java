package roboCleaner.domain;


public class Direction {
	
	private int xIncrement;
	private int yIncrement;
	
	public Direction( int xInc, int yInc) {
		xIncrement = xInc;
		yIncrement = yInc;
	}
	
	public Point go(Point p ) {
		return new Point( p.getX() + xIncrement, p.getY() + yIncrement);
	}

}
