package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.Constants;
import models.Foundation;
import models.GameBoard;
import models.WastePile;
import views.CardButton;

public class WasteActionListener implements ActionListener{

	Controller controller;
	WastePile wastePile;
	GameBoard gameBoard;
	
	public WasteActionListener(Controller controller) {
		this.controller = controller;
		gameBoard = controller.getGameBoard();
		wastePile = controller.getGameBoard().getWastePile();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!wastePile.isWasteEmpty()) {
			LastCardSelectedUtility.setCardSelected(wastePile, wastePile.getLastWasteIndex());	
		}
		boolean cardMoved = false;
		
		if (LastCardSelectedUtility.getLastCardSelected() instanceof WastePile && LastCardSelectedUtility.getCurrentCardSelected() instanceof WastePile) {
			
			Card card = wastePile.getLastCard();			
			Foundation foundation = controller.getFoundation(card.getSuit());
			if (foundation.addCard(card)) {
				cardMoved = true;
				wastePile.removeCardByObject(wastePile.getLastCard());
				if (gameBoard.getDrawMode().equals("DRAW 3")) {
					
					if (gameBoard.getGameMode().equals("STANDARD")) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
					}
					else {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + Constants.vegasScoreFoundation);
					}
					
					controller.decrementCardsDealt();
				}
				else {
					if (gameBoard.getGameMode().equals("STANDARD")) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
					}
					else {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + Constants.vegasScoreFoundation);
					}
				}
			}
			else {
				for (int i = 0; i < gameBoard.getAllTableaus().size(); i++) {
					
					if (gameBoard.getAllTableaus().get(i).addCard(card) ) {
						card.setCardVisible(true);
						cardMoved = true;
						wastePile.removeCardByObject(wastePile.getLastCard());
						if (gameBoard.getDrawMode().equals("DRAW 3")) {
							if (gameBoard.getGameMode().equals("STANDARD")) {
								controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 5);
							}
							controller.decrementCardsDealt();
						}
						break;
					}
				}
			}
			
			if (cardMoved || LastCardSelectedUtility.getLastCardSelected() != null) {
			LastCardSelectedUtility.clearSelectedCards();	
			controller.redrawAll();
			}
		}
		
		
		
	 }

	
	
}
