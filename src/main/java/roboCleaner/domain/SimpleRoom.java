package roboCleaner.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleRoom implements Room {
	
	private int[][] grid;
	private int dimension;
	
	public SimpleRoom(int dimension) {
			grid = new int[dimension][dimension];
			this.dimension = dimension;
	}
	
	/* (non-Javadoc)
	 * @see roboCleaner.domain.Room#getRoomDimensions()
	 */
	@Override
	public int getRoomDimensions() {
		return dimension;
	}
	
	/* (non-Javadoc)
	 * @see roboCleaner.domain.Room#isAllClean()
	 */
	@Override
	public boolean isAllClean(){
		IntStream stream = Arrays.stream(grid).flatMapToInt(x -> Arrays.stream(x));
		boolean stillDirty = stream.anyMatch(x -> x == 1);
		return !stillDirty;
	}
	
	/* (non-Javadoc)
	 * @see roboCleaner.domain.Room#cleanLocation(roboCleaner.domain.Point)
	 */
	@Override
	public boolean cleanLocation(Point cleanLocation) {
		if ( cleanLocation.getX() < 0 || cleanLocation.getX() > dimension - 1 ) {
			return false;
		}
		if ( cleanLocation.getY() < 0 || cleanLocation.getY() > dimension - 1 ) {
			return false;
		}
		if ( grid[cleanLocation.getX()][cleanLocation.getY()] == 1) {
			grid[cleanLocation.getX()][cleanLocation.getY()] = 0;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see roboCleaner.domain.Room#setDirtyLocation(roboCleaner.domain.Point)
	 */
	@Override
	public boolean setDirtyLocation(Point p) {
		if (p.getX() < 0 || p.getX() > dimension - 1 ) {
			return false;
		}
		
		if ( p.getY() < 0 || p.getY() > dimension -1 ) {
			return false;
		}
		grid[p.getX()][p.getY()] = 1;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see roboCleaner.domain.Room#insideTheRoom(roboCleaner.domain.Point)
	 */
	@Override
	public boolean insideTheRoom(Point stillInside) {
		if( stillInside.getX() < 0 || stillInside.getX() > dimension - 1){
			return false;
		}
		if( stillInside.getY() < 0 || stillInside.getY() > dimension - 1){
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see roboCleaner.domain.Room#isDirty(roboCleaner.domain.Point)
	 */
	@Override
	public boolean isDirty(Point point) {
		return ( grid[point.getX()][point.getY()] == 1) ? true : false; 
	}

}
