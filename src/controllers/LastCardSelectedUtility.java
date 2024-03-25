package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Card;
import views.CardButton;

public class LastCardSelectedUtility {

//	public static List<Object> cards = new ArrayList<Object>();
//	public static List<Integer> indexes = new ArrayList<Integer>();
	
	public static Object currentCard;
	public static Integer currentIndex;
	
	public static Object lastCard;
	public static Integer lastIndex;
	
	//because an index of -1 is impossible, this will result in an error.
	public static final Integer indexNull = -1;
	
	public LastCardSelectedUtility() {
		
	}

	public static Object getLastCardSelected() {
		
		return lastCard;
	}
	
	public static Integer getLastIndexSelected() {
		return lastIndex;
	}
	
	public static Object getCurrentCardSelected() {
		return currentCard;
	}
	
	public static Integer getCurrentCardIndex() {
		return currentIndex;
	}
	
	public static void setCardSelected(Object selectedModel, Integer index) {

		if (currentCard == null) {
			//lastCard = selectedModel;
			//lastIndex = index;			
			currentCard = selectedModel;
			currentIndex = index;
		} else {			
			lastCard = currentCard;
			lastIndex = currentIndex;
			currentCard = selectedModel;
			currentIndex = index;
			
		}
	}
	
	public static void clearLastSelectedCard() {
		lastCard = null;
		lastIndex = null;
	}
	
	public static void clearSelectedCards() {
		lastCard = null;
		currentCard = null;
		
		lastIndex = null;
		currentIndex = null;
	}
	
}
