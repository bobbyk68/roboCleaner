package roboCleaner.domain;

public interface Room {

	int getRoomDimensions();

	boolean isAllClean();

	boolean cleanLocation(Point cleanLocation);

	boolean setDirtyLocation(Point p);

	boolean insideTheRoom(Point stillInside);

	boolean isDirty(Point point);

}