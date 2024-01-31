package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	
	
	
	//Attributes
	private List<Card> cards = new ArrayList<>();
	
	//Constructors
	public CardDeck() {
		createDeck();
		shuffleDeck();
	}
	
	
	//Functions
	private void createDeck() {
		for (int i = 0; i < Constants.suitArray.length; i++) {
			for (int j = 0; j < Constants.rankArray.length; j++) {
				cards.add(new Card(Constants.suitArray[i], Constants.rankArray[j]));
			}
		}
	}
	
	
	private void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	
	private void drawCard() {
		//todo
	}

}
