package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.*;
import views.*;

public class FoundationActionListener implements ActionListener{

	Controller controller;
	Foundation foundation;
	String suit;
	
	
	public FoundationActionListener (Controller controller, String suit) {
		this.controller = controller;
		this.suit = suit;
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		foundation = controller.getFoundation(suit);
		LastCardSelectedUtility.setCardSelected(foundation, foundation.getFoundationSize());
		if (LastCardSelectedUtility.getLastCardSelected() == controller.getGameBoard().getWastePile())	{
			if (foundation.addCard(controller.getGameBoard().getWastePile().getLastCard())) {
				controller.getGameBoard().getCardDeck().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
				controller.getGameBoard().getWastePile().removeCardByIndex(LastCardSelectedUtility.getLastIndexSelected());
				controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
			}
		} else {
			Tableau tableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();
			if (foundation.addCard(tableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected()))) {
				if (tableau.removeCard(tableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected())) == true) {
					controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 5);
				}
				controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
			}
		}
		
		
		controller.redrawAll();
		
	}

}
