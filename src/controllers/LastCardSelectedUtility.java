package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Card;
import views.CardButton;

public class LastCardSelectedUtility {

	public static List<Object> cards = new ArrayList<Object>();
	public static List<Integer> indexes = new ArrayList<Integer>();
	
	//because an index of -1 is impossible, this will result in an error.
	public static final Integer indexNull = -1;
	
	public LastCardSelectedUtility() {
		
	}
	
	public static Object getLastCardSelected() {
		return cards.get(cards.size() - 1);
	}
	
	public static Integer getLastIndexSelected() {
		return indexes.get(indexes.size() - 1);
	}
	
	public static Object getFirstCardSelected() {
		return cards.get(0);
	}
	
	public static Integer getFirstCardIndex() {
		return indexes.get(0);
	}
	
	public static void setCardSelected(Object selectedModel, Integer index) {
		cards.add(selectedModel);	
		indexes.add(index);
	}
	
	public static void clearCardsSelected() {
		cards.removeAll(cards);
		indexes.removeAll(indexes);
	}

	public static int getSize() {
		return cards.size();
	}
	
}
