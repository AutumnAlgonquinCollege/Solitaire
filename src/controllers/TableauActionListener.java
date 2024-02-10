package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.GameBoard;
import models.Tableau;
import models.WastePile;
import views.CardButton;

public class TableauActionListener implements ActionListener {

	private Controller controller;
	private Tableau tableau;
	private int cardIndex;


	public TableauActionListener(Controller controller, Tableau tableau, int cardIndex) {
		this.controller = controller;
		this.tableau = tableau;
		this.cardIndex = cardIndex;
		
	}
	

	
	public int checkLastClick() {
		//returns 0 if it's a tableau, 1 if it's the WastePile, -1 if anything else
		if (LastCardSelectedUtility.getLastCardSelected() instanceof Tableau) {
			return 0;
		} else if (LastCardSelectedUtility.getLastCardSelected() instanceof WastePile) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public Boolean getFromTableau() {
		Boolean didGet = false;
		Tableau lastTableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();
		if (lastTableau.getTableauSize() == LastCardSelectedUtility.getLastIndexSelected()) {
			if (tableau.addCard(lastTableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected()))) {
				didGet = true;
				lastTableau.removeCard(lastTableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected()));
			}
		} else {
			if (tableau.addCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected()))) {
				didGet = true;
				lastTableau.removeCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected()));
			}
		}
		
		
		return didGet;
		
	}
	
	public Boolean getFromWaste() {
		Boolean didGet = false;
		if (tableau.addCard(controller.getGameBoard().getWastePile().getLastCard())) {
			controller.getGameBoard().getWastePile().getLastCard().setCardVisible(true);
			controller.getGameBoard().getWastePile().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
			controller.getGameBoard().getCardDeck().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
			didGet = true;
			System.out.println("True");
		}
		return didGet;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.setCardIndexes(cardIndex);
		LastCardSelectedUtility.setCardSelected(tableau, cardIndex);
		if (checkLastClick() == 0) {
			System.out.println(getFromTableau());
		} else if (checkLastClick() == 1) {
			getFromWaste();
		}
		
		controller.redrawAll();
		LastCardSelectedUtility.setCardSelected(tableau, tableau.getTotalCards());
		LastCardSelectedUtility.setCardSelected(tableau, tableau.getTotalCards());
		
		
		
	}

}
