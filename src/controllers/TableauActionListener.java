package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import models.Card;
import models.Constants;
import models.Foundation;
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
		//returns 0 if it's a tableau, 1 if it's the WastePile, 2 if its foundation, -1 if anything else
		int oldObject = -1;
		if (LastCardSelectedUtility.getLastCardSelected() instanceof Tableau) {
			Tableau lastTableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();
			if (!lastTableau.isEmpty()) {
				oldObject = 0;
			}
		} else if (LastCardSelectedUtility.getLastCardSelected() instanceof WastePile) {
			oldObject = 1;
		}
		else if (LastCardSelectedUtility.getLastCardSelected() instanceof Foundation) {
			oldObject = 2;
		}
		
		return oldObject;
	}
	
	public Boolean getFromTableau() {
		Boolean didGet = false;
		Tableau lastTableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();
		if (lastTableau.getTableauSize() == LastCardSelectedUtility.getLastIndexSelected()) {
			if (tableau.addCard(lastTableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected()))) {
				didGet = true;
				if(lastTableau.removeCard(lastTableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected())) == true) {
					controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
				}
			}
		} else {
				if (tableau.addCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected()))) {
					didGet = true;
					if(lastTableau.removeCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected())) == true) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
					}
				}
			}		
		
		return didGet;
		
	}
	
	public Boolean getFromWaste() {
		Boolean didGet = false;
		System.out.println("Tableau Listener: " + controller.getGameBoard().getWastePile().getLastCard().getRank());
		System.out.println("Tableau Listener: " + controller.getGameBoard().getWastePile().getLastCard().getSuit());
		if (tableau.addCard(controller.getGameBoard().getWastePile().getLastCard())) {
			tableau.getCardByIndex(tableau.getTableauSize()).setCardVisible(true);
			//controller.getGameBoard().getCardDeck().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
			controller.getGameBoard().getWastePile().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
			controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 5);
			controller.decrementCardsDealt();
			didGet = true;			
		}
		return didGet;
	}
	
	public Boolean getFromFoundation() {
		Boolean didGet = false;
		Foundation foundation = (Foundation) LastCardSelectedUtility.getLastCardSelected();
		Card card = foundation.getLastCardInFoundation();
		card.setCardVisible(true);
		
		if (tableau.addCard(card)) {
			foundation.removeCardByObject(card);
			controller.getGameBoard().setScore(controller.getGameBoard().getScore() - 15);
			didGet = true;
		}
		
		return didGet;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean cardMoved = false;
		if (tableau.isEmpty() || tableau.getCardByIndex(cardIndex).getCardVisible() == true) {
			LastCardSelectedUtility.setCardSelected(tableau, cardIndex);
		}
		if (checkLastClick() == 0) {
			cardMoved = getFromTableau();
		} else if (checkLastClick() == 1) {
			cardMoved = getFromWaste();			
		}
		else if (checkLastClick() == 2) {
			cardMoved = getFromFoundation();
		}
		
		if (cardMoved) {
			LastCardSelectedUtility.clearSelectedCards();			
		}
		
		controller.redrawAll();
	}

}
