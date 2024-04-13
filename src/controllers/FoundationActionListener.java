package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.*;
import views.*;

public class FoundationActionListener implements ActionListener{

	Controller controller;
	Foundation foundation;
	GameBoard gameBoard;
	WastePile wastePile;
	String suit;
	
	
	public FoundationActionListener (Controller controller, String suit) {
		this.controller = controller;
		this.suit = suit;
		this.gameBoard = controller.getGameBoard();
		this.wastePile = controller.getGameBoard().getWastePile();
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean cardMoved = false;
		foundation = controller.getFoundation(suit);
		LastCardSelectedUtility.setCardSelected(foundation, foundation.getFoundationSize());
		if (LastCardSelectedUtility.getLastCardSelected() == controller.getGameBoard().getWastePile())	{
			if (foundation.addCard(controller.getGameBoard().getWastePile().getLastCard())) {
				//controller.getGameBoard().getCardDeck().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
				controller.getGameBoard().getWastePile().removeCardByIndex(LastCardSelectedUtility.getLastIndexSelected());
				
				if (gameBoard.getGameMode().equals("STANDARD")) {
					controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
				}
				else {
					//vegas score stuff
				}
				
				cardMoved = true;
				controller.decrementCardsDealt();
			}
		} else if (LastCardSelectedUtility.getLastCardSelected() instanceof Tableau){
			Tableau tableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();
			if (tableau.getTableauSize() == LastCardSelectedUtility.getLastIndexSelected()) {
				if (foundation.addCard(tableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected()))) {
					if (tableau.removeCard(tableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected())) == true) {
						if (gameBoard.getGameMode().equals("STANDARD")) {
							controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 5);
						}
						else {
							//vegas score stuff
						}
					}
					
					if (gameBoard.getGameMode().equals("STANDARD")) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
					}
					else {
						//vegas score stuff
					}
					cardMoved = true;
				}
			}			
		}
		
		if (cardMoved || LastCardSelectedUtility.getLastCardSelected() != null) {
			LastCardSelectedUtility.clearSelectedCards();
			controller.redrawAll();
		}
					
		
	}

}
