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

@Path("/hello")
public class CleanRoomServiceResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String pingResponse() {
        return "I am alive!";
    }
    
    @Path("/path_param/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNamedGreeting(@PathParam(value = "name") String name) {
        return "Hello " + name;
    }
    
    @Path("/query_param")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNamedStringWithParam(@DefaultValue("world") @QueryParam("name") String name) {
        return "Hello " + name;
    }
    
//    @Path("/hello_json")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Greeting getJSONGreeting() {
//        return new Greeting("Hello world!", new int[] {1,2});
//    }
    
    @Path("/hey_json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage getJSONMessage() {
    	int[] coords = {2, 1};
    	int patches = 1;
        return new ResponseMessage(coords, patches);
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