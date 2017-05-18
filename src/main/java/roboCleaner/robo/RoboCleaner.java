package roboCleaner.robo;

import roboCleaner.domain.Direction;
import roboCleaner.domain.Point;
import roboCleaner.domain.RoomGrid;

public class RoboCleaner {
	
	private Point location;
	private RoomGrid room;
	private int cleanCounter;

	public int getCleanCounter() {
		return cleanCounter;
	}

	public RoboCleaner(RoomGrid room) {
		this(room, new Point(0,0));
	}

	public RoboCleaner(RoomGrid roomGrid, Point point) {
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

	public Point getLocation() {
		return location;
	}

	public void moveAndClean(Direction d) {
		Point possibleNewPoint = d.go(location);
		if ( room.insideTheRoom(possibleNewPoint)) {
			location = possibleNewPoint;
			cleanLocation(location);
		}
	}

	public void move(Direction d) {
		Point possibleNewPoint = d.go(location);
		if ( room.insideTheRoom(possibleNewPoint)) {
			location = possibleNewPoint;
		}
	}
	
	public void cleanLocation(Point needsCleaning){
		if (room.cleanLocation(needsCleaning)) {
			this.cleanCounter++;
		}
	}
	public boolean isLocationDirty() {
		return  room.isDirty(getLocation());
	}

}
