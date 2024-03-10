package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class WastePile{
		
	public List<Card> cards = new ArrayList<Card>();
	
	public WastePile() {
		
	}
	
	public void removeCardByIndex(int index) {
		cards.remove(index);
	}
	
	public void addCardToWaste(Card card) {
		cards.add(card);
	}
	
	public void emptyWaste() {
		cards.clear();
	}
	
	public Card getLastCard() {
		if (!cards.isEmpty()) {
			return cards.get(cards.size()-1);
		}
		else {
			return null;
		}
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

	public void removeCardByObject(Card card) {
		cards.remove(card);
	}
	
	public int getWasteSize() {
		return cards.size() - 1;
	}
}
