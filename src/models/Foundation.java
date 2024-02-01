package models;

import java.util.List;
import java.util.ArrayList;

public class Foundation {

	//Attributes
	private String suit;
	private List<Card> cards = new ArrayList<Card>();
	
	//Constructor
	public Foundation (String suit) {
		this.suit = suit;
	}
	
	//Checks if the card is the next sequential rank and returns a boolean
	//Returns true if the card is the next sequential
	private boolean checkNextValue(Card card) {
		return (getLastRank() == card.getRank() + 1) ? true : false;
	}
	
	//Checks if the card matches the suit of the foundation
	//Returns true if the card is same suit
	private boolean checkSuitMatches(Card card) {
		return (suit == card.getSuit()) ? true : false;
	}
	
	//Checks if the list is empty and if the card is an ace and returns a boolean
	//Returns true if the list is empty and the next card is an ace
	private boolean checkFirstCard(Card card) {
		return (cards.size() == 0 && card.getRank() == 1) ? true : false; 
	}
	
	//Returns the rank value for the last card in the List
	private int getLastRank() {
		return cards.get(cards.size() -1 ).getRank();		
	}
	
	
}
