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
		System.out.println(gameBoard.getGameMode());
		
		LastCardSelectedUtility.clearSelectedCards();
		
		//If deck isn't empty
		if (!cardDeck.isDeckEmpty()) {
			//If draw options is set to Draw 1
			if (gameBoard.getDrawMode().equals("DRAW 1")) {
				wastePile.addCardToWaste(cardDeck.getCardByIndex(0));
				cardDeck.removeCardByIndex(0);
			}
			//If draw options is set to Draw 3
			else if (gameBoard.getDrawMode().equals("DRAW 3")) {
				int cardsToDeal = Math.min(3, gameBoard.getCardDeck().getRemainingDeckSize());
				for (int i = 0; i < cardsToDeal; i++) {
					wastePile.addCardToWaste(cardDeck.getCardByIndex(0));
					cardDeck.removeCardByIndex(0);
				}
				controller.setCardsDealt(cardsToDeal);			
			}
		}
		//If deck is empty
		else {
			cardDeck.copyCardsFromWaste(wastePile.getWasteCards());				
			gameBoard.incrementDeckPass();
			
			//If draw options is set to Draw 1
			if (!wastePile.isWasteEmpty() && gameBoard.getDrawMode().equals("DRAW 1")) {
				if (gameBoard.getGameMode().equals("STANDARD") && gameBoard.getDeckPasses() > 1) {
					gameBoard.setScore(gameBoard.getScore() - 100);
				}
				else {
					//vegas score stuff
				}	
			}
			//If draw options is set to Draw 3
			if (!wastePile.isWasteEmpty() && gameBoard.getDrawMode().equals("DRAW 3")) {
				if (gameBoard.getGameMode().equals("STANDARD") && gameBoard.getDeckPasses() > 4) {
					gameBoard.setScore(gameBoard.getScore() - 20);
				}
				else {
					//vegas score stuff
				}				
			}			
			
			wastePile.emptyWaste();
		}

		controller.redrawAll();
	}

}
