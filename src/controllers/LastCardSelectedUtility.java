package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Card;
import views.CardButton;

public class LastCardSelectedUtility {

	public CardButton firstCard;
	public CardButton secondCard;
	public static List<CardButton> cards = new ArrayList<CardButton>();

	
	public LastCardSelectedUtility() {
		
	}
	
	public static CardButton getLastCardSelected() {
		return cards.get(cards.size() - 1);
	}
	
	public static CardButton getFirstCardSelected() {
		return cards.get(0);
	}
	
	public static void setCardSelected(CardButton selectedCard) {
		if (cards.size() == 2) {
			cards.removeAll(cards);
		}
		cards.add(selectedCard);			
	}
	
	public static void clearCardsSelected() {
		cards.removeAll(cards);
	}

	public static int getSize() {
		return cards.size();
	}
	
}
