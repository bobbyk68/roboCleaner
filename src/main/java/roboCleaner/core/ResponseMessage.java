package roboCleaner.core;

public class ResponseMessage {
	
	private int[] coords;
	private int patches;
	
	public ResponseMessage() {
		
	}
	
	public ResponseMessage(int[] coords, int patches) {
		super();
		this.coords = coords;
		this.patches = patches;
	}

	public int[] getCoords() {
		return coords;
	}

	public int getPatches() {
		return patches;
	}
	
	

}
