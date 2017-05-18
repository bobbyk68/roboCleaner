package robo;

import roboCleaner.domain.Point;

public class Direction {
	
	private int xIncrement;
	private int yIncrement;
	
	Direction( int xInc, int yInc) {
		xIncrement = xInc;
		yIncrement = yInc;
	}
	
	public Point go(Point p ) {
		return new Point( p.getX() + xIncrement, p.getY() + yIncrement);
	}

}
