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
    	//assertEquals( res.getCoords())
        
	
	
	}

}
