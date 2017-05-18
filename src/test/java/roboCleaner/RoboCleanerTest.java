package roboCleaner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import roboCleaner.domain.Direction;
import roboCleaner.domain.Point;
import roboCleaner.domain.RoomGrid;
import roboCleaner.robo.DirectionsFactory;
import roboCleaner.robo.RoboCleaner;

public class RoboCleanerTest {

	@Test
	public void checkGridDimensionsAreCorrectTest() {
		RoomGrid room = new RoomGrid(5);
		assertEquals(5, room.getRoomDimensions());
	}
	
	@Test
	public void testRoomIsClean(){
		RoomGrid room = new RoomGrid(5);
		assertTrue( room.isAllClean());
	}
	
	@Test
	public void testForDirtyRoom() {
		RoomGrid dirtyRoom = new RoomGrid(5);
		dirtyRoom.setDirtyLocation(1,1);
		assertFalse( dirtyRoom.isAllClean());
	}
	
	@Test
	public void setDirtyLocationOutsideGridTest() {
		RoomGrid staysClean = new  RoomGrid(5);
		boolean didItBecomeDirty = staysClean.setDirtyLocation(12,12);
		assertFalse(didItBecomeDirty);
		
		boolean tryAgain = staysClean.setDirtyLocation(-1, -1);
		assertFalse(tryAgain);
	}
	
	@Test
	public void createRobotWithNoInitialLocation() {
		RoboCleaner cleanerRobot = new RoboCleaner(new RoomGrid(5));
		Point initial = cleanerRobot.getLocation();
		assertEquals( initial, new Point(0,0));
	}
	
	@Test
	public void createRobotWithRoomAndInitialLocation(){
		RoboCleaner rc = new RoboCleaner(new RoomGrid(5), new Point(2,2));
		Point initialPlace = rc.getLocation();
		assertEquals(initialPlace, new Point(2,2));
	}
	
	@Test
	public void createRobotWithIncorrectDimensions() {
		RoboCleaner rc = new RoboCleaner(new RoomGrid(2), new Point(4,4));
		Point initialPlace = rc.getLocation();
		assertEquals(initialPlace, new Point(0,0));
	}
	
	@Test
	public void sendRobotInDirection() {
		RoboCleaner rc =
				 new RoboCleaner(new RoomGrid(5), new Point(2,2));
		Direction east = DirectionsFactory.getInstance("EAST");
		rc.move(east);
		assertEquals(rc.getLocation(), new Point(3,2));
	}
	
	@Test
	public void sendRobotTwoSteps() {
		RoboCleaner rc =
				 new RoboCleaner(new RoomGrid(5), new Point(2,2));
		Direction east = DirectionsFactory.getInstance("EAST");
		rc.move(east);
		rc.move(east);
		assertEquals(rc.getLocation(), new Point(4,2));
	}
	
	@Test
	public void sendRobotTooFar() {
		
		RoboCleaner rc =
				 new RoboCleaner(new RoomGrid(5), new Point(0,0));
		Direction west = DirectionsFactory.getInstance("WEST");
		rc.move(west);
		assertEquals(rc.getLocation(), new Point(0,0));
		assertTrue(new RoomGrid(5).insideTheRoom(rc.getLocation()));
	}
	
	@Test
	public void makeRoomDirtyAndThenCleanItTest() {
		RoomGrid possiblyDirty = new RoomGrid(3);
		Point dirtyPoint = new Point(2,2);
		possiblyDirty.setDirtyLocation(2, 2);
		RoboCleaner rc =
				 new RoboCleaner(possiblyDirty, dirtyPoint);
		boolean somethingCleaned = rc.isLocationDirty();
		assertTrue(somethingCleaned);
		
	}

	@Test
	public void makeRoomHaveNothingDirtyThenCleanItTest() {
		RoomGrid noDirt = new RoomGrid(3);
		noDirt.setDirtyLocation(2, 2);
		RoboCleaner rc =
				 new RoboCleaner(noDirt);
		boolean somethingCleaned = rc.isLocationDirty();
		assertFalse(somethingCleaned);
		
	}
	
	@Test
	public void dirtyRoomIsCleanedAndThenCheckCount() {
		RoomGrid dirty = new RoomGrid(7);
		dirty.setDirtyLocation(1, 0);
		dirty.setDirtyLocation(2, 0);
		RoboCleaner rc = new RoboCleaner(dirty);
		boolean somethingNeedsCleaning = rc.isLocationDirty();
		assertFalse(somethingNeedsCleaning);
		rc.moveAndClean(DirectionsFactory.getInstance("EAST"));
		somethingNeedsCleaning = rc.isLocationDirty();
		assertFalse(somethingNeedsCleaning);
		assertTrue(rc.getCleanCounter() == 1);
		rc.moveAndClean(DirectionsFactory.getInstance("EAST"));
		assertTrue(rc.getCleanCounter() == 2);
		rc.moveAndClean(DirectionsFactory.getInstance("EAST"));
		assertTrue(rc.getCleanCounter() == 2);
		rc.moveAndClean(DirectionsFactory.getInstance("EAST"));
		assertTrue(rc.getCleanCounter() == 2);
	}

}
