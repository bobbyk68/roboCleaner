package roboCleaner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import roboCleaner.domain.Direction;
import roboCleaner.domain.Point;
import roboCleaner.domain.Room;
import roboCleaner.domain.SimpleRoom;
import roboCleaner.robo.Cleaner;
import roboCleaner.robo.DirectionsFactory;
import roboCleaner.robo.RoboCleaner;

public class RoboCleanerTest {

	@Test
	public void checkGridDimensionsAreCorrectTest() {
		Room room = new SimpleRoom(5);
		assertEquals(5, room.getRoomDimensions());
	}
	
	@Test
	public void testRoomIsClean(){
		Room room = new SimpleRoom(5);
		assertTrue( room.isAllClean());
	}
	
	@Test
	public void testForDirtyRoom() {
		Room dirtyRoom = new SimpleRoom(5);
		dirtyRoom.setDirtyLocation(new Point(1,1));
		dirtyRoom.setDirtyLocation(new Point(2,2));
		assertFalse( dirtyRoom.isAllClean());
	}
	
	@Test
	public void setDirtyLocationOutsideGridTest() {
		Room staysClean = new  SimpleRoom(5);
		boolean didItBecomeDirty = staysClean.setDirtyLocation(new Point(12,12));
		assertFalse(didItBecomeDirty);
		
		boolean tryAgain = staysClean.setDirtyLocation(new Point(-1, -1));
		assertFalse(tryAgain);
	}
	
	@Test
	public void createRobotWithNoInitialLocation() {
		Cleaner cleanerRobot = new RoboCleaner(new SimpleRoom(5));
		Point initial = cleanerRobot.getLocation();
		assertEquals( initial, new Point(0,0));
	}
	
	@Test
	public void createRobotWithRoomAndInitialLocation(){
		Cleaner rc = new RoboCleaner(new SimpleRoom(5), new Point(2,2));
		Point initialPlace = rc.getLocation();
		assertEquals(initialPlace, new Point(2,2));
	}
	
	@Test
	public void createRobotWithIncorrectDimensions() {
		Cleaner rc = new RoboCleaner(new SimpleRoom(2), new Point(4,4));
		Point initialPlace = rc.getLocation();
		assertEquals(initialPlace, new Point(0,0));
	}
	
	@Test
	public void sendRobotInDirection() {
		Cleaner rc =
				 new RoboCleaner(new SimpleRoom(5), new Point(2,2));
		Direction east = DirectionsFactory.getInstance("E");
		rc.move(east);
		assertEquals(rc.getLocation(), new Point(3,2));
	}
	
	@Test
	public void sendRobotWrongMessage() {
		Cleaner rc =
				 new RoboCleaner(new SimpleRoom(5), new Point(2,2));
		Direction east = DirectionsFactory.getInstance("EAST");
		rc.move(east);
		assertEquals(rc.getLocation(), new Point(2,2));
	}
	
	@Test
	public void sendRobotTwoSteps() {
		Cleaner rc =
				 new RoboCleaner(new SimpleRoom(5), new Point(2,2));
		Direction east = DirectionsFactory.getInstance("E");
		rc.move(east);
		rc.move(east);
		assertEquals(rc.getLocation(), new Point(4,2));
	}
	
	@Test
	public void sendRobotTooFar() {
		
		Cleaner rc =
				 new RoboCleaner(new SimpleRoom(5), new Point(0,0));
		Direction west = DirectionsFactory.getInstance("W");
		rc.move(west);
		assertEquals(rc.getLocation(), new Point(0,0));
		assertTrue(new SimpleRoom(5).insideTheRoom(rc.getLocation()));
	}
	
	@Test
	public void makeRoomDirtyAndThenCleanItTest() {
		Room possiblyDirty = new SimpleRoom(3);
		Point dirtyPoint = new Point(2,2);
		possiblyDirty.setDirtyLocation(new Point(2, 2));
		Cleaner rc =
				 new RoboCleaner(possiblyDirty, dirtyPoint);
		boolean somethingCleaned = rc.isLocationDirty();
		assertTrue(somethingCleaned);
		
	}

	@Test
	public void makeRoomHaveNothingDirtyThenCleanItTest() {
		Room noDirt = new SimpleRoom(3);
		noDirt.setDirtyLocation(new Point(2, 2));
		Cleaner rc =
				 new RoboCleaner(noDirt);
		boolean somethingCleaned = rc.isLocationDirty();
		assertFalse(somethingCleaned);
		
	}
	
	@Test
	public void dirtyRoomIsCleanedAndThenCheckCount() {
		Room dirty = new SimpleRoom(7);
		dirty.setDirtyLocation(new Point(1, 0));
		dirty.setDirtyLocation(new Point(2, 0));
		Cleaner rc = new RoboCleaner(dirty);
		boolean somethingNeedsCleaning = rc.isLocationDirty();
		assertFalse(somethingNeedsCleaning);
		rc.moveAndClean(DirectionsFactory.getInstance("E"));
		somethingNeedsCleaning = rc.isLocationDirty();
		assertFalse(somethingNeedsCleaning);
		assertTrue(rc.getCleanCounter() == 1);
		rc.moveAndClean(DirectionsFactory.getInstance("E"));
		assertTrue(rc.getCleanCounter() == 2);
		rc.moveAndClean(DirectionsFactory.getInstance("E"));
		assertTrue(rc.getCleanCounter() == 2);
		rc.moveAndClean(DirectionsFactory.getInstance("E"));
		assertTrue(rc.getCleanCounter() == 2);
	}

}
