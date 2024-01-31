package models;

public class Card {
	
	//Attributes
	private String suit;
	private String rank;
	private boolean cardVisible;
	
	//Constructors
	public Card () {}
	
	public Card (String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
		cardVisible = false;
	}
	
	//Getters and Setters
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public boolean getCardVisible() {
		return cardVisible;
	}
	
	public void setCardVisible(boolean cardVisible) {
		this.cardVisible = cardVisible;
	}
	

}
