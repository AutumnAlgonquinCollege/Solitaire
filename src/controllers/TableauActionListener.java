package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import models.Card;
import models.GameBoard;
import models.Tableau;
import views.CardButton;

public class TableauActionListener implements ActionListener {

	private GameBoard gameBoard;
	private Controller controller;
	private Tableau tableau;
	private Tableau tableau1;
	private Tableau tableau2;
	private Tableau tableau3;
	private Tableau tableau4;
	private Tableau tableau5;
	private Tableau tableau6;
	private Tableau tableau7;
	private int cardIndex;


	public TableauActionListener(Controller controller, Tableau tableau, int cardIndex) {
		this.controller = controller;
		gameBoard = controller.getGameBoard();
		this.tableau = tableau;
		this.cardIndex = cardIndex;
		initTableauModels(gameBoard);
	}
	
	
	private void initTableauModels(GameBoard gameBoard) {
		//Tableau models
		tableau1 = gameBoard.getTableau1();
		tableau2 = gameBoard.getTableau2();
		tableau3 = gameBoard.getTableau3();
		tableau4 = gameBoard.getTableau4();
		tableau5 = gameBoard.getTableau5();
		tableau6 = gameBoard.getTableau6();
		tableau7 = gameBoard.getTableau7();
	}
	
	private void moveCardFromDeckToTableau(Tableau tableau, Card card) {
		card.setCardVisible(true);	
		if (tableau.addCard(card))
		{		
		gameBoard.getWastePile().removeCardByObject(card);
		gameBoard.getCardDeck().removeCardByObject(card);
		System.out.println("Deleted deck");
		}
		else {
			card.setCardVisible(false);
		}
	}
	
	
	private void moveCardFromTableauToTableau(Tableau tableauOrigin, int tableauDestinationNum, int tableauIndex) {
		Card card;
		List<Card> cards;
		System.out.println("Geno");
		System.out.println(tableauIndex);
		System.out.println(tableauOrigin.getTableauSize());
		switch (tableauDestinationNum) {
				
			case 0:				
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau1().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}
				}
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau1().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}
				break;
				
			case 1:
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau2().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}
				}		
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau2().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}				
				break;
				
			case 2:
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau3().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}					
				}
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau3().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}
				break;
				
			case 3:
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau4().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}
				}
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau4().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}
				break;
				
			case 4:
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau5().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}
				}
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau5().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}
				break;
				
			case 5:
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau6().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}
				}
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau6().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}
				break;
				
			case 6:
				if (tableauOrigin.getTableauSize() == tableauIndex) {
					card = tableauOrigin.getCardByIndex(tableauIndex);
					if (gameBoard.getTableau7().addCard(card)) {
						tableauOrigin.removeCard(card);
						System.out.println("Deleted Card");
					}
				}
				else {
					cards = tableauOrigin.splitCardStack(tableauIndex);
					if (gameBoard.getTableau7().addCardStack(cards)) {
						tableauOrigin.removeCardStack(cards);
						System.out.println("Deleted Card Stack");
					}
				}
			default:
				break;		
		}
	}

	private void checkTableauModified(Tableau tableau, Object first, Object second, int tableauCardIndex, int tableauDestination) {
		if (tableau == second) {
			if (gameBoard.getWastePile() == first) {
				moveCardFromDeckToTableau(tableau, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != tableauCardIndex){
				moveCardFromTableauToTableau(tableau, tableauDestination, tableauCardIndex);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.setCardIndexes(cardIndex);
		
		LastCardSelectedUtility.setCardSelected(tableau, tableau.getUndiscoveredCards());
		Object firstSelected = LastCardSelectedUtility.getLastCardSelected();
		Object secondSelected = LastCardSelectedUtility.getCurrentCardSelected();		
		int tableauDestination = LastCardSelectedUtility.getCurrentCardIndex();
		int tableauCardIndex = controller.getCardIndexes(0);		
		
		checkTableauModified(tableau1, firstSelected, secondSelected, tableauCardIndex, tableauDestination);
		checkTableauModified(tableau2, firstSelected, secondSelected, tableauCardIndex, tableauDestination);
		checkTableauModified(tableau3, firstSelected, secondSelected, tableauCardIndex, tableauDestination);
		checkTableauModified(tableau4, firstSelected, secondSelected, tableauCardIndex, tableauDestination);
		checkTableauModified(tableau5, firstSelected, secondSelected, tableauCardIndex, tableauDestination);
		checkTableauModified(tableau6, firstSelected, secondSelected, tableauCardIndex, tableauDestination);
		checkTableauModified(tableau7, firstSelected, secondSelected, tableauCardIndex, tableauDestination);		
		
		
		/*
		System.out.println(LastCardSelectedUtility.getLastCardSelected().toString());
		System.out.println(LastCardSelectedUtility.getLastIndexSelected().toString());
		
		System.out.println(LastCardSelectedUtility.getCurrentCardSelected().toString());
		System.out.println(LastCardSelectedUtility.getCurrentCardIndex().toString());
		*/
		
		controller.redrawAll();

		
	}

}
