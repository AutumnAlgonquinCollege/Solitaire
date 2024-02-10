package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class WastePile extends CardDeck{
		
	private List<Card> cards = new ArrayList<Card>();
	
	public WastePile() {
		
	}
	
	public void addCardToWaste(Card card) {
		cards.add(card);
	}
	
	public void emptyWaste() {
		cards.clear();
	}
	
	public Card getLastCard() {
		System.out.println(cards.size());
		return cards.get(cards.size()-1);
	}
	
	public Integer getLastWasteIndex() {
		return cards.size()-1;
	}
	
	public ImageIcon getTopCardImage() {
		ImageIcon imageIcon;
		
		if (!cards.isEmpty()) {
			imageIcon = cards.get(cards.size()-1).getImageIcon();
		} else {
			imageIcon = Constants.emptyCardImg;
		}
		return imageIcon;
	}
}
