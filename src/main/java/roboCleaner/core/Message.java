package roboCleaner.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	
	private int[] roomSize;
	private int[] coords;
	private int[][] patches;
	private String instructions;
	
	public Message() {
	}

	public Message(int[] roomSize, int[] coords, int[][] patches,
			String instructions) {
		super();
		this.roomSize = roomSize;
		this.coords = coords;
		this.patches = patches;
		this.instructions = instructions;
	}

	@JsonProperty
	public int[] getRoomSize() {
		return roomSize;
	}

	@JsonProperty
	public int[] getCoords() {
		return coords;
	}

	@JsonProperty
	public int[][] getPatches() {
		return patches;
	}

	@JsonProperty
	public String getInstructions() {
		return instructions;
	}
	
	

}
