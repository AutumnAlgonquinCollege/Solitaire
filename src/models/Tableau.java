package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tableau {

	//Attributes
	private List<Card> cards = new ArrayList<Card>();
	private int undiscoveredCards;
	
	//Constructors
	public Tableau (int undiscoveredCards) {
		this.undiscoveredCards = undiscoveredCards;
	}
	
	
	//Functions
	
	//Checks if the card is the next sequential rank and returns a boolean
	//Returns true if the card is the next sequential
	private boolean checkNextValue(Card card) {
		return (getLastRank() == card.getRank() - 1) ? true : false;
	}
	
	//Checks if the card is the previous sequential rank and returns a boolean
	//Returns true if the card is the previous sequential rank
	private boolean checkPreviousValue(Card card) {
		return (cards.get(getFirstVisibleCard()).getRank() == card.getRank() + 1) ? true : false;
	}
		
	//Checks if the previous card is the same as the new card and returns a boolean
	//Returns true if the card is not the same color
	private boolean checkNextColor(Card card) {
		return (getLastColor() != card.getCardColor()) ? true : false;
	}
	
	//Checks if the list is empty and if the card is an ace and returns a boolean
	//Returns true if the list is empty and the next card is an ace
	private boolean checkFirstCard(Card card) {
		return (cards.size() == 0 && card.getRank() == 13) ? true : false; 
	}
	
	//Returns the rank value for the last card in the List
	private int getLastRank() {
		return cards.get(cards.size() -1 ).getRank();		
	}
	
	//Gets the index of the first card in the list that is visible
	//Returns -1 if there is no visible cards
	private int getFirstVisibleCard() {
		int index = -1;
		for (Card card : cards) {
			if (card.getCardVisible()) {
				index = cards.indexOf(card);
				break;
			}
		}
		return index;
	}
	
	//Returns the color of the last card in the List
	private String getLastColor() {
		return cards.get(cards.size() -1).getCardColor();
	}
	

}
