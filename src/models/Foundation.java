package models;

import java.util.List;

import javax.swing.ImageIcon;

import java.util.ArrayList;

public class Foundation {

	//==================================
	//          Attributes
	//==================================
	
	private String suit;
	private List<Card> cards = new ArrayList<Card>();
	
	//==================================
	//          Constructors
	//==================================
	public Foundation (String suit) {
		this.suit = suit;
	}
	
	//==================================
	//          Private methods
	//==================================
	
	//Checks if the card is the next sequential rank and returns a boolean
	//Returns true if the card is the next sequential
	private boolean checkNextValue(Card card) {
		return (getLastRank() + 1 == card.getRank()) ? true : false;
	}
	
	//Checks if the card matches the suit of the foundation
	//Returns true if the card is same suit
	private boolean checkSuitMatches(Card card) {
		return (suit == card.getSuit()) ? true : false;
	}
	
	//Checks if the list is empty and if the card is an ace and returns a boolean
	//Returns true if the list is empty and the next card is an ace
	private boolean checkFirstCard(Card card) {
		return (cards.isEmpty() && card.getRank() == 1) ? true : false; 
	}
	
	//Returns the rank value for the last card in the List
	private int getLastRank() {
		return cards.get(cards.size()-1).getRank();		
	}
	
	
	//==================================
	//          Public Methods
	//==================================
	
	//Adds the card to the foundation pile if the suit matches and it is the correct rank.
	public boolean addCard(Card card) {
		boolean cardAdded = false;
		if (checkSuitMatches(card)) {
			if (cards.isEmpty() && checkFirstCard(card)) {
				cards.add(card);
				cardAdded = true;
			}
			
			else if (!cards.isEmpty() && checkNextValue(card)){
				cards.add(card);
				cardAdded = true;
			}
			
		}
		return cardAdded;
	}
	
	//Removes the card from the foundation pile
	public void removeCard(Card card) {
		cards.remove(card);
	}
	
	//Checks if the foundation pile has been completed.
	//Returns true if it is.
	public boolean isFoundationComplete() {
		return (getLastRank() == 13) ? true : false;
	}
	

	public ImageIcon getFoundationDisplayImage(String suit) {
		ImageIcon imageIcon;
		if (cards.isEmpty()) {
			switch (suit) {
				case Constants.spades:
					imageIcon = Constants.spadesFoundationImg;
					break;
				case Constants.clubs:
					imageIcon = Constants.clubsFoundationImg;
					break;
				case Constants.diamonds:
					imageIcon = Constants.diamondsFoundationImg;
					break;
				default:
					imageIcon = Constants.heartsFoundationImg;
					break;
			}				
		}
		else {
			imageIcon = cards.get(cards.size()-1).getImageIcon();
		}
		
		return imageIcon;
	}
	
	public Integer getFoundationSize() {
		return cards.size();

	}
		
	
}
