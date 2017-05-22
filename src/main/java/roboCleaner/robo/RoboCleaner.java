package roboCleaner.robo;

import roboCleaner.domain.Direction;
import roboCleaner.domain.Point;
import roboCleaner.domain.Room;

public class RoboCleaner implements Cleaner {
	
	private Point location;
	private Room room;
	private int cleanCounter;

	/* (non-Javadoc)
	 * @see roboCleaner.robo.Cleaner#getCleanCounter()
	 */
	@Override
	public int getCleanCounter() {
		return cleanCounter;
	}

	public RoboCleaner(Room room) {
		this(room, new Point(0,0));
	}

	public RoboCleaner(Room roomGrid, Point point) {
		if ( point.getX() < 0 ||
				point.getX() > roomGrid.getRoomDimensions() - 1){
			point.setX(0);
		}
		
		if ( point.getY() < 0  ||
				point.getY() > roomGrid.getRoomDimensions() - 1){
			point.setY(0);
		}
		this.location = point;
		this.room = roomGrid;
	}

	/* (non-Javadoc)
	 * @see roboCleaner.robo.Cleaner#getLocation()
	 */
	@Override
	public Point getLocation() {
		return location;
	}

	/* (non-Javadoc)
	 * @see roboCleaner.robo.Cleaner#moveAndClean(roboCleaner.domain.Direction)
	 */
	@Override
	public void moveAndClean(Direction d) {
		Point possibleNewPoint = d.go(location);
		if ( room.insideTheRoom(possibleNewPoint)) {
			location = possibleNewPoint;
			cleanLocation(location);
		}
	}

	/* (non-Javadoc)
	 * @see roboCleaner.robo.Cleaner#move(roboCleaner.domain.Direction)
	 */
	@Override
	public void move(Direction d) {
		Point possibleNewPoint = d.go(location);
		if ( room.insideTheRoom(possibleNewPoint)) {
			location = possibleNewPoint;
		}
	}
	
	/* (non-Javadoc)
	 * @see roboCleaner.robo.Cleaner#cleanLocation(roboCleaner.domain.Point)
	 */
	@Override
	public void cleanLocation(Point needsCleaning){
		if (room.cleanLocation(needsCleaning)) {
			this.cleanCounter++;
		}
	}
	/* (non-Javadoc)
	 * @see roboCleaner.robo.Cleaner#isLocationDirty()
	 */
	@Override
	public boolean isLocationDirty() {
		return  room.isDirty(getLocation());
	}

}
