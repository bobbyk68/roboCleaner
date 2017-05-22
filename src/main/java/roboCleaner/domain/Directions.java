package roboCleaner.domain;

public enum Directions {
	
	N("N"), W("W"), E("E"), S("S");
	//N, W, E, S;
	
	private String cardinalDirection;

	public String getCardinalDirection() {
		return cardinalDirection;
	}

	public void setCardinalDirection(String cardinalDirection) {
		this.cardinalDirection = cardinalDirection;
	}
	
	private Directions(String cardinalDirection) {
		this.cardinalDirection = cardinalDirection;
	}
}
