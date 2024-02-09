package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import models.CardDeck;
import models.Constants;
import models.GameBoard;
import models.WastePile;
import views.CardButton;
import views.DeckButton;

public class DeckActionListener implements ActionListener {

	CardButton deckView;
	CardButton wasteView;
	CardDeck deckModel;
	WastePile wastePile;
	private int deckIndex;
	
	
	public DeckActionListener(CardButton deckView, CardDeck deckModel, CardButton wasteView, WastePile wastePile) {
		this.deckView = deckView;
		this.deckModel = deckModel;
		this.wasteView = wasteView;
		this.wastePile = wastePile;
		deckIndex = 0;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		deckModel.getCardByIndex(deckIndex);
		wastePile.addCardToWaste(deckModel.getCardByIndex(deckIndex));
		wasteView.setIcon(deckModel.getCardByIndex(deckIndex).getImageIcon());
		wasteView.setCardModel(deckModel.getCardByIndex(deckIndex));
		deckIndex++;
		if (deckIndex != deckModel.getRemainingDeckSize()) {
			deckView.setIcon(Constants.backSideImg);
			
		}
		else {
		deckView.setIcon(Constants.emptyCardImg);
		wastePile.emptyWaste();
		deckIndex = 0;
		}
		LastCardSelectedUtility.clearCardsSelected();
		
	}

}
