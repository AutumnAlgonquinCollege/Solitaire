package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class WastePile {
		
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
	
	public List<Card> getWasteCards() {
		return cards;
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
	
	public List<ImageIcon> getTop3CardImages(){
		List<ImageIcon> imageIcons = new ArrayList<>();
		
		if (!cards.isEmpty()) {
			if (cards.size() >= 3) {
				imageIcons.add(cards.get(cards.size()-1).getImageIcon());
				imageIcons.add(cards.get(cards.size()-2).getImageIcon());
				imageIcons.add(cards.get(cards.size()-3).getImageIcon());
			}
			else if (cards.size() == 2) {
				imageIcons.add(cards.get(cards.size()-1).getImageIcon());
				imageIcons.add(cards.get(cards.size()-2).getImageIcon());
			}
			else if (cards.size() == 1) {
				imageIcons.add(cards.get(cards.size()-1).getImageIcon());
			}
		}
		
		else {
			imageIcons.add(Constants.emptyCardImg);
		}
		
		return imageIcons;
	}
	
	public boolean isWasteEmpty() {
		return cards.isEmpty();
	}

	public void removeCardByObject(Card card) {
		cards.remove(card);
	}
	
	
	public int getWasteSize() {
		return cards.size();
	}
	
}
