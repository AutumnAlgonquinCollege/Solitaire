package controllers;

import models.Card;
import views.CardButton;

public class LastCardSelectedUtility {

	private static CardButton lastCard;
	private static CardButton currentCard;
	
	public LastCardSelectedUtility() {
		
	}
	
	public static CardButton getLastCardSelected() {
		return lastCard;
	}
	
	public static void setCardSelected(CardButton selectedCard) {
		if (lastCard == null) {
			lastCard = selectedCard;
		}
		else {
			lastCard = currentCard;
			currentCard = selectedCard;
			
		}
	}

	
}
