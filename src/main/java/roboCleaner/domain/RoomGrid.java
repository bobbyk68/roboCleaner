package roboCleaner.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RoomGrid {
	
	private int[][] grid;
	private int dimension;
	
	public RoomGrid(int dimension) {
			grid = new int[dimension][dimension];
			this.dimension = dimension;
	}
	
	public int getRoomDimensions() {
		return dimension;
	}
	
	public boolean isAllClean(){
		IntStream stream = Arrays.stream(grid).flatMapToInt(x -> Arrays.stream(x));
		boolean stillDirty = stream.anyMatch(x -> x == 1);
		return !stillDirty;
	}
	
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

	public boolean setDirtyLocation(int i, int j) {
		if (i < 0 || i > dimension - 1 ) {
			return false;
		}
		
		if ( j < 0 || j > dimension -1 ) {
			return false;
		}
		grid[i][j] = 1;
		return true;
	}
	
	public boolean insideTheRoom(Point stillInside) {
		if( stillInside.getX() < 0 || stillInside.getX() > dimension - 1){
			return false;
		}
		if( stillInside.getY() < 0 || stillInside.getY() > dimension - 1){
			return false;
		}
		return true;
	}
	
	public boolean isDirty(Point point) {
		return ( grid[point.getX()][point.getY()] == 1) ? true : false; 
	}

}
