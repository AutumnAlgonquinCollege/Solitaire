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
			gameBoard.incrementDeckPass();
			if (gameBoard.getGameMode() == Constants.standardGameMode) {
				cardDeck.copyCardsFromWaste(wastePile.getWasteCards());
				wastePile.emptyWaste();
			} else {
				if(gameBoard.getDrawMode() == "DRAW 1") {
					System.out.println("Deck Passes: " + gameBoard.getDeckPasses());
					if (gameBoard.getDeckPasses() < Constants.oneDrawPasses) {
						System.out.println("Inside deckPassing");
						cardDeck.copyCardsFromWaste(wastePile.getWasteCards());
						wastePile.emptyWaste();
					}
				}
				else {
					System.out.println("Deck Passes: " + gameBoard.getDeckPasses());
					if (gameBoard.getDeckPasses() < Constants.threeDrawPasses) {
						cardDeck.copyCardsFromWaste(wastePile.getWasteCards());
						wastePile.emptyWaste();
					}
				}
			}
			
			//If draw options is set to Draw 1
			if (!wastePile.isWasteEmpty() && gameBoard.getDrawMode().equals("DRAW 1")) {
				if (gameBoard.getGameMode().equals("STANDARD") && gameBoard.getDeckPasses() > 1) {
					gameBoard.setScore(gameBoard.getScore() - 100);
					wastePile.emptyWaste();
				}
				else {
					//vegas score stuff
				}	
			}
			//If draw options is set to Draw 3
			if (!wastePile.isWasteEmpty() && gameBoard.getDrawMode().equals("DRAW 3")) {
				if (gameBoard.getGameMode().equals("STANDARD") && gameBoard.getDeckPasses() > 4) {
					gameBoard.setScore(gameBoard.getScore() - 20);
					wastePile.emptyWaste();
				}
				else {
					//vegas score stuff
				}				
			}			
			
//			wastePile.emptyWaste();
		}
		if (controller.getGameBoard().getGameMode() == Constants.standardGameMode) {
			controller.redrawAll();
		}
		else if (controller.getGameBoard().getDrawMode().equals("DRAW 1")) {
			if (controller.getGameBoard().getDeckPasses() != Constants.oneDrawPasses) {
				controller.redrawAll();
			}
		}
		else {
			if (controller.getGameBoard().getDeckPasses() != Constants.threeDrawPasses) {
				controller.redrawAll();
			}
		}
	}

}
