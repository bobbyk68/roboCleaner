package roboCleaner;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;
import roboCleaner.core.Message;
import roboCleaner.resources.CleanRoomServiceResource;


public class ServiceTest {
	
	@Rule
    public ResourceTestRule resource = ResourceTestRule.builder()
            .addResource(new CleanRoomServiceResource()).build();

    @Test
    public void testGetGreeting() {
        String expected = "I am alive!";
        //Obtain client from @Rule.
        Client client = resource.client();
        WebTarget helloTarget = client.target("http://localhost:8080/clean");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = helloTarget.request(MediaType.TEXT_PLAIN);
        Response response = builder.get();
        assertEquals(Response.Status.OK, response.getStatusInfo());
        String actual = response.readEntity(String.class);
        assertEquals(expected, actual);

    }
    
    @Test
    public void sendJSONMessage() {
    	
    	//Obtain client from @Rule.
        Client client = resource.client();
        //Get WebTarget from client using URI of root resource.
        WebTarget target = client.target("http://localhost:8080/clean");
        
        int[] room =  { 5, 5};
    	int[] coords = {2, 1};
    	int[][] patch = { {1,0}, {2, 0} };
        String response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(new Message(room, coords, patch, "NEWSW")), String.class);
        
        System.out.println(response);
    	
    }

}
