package robo;

public class DirectionsFactory {

	private DirectionsFactory(){
		
	}
	
	public static Direction getInstance(String template){
		Direction direction = null;
		switch(template) {
		
			case "NORTH" : 	direction =  new Direction(0,1);
							break;
							
			case "EAST"  :	direction = new Direction(1, 0);
							break;
							
			case "WEST"  :	direction = new Direction(0, -1);
							break;
							
			case "SOUTH" :	direction = new Direction(0, -1);
							break;
							
			default		 :  direction = null;
						
		}
		return direction;
	}
}
