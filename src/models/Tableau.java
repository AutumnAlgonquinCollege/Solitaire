package models;

import java.util.ArrayList;
import java.util.List;

public class Tableau {

	//==================================
	//          Attributes
	//==================================
	private List<Card> cards = new ArrayList<Card>();
	private int undiscoveredCards;
	
	//==================================
	//          Constructors
	//==================================
	public Tableau (int undiscoveredCards) {
		this.undiscoveredCards = undiscoveredCards;
	}
	
	//==================================
	//       Getters and Setters
	//==================================
	public int getUndiscoveredCards() {
		return undiscoveredCards;
	}
	
	public void setUndiscoveredCards(int undiscoveredCards) {
		this.undiscoveredCards = undiscoveredCards;
	}
	
	//==================================
	//          Private Methods
	//==================================
	
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
	
	//Returns the last card from the tableau
	private Card getLastCard() {
		return cards.get(cards.size() -1);
	}
	
	
	//==================================
	//          Public Methods
	//==================================
	
	//Adds a single card to the tableau
	public void addCard(Card card) {
		//If tableau is empty and the first card is a king add it.
		if (cards.size() == 0 && checkFirstCard(card)) {
			cards.add(card);
		}
		else if (cards.size() != 0) {
			if (checkPreviousValue(card) && checkNextColor(card)) {
				cards.add(card);
			}
		}
	}
	
	//Adds a stack of cards to the tableau
	public void addCardStack(List<Card> cards) {
		if (this.cards.size() == 0 && checkFirstCard(cards.get(0))) {
			cards.addAll(cards);
		}
		else if (cards.size() != 0) {
			if (checkPreviousValue(cards.get(0)) && checkNextColor(cards.get(0))) {
				cards.addAll(cards);
			}
		}
	}
	
	//Removes a card from the tableau
	public void removeCard(Card card) {
		cards.remove(card);
		if (cards.size() != 0 && getFirstVisibleCard() == -1) {
			getLastCard().setCardVisible(true);
		}
	}
	
	//Removes a stack of cards from the tableau
	public void removeCardStack(List<Card> cards) {
		this.cards.removeAll(cards);
		if (cards.size() != 0 && getFirstVisibleCard() == -1) {
			getLastCard().setCardVisible(true);
		}
	}
	
	
	//Don't think these are useful but keeping just in case
	
	/*
	//Checks if the card is the next sequential rank and returns a boolean
	//Returns true if the card is the next sequential
	private boolean checkNextValue(Card card) {
		return (getLastRank() == card.getRank() - 1) ? true : false;
	}
	
	//Returns the rank value for the last card in the List
	private int getLastRank() {
		return cards.get(cards.size() -1 ).getRank();		
	}
	*/
	

}
