package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import models.CardDeck;
import models.Constants;
import models.GameBoard;
import models.WastePile;
import views.CardButton;

public class DeckActionListener implements ActionListener{

	Controller controller;
	CardDeck cardDeck;
	private int deckIndex;
	
	
	public DeckActionListener(Controller controller) {
		this.controller = controller;
		cardDeck = controller.getGameBoard().getCardDeck();
		deckIndex = controller.getDeckIndex();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		deckIndex = controller.getDeckIndex();
		controller.gameBoard.getWastePile().addCardToWaste(cardDeck.getCardByIndex(deckIndex));	
		if (deckIndex == cardDeck.getRemainingDeckSize()) {
			deckIndex = 0;
			controller.gameBoard.getWastePile().emptyWaste();
		}
		else {
			deckIndex ++;
		}
		controller.setDeckIndex(deckIndex);
		controller.redrawAll();
	}

}
