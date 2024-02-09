package models;

import java.util.ArrayList;
import java.util.List;

public class WastePile extends CardDeck{
		
	public WastePile() {
		
	}
	
	public void addCardToWaste(Card card) {
		cards.add(card);
	}
	
	public void emptyWaste() {
		cards.clear();
	}
	
	public Card getLastCard() {
		return cards.get(cards.size()-1);
	}
	
	public Integer getLastWasteIndex() {
		return cards.size()-1;
	}
}
