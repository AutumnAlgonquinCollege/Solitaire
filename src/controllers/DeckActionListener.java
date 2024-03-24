package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.CardDeck;
import models.GameBoard;
import models.WastePile;


public class DeckActionListener implements ActionListener{

	Controller controller;
	GameBoard gameBoard;
	CardDeck cardDeck;
	WastePile wastePile;
	
	public DeckActionListener(Controller controller) {
		this.controller = controller;
		gameBoard = controller.getGameBoard();
		cardDeck = controller.getGameBoard().getCardDeck();
		wastePile = controller.getGameBoard().getWastePile();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		LastCardSelectedUtility.clearSelectedCards();
		
		if (gameBoard.getDrawMode().equals("DRAW 1") && !cardDeck.isDeckEmpty()) {
			wastePile.addCardToWaste(cardDeck.getCardByIndex(0));
			cardDeck.removeCardByIndex(0);
		}
		else if (gameBoard.getDrawMode().equals("DRAW 3") && !cardDeck.isDeckEmpty()) {
			if (gameBoard.getCardDeck().getRemainingDeckSize() >= 3) {
				wastePile.addCardToWaste(cardDeck.getCardByIndex(0));
				wastePile.addCardToWaste(cardDeck.getCardByIndex(1));
				wastePile.addCardToWaste(cardDeck.getCardByIndex(2));
				cardDeck.removeCardByIndex(2);
				cardDeck.removeCardByIndex(1);
				cardDeck.removeCardByIndex(0);
			}
			else if (gameBoard.getCardDeck().getRemainingDeckSize() == 2) {
				wastePile.addCardToWaste(cardDeck.getCardByIndex(0));
				wastePile.addCardToWaste(cardDeck.getCardByIndex(1));
				cardDeck.removeCardByIndex(1);
				cardDeck.removeCardByIndex(0);
			}
			else {
				wastePile.addCardToWaste(cardDeck.getCardByIndex(0));
				cardDeck.removeCardByIndex(0);
			}
		}
		else if (cardDeck.isDeckEmpty()) {			
			cardDeck.copyCardsFromWaste(wastePile.getWasteCards());			
			wastePile.emptyWaste();
			gameBoard.incrementDeckPass();
			if (gameBoard.getDeckPasses() > 1 && gameBoard.getDrawMode().equals("DRAW 1")) {
				gameBoard.setScore(gameBoard.getScore() - 100);
			}
			else if (gameBoard.getDeckPasses() > 4 && gameBoard.getDrawMode().equals("DRAW 3")) {
				gameBoard.setScore(gameBoard.getScore() - 20);
			}
		}
		
		controller.redrawAll();
	}

}
