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
	private static int deckIndex = 0;
	
	
	public DeckActionListener(Controller controller) {
		this.controller = controller;
		cardDeck = controller.getGameBoard().getCardDeck();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		controller.gameBoard.getWastePile().addCardToWaste(cardDeck.getCardByIndex(deckIndex));
		System.out.println("rank" + cardDeck.getCardByIndex(deckIndex).getRank());
		deckIndex ++;
		if (deckIndex == cardDeck.getRemainingDeckSize()) {
			deckIndex = 0;
			controller.gameBoard.getWastePile().emptyWaste();
		}
		
		controller.redrawAll();
		
		
		
	}

}
