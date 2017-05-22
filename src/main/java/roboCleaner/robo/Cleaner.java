package roboCleaner.robo;

import roboCleaner.domain.Direction;
import roboCleaner.domain.Point;

public interface Cleaner {

	int getCleanCounter();

	Point getLocation();

	void moveAndClean(Direction d);

	void move(Direction d);

	void cleanLocation(Point needsCleaning);

	boolean isLocationDirty();

}