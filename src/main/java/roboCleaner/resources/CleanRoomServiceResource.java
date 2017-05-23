package roboCleaner.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import roboCleaner.core.Message;
import roboCleaner.core.ResponseMessage;

@Path("/clean")
public class CleanRoomServiceResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String pingResponse() {
        return "I am alive!";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage cleanRoom(Message cleanRequest) {
    	int[] coords = {2, 1};
    	int patch = 2;
    	System.out.println("Here in the code with " + cleanRequest.getInstructions());
        return new ResponseMessage(coords, patch);
        
    }
}