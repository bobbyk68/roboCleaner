package roboCleaner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import roboCleaner.core.Message;
import roboCleaner.core.ResponseMessage;
import roboCleaner.service.CleanService;
import roboCleaner.service.CleanServiceImpl;

public class CleanServiceImplTest {

	@Test
	public void testSimpleRequest() {

		int[] room =  { 5, 5};
    	int[] coords = {0, 0};
    	int[][] patch = { {1,0}, {2, 0} };
        
    	CleanService clean = new CleanServiceImpl();
    	ResponseMessage res = clean.cleanRoom(new Message(room, coords, patch, "EE"));
    	assertEquals(2,  res.getPatches());
    	int[] finalPlace = res.getCoords();
    	assertEquals(2, finalPlace[0]);
    	assertEquals(0, finalPlace[1]);
	}
	
	@Test 
	public void badOriginalLocationTest() {
		int[] room = { 3, 3 };
		int[] coords = { 5, 5};
		int[][] patch = { {1,0}, {2, 0} };
        
    	CleanService clean = new CleanServiceImpl();
    	ResponseMessage res = clean.cleanRoom(new Message(room, coords, patch, "E"));
    	assertEquals(1,  res.getPatches());
    	int[] finalPlace = res.getCoords();
    	assertEquals(1, finalPlace[0]);
    	assertEquals(0, finalPlace[1]);
		
	}
	
	@Test 
	public void noMovementOfRobotTest() {
		int[] room = { 5, 5 };
		int[] coords = { 0, 0};
		int[][] patch = { {0,0} };
        
    	CleanService clean = new CleanServiceImpl();
    	ResponseMessage res = clean.cleanRoom(new Message(room, coords, patch, ""));
    	assertEquals(1,  res.getPatches());
    	int[] finalPlace = res.getCoords();
    	assertEquals(1, finalPlace[0]);
    	assertEquals(0, finalPlace[0]);
		
	}
	
	

}
