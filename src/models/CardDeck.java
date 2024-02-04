package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	
	//==================================
	//          Attributes
	//==================================
	
	private List<Card> cards = new ArrayList<Card>();
	
	//==================================
	//          Constructors
	//==================================
	
	public CardDeck() {
		createDeck();
		shuffleDeck();
	}
	
	//==================================
	//			Private methods
	//==================================
	
	//Creates the full deck of cards.
	private void createDeck() {
		for (int i = 0; i < Constants.suitArray.length; i++) {
			for (int j = 0; j < Constants.rankArray.length; j++) {
				cards.add(new Card(Constants.suitArray[i], Constants.rankArray[j]));
			}
		}
	}
	
	//Randomly shuffles the deck of cards
	private void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	//==================================
	//			Public methods
	//==================================
	
	//Returns the card object by the index.
	public Card drawCard(int index) {
		return cards.get(index);
	}
	
	//Removes the card from the deck by index
	public void removeCardByIndex(int index) {
		cards.remove(index);
	}
	
	//Removes the card from the deck by object
	public void removeCardByObject(Card card) {
		cards.remove(card);
	}
	
	//Returns the index size of the remaining cards.
	//Returns -1 if the deck is empty.
	public int getRemainingDeckSize() {
		return (cards.size() != 0) ? cards.size() - 1 : -1;
	}

	
}