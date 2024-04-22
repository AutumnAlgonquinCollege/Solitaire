package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.CardDeck;
import models.Constants;
import models.GameBoard;
import models.WastePile;
import views.CompletedGamePanel;


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
//		Testing the game complete screen;
//		int timeBonus = 1;
//		CompletedGamePanel gameTest = new CompletedGamePanel(gameBoard.getFormattedTime(), gameBoard.getScore(), timeBonus);
		
		System.out.println(gameBoard.getGameMode());
		System.out.println(gameBoard.getDrawMode());
		
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
			gameBoard.incrementDeckPass();
			
			//If draw options is set to Draw 1
			if (!wastePile.isWasteEmpty() && gameBoard.getDrawMode().equals("DRAW 1")) {	
				
				if (gameBoard.getGameMode().equals(Constants.standardGameMode)) {
					cardDeck.copyCardsFromWaste(wastePile.getWasteCards());
					wastePile.emptyWaste();	
					
					if (gameBoard.getDeckPasses() > 1) {
						gameBoard.setScore(gameBoard.getScore() - 100);									
					}
				}
			}
			
			//If draw options is set to Draw 3
			if (!wastePile.isWasteEmpty() && gameBoard.getDrawMode().equals("DRAW 3")) {
				
				if (gameBoard.getGameMode().equals(Constants.standardGameMode)) {
					cardDeck.copyCardsFromWaste(wastePile.getWasteCards());
					wastePile.emptyWaste();	
					
					if (gameBoard.getDeckPasses() > 4) {
						gameBoard.setScore(gameBoard.getScore() - 20);
					}
				}
				else {
					if (controller.getGameBoard().getDeckPasses() < Constants.threeDrawPasses) {
						cardDeck.copyCardsFromWaste(wastePile.getWasteCards());
						wastePile.emptyWaste();
					}					
				}
			}			
		}
		
		controller.redrawAll();
		
	}

}
