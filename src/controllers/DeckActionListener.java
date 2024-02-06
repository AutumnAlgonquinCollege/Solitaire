package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.CardDeck;
import views.CardButton;

public class DeckActionListener implements ActionListener{

	CardButton deckView;
	CardDeck deckModel;
	
	
	public DeckActionListener(CardButton dv, CardDeck dm) {
		deckView = dv;
		deckModel = dm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		deckModel.drawCard(0);
		deckView.setIcon(deckModel.drawCard(0).get);
		
	}

}
