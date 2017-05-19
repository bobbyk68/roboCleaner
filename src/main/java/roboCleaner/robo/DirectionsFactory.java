package roboCleaner.robo;

import java.util.Optional;

import roboCleaner.domain.Direction;
import roboCleaner.domain.Directions;

public class DirectionsFactory {
	
	private static final String DIRECTION_OPTIONS = "NSEW";

	private DirectionsFactory(){
	}
	
	public static Direction getInstance(String template){
		Direction returnDirection = new Direction(0,0);
		Directions direction = null;
		
		Optional<String> available = Optional.of(template);
		if (available.isPresent() && template.length() > 0 && DIRECTION_OPTIONS.indexOf(template) != -1) {
			direction = Directions.valueOf(template);
			switch(direction) {
			
				case N : 	returnDirection =  new Direction(0,1);
				break;
				
				case E  :	returnDirection = new Direction(1, 0);
				break;
				
				case W  :	returnDirection = new Direction(0, -1);
				break;
				
				case S :	returnDirection = new Direction(0, -1);
				break;
				
				default	:  returnDirection = new Direction(0,0);
			}
		}
		return returnDirection;
	}
}
