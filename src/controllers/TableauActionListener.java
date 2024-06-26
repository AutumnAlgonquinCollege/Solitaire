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
	private GameBoard gameBoard;
	private Tableau tableau;
	private int cardIndex;


	public TableauActionListener(Controller controller, Tableau tableau, int cardIndex) {
		this.controller = controller;
		this.gameBoard = controller.getGameBoard();
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
	
	public Boolean getAutoStackFromTableau() {
		Boolean didGet = false;
		boolean cardsMatch = false;
		Tableau lastTableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();		
		
		if (tableau == lastTableau && LastCardSelectedUtility.getCurrentCardSelected() != null) {
			Card card = tableau.getCardByIndex(LastCardSelectedUtility.getCurrentCardIndex());
			Card lastCard = tableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected());
			if (card == lastCard) {
				cardsMatch = true;
			}
			Foundation foundation = controller.getFoundation(card.getSuit());
			if (tableau.getTableauSize() == LastCardSelectedUtility.getCurrentCardIndex() && cardsMatch) {
				if (foundation.addCard(card)) {
					if (tableau.removeCard(tableau.getCardByIndex(LastCardSelectedUtility.getCurrentCardIndex()))) {
						tableau.setUndiscoveredCards(tableau.getUndiscoveredCards() - 1);
						
						//Add points for discovering a card
						if (gameBoard.getGameMode().equals("STANDARD")) {
							controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 5);
						}

						//controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 5); Is there points for discovering in Vegas?
					}
					
					//Add points for moving card to foundation
					if (gameBoard.getGameMode().equals("STANDARD")) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 10);
					}
					else {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + Constants.vegasScoreFoundation);
					}
					
					didGet = true;
				}
			}			
			if (!didGet) {
				for (int i = 0; i < gameBoard.getAllTableaus().size(); i++) {
					if (tableau.getTableauSize() == LastCardSelectedUtility.getCurrentCardIndex()) {
						if (gameBoard.getAllTableaus().get(i).addCard(card) ) {							
							tableau.removeCardByIndex(LastCardSelectedUtility.getCurrentCardIndex());
							if (gameBoard.getGameMode().equals("STANDARD")) {
								controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
							}

							didGet = true;
							break;
						}
					}
					else if (tableau.getTableauSize() >= LastCardSelectedUtility.getCurrentCardIndex()){
						if (gameBoard.getAllTableaus().get(i).addCardStack(tableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected()))) {
							if (tableau.removeCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected()))) {
								if (gameBoard.getGameMode().equals("STANDARD")) {
									controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
								}

								didGet = true;
								break;
							}
						}
					}					
				}
			}
		}
		return didGet;
	}
	
	public Boolean getFromTableau() {
		Boolean didGet = false;
		Tableau lastTableau = (Tableau)LastCardSelectedUtility.getLastCardSelected();		
		
		if (lastTableau.getTableauSize() == LastCardSelectedUtility.getLastIndexSelected()) {
			if (tableau.addCard(lastTableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected()))) {
				System.out.println("Tableau single card moved");
				didGet = true;
				if(lastTableau.removeCard(lastTableau.getCardByIndex(LastCardSelectedUtility.getLastIndexSelected())) == true) {
					if (gameBoard.getGameMode().equals("STANDARD")) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
					}					
				}
			}
		} 
		else if (lastTableau.getTableauSize() >= LastCardSelectedUtility.getLastIndexSelected()) {
			if (tableau.addCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected()))) {
				didGet = true;
				if(lastTableau.removeCardStack(lastTableau.splitCardStack(LastCardSelectedUtility.getLastIndexSelected())) == true) {
					System.out.println("Tableau stack cards moved");
					if (gameBoard.getGameMode().equals("STANDARD")) {
						controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
					}
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
			controller.getGameBoard().getWastePile().removeCardByObject(controller.getGameBoard().getWastePile().getLastCard());
			if (gameBoard.getGameMode().equals("STANDARD")) {
				controller.getGameBoard().setScore(controller.getGameBoard().getScore() + 3);
			}
			else {
				//vegas score stuff
			}
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
			if (gameBoard.getGameMode().equals("STANDARD")) {
				controller.getGameBoard().setScore(controller.getGameBoard().getScore() - 15);
			}
			else {
				controller.getGameBoard().setScore(controller.getGameBoard().getScore() - Constants.vegasScoreFoundation);
			}
			
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
		if (checkLastClick() == 0 && LastCardSelectedUtility.getLastCardSelected() != null) {
			if (LastCardSelectedUtility.getCurrentCardSelected() instanceof Tableau && LastCardSelectedUtility.getLastCardSelected() instanceof Tableau) {
				if ((Tableau) LastCardSelectedUtility.getLastCardSelected() != (Tableau) LastCardSelectedUtility.getCurrentCardSelected()) {
					cardMoved = getFromTableau();
				}
				else {
					cardMoved = getAutoStackFromTableau();					
				}
			}
			
		} else if (checkLastClick() == 1) {
			cardMoved = getFromWaste();			
		}
		else if (checkLastClick() == 2) {
			cardMoved = getFromFoundation();
		}
		
		if (cardMoved || LastCardSelectedUtility.getLastCardSelected() != null) {
			LastCardSelectedUtility.clearSelectedCards();
			controller.redrawAll();
		}
		
		
	}

}
