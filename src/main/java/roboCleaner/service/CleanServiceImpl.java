package roboCleaner.service;

import roboCleaner.core.Message;
import roboCleaner.core.ResponseMessage;
import roboCleaner.domain.Point;
import roboCleaner.domain.RoomGrid;
import roboCleaner.robo.DirectionsFactory;
import roboCleaner.robo.RoboCleaner;



public class CleanServiceImpl implements CleanService {

	@Override
	public ResponseMessage cleanRoom(Message request) {
		int[] roomDimension =  request.getRoomSize();
	    int[] startingPoint = request.getCoords();
	    int[][] patch = request.getPatches();
	    String instructions = request.getInstructions();
	    RoomGrid dirtyRoom = new RoomGrid(roomDimension[0]);
	    RoboCleaner rc =
				 new RoboCleaner(dirtyRoom, 
						 new Point(startingPoint[0],startingPoint[1]));
	    
	    for ( int[] dirty : patch) {
	    	dirtyRoom.setDirtyLocation(new Point( dirty[0], dirty[1]));
	    }
	    
	    String[]  direction = instructions.split("[A-Z]");
	    for ( String move : direction) {
	    	rc.move(DirectionsFactory.getInstance(move));
	    }
	    
	    Point p = rc.getLocation();
	    return new ResponseMessage(new int[] { p.getX(), p.getY()}
	    	, rc.getCleanCounter());
	    
	}

}
