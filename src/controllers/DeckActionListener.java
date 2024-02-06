package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import models.CardDeck;
import models.Constants;
import models.GameBoard;
import views.CardButton;

public class DeckActionListener implements ActionListener{

	CardButton deckView;
	CardButton wasteView;
	CardDeck deckModel;
	private int deckIndex;
	
	
	public DeckActionListener(CardButton deckView, CardDeck deckModel, CardButton wasteView) {
		this.deckView = deckView;
		this.deckModel = deckModel;
		this.wasteView = wasteView;
		deckIndex = 0;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		deckModel.getCardByIndex(deckIndex);
		wasteView.setIcon(deckModel.getCardByIndex(deckIndex).getImageIcon());
		deckIndex++;
		if (deckIndex != deckModel.getRemainingDeckSize()) {
			deckView.setIcon(Constants.backSideImg);
			
		}
		else {
		deckView.setIcon(Constants.emptyCardImg);
		deckIndex = 0;
		}
		
		
		
	}

}
