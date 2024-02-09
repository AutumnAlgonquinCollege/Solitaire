package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.GameBoard;
import models.Tableau;

public class TableauActionListener implements ActionListener {

	private GameBoard gameBoard;
	private Controller controller;
	private Tableau tableau1;
	private Tableau tableau2;
	private Tableau tableau3;
	private Tableau tableau4;
	private Tableau tableau5;
	private Tableau tableau6;
	private Tableau tableau7;
	
	public TableauActionListener(Controller controller) {
		this.controller = controller;
		gameBoard = controller.getGameBoard();
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
	
	private boolean checkWastePile(Card card) {
		boolean result = false;
		if (gameBoard.getCardDeck().getCardIndexByObject(card) != -1) {
			result = true;
		}
		return result;
	}
	
	/*
	private String checkTableauSource(Card card) {
		String result = "";
		
		if (tableau1.) {
			result = "Tableau1";
		}
		else if (tableauList2.contains(cardBtn)) {
			result = "Tableau2";
		}
		else if (tableauList3.contains(cardBtn)) {
			result = "Tableau3";
		}
		else if (tableauList4.contains(cardBtn)) {
			result = "Tableau4";
		}
		else if (tableauList5.contains(cardBtn)) {
			result = "Tableau5";
		}
		else if (tableauList6.contains(cardBtn)) {
			result = "Tableau6";
		}
		else if (tableauList7.contains(cardBtn)) {
			result = "Tableau7";
		}
		return result;
	}
	*/
	
	private void checkFirstCardOrigin() {
		Card card = (Card) LastCardSelectedUtility.getFirstCardSelected();
		if (checkWastePile(card)) {
			gameBoard.getCardDeck().removeCardByObject(card);
			System.out.println("Deleted card from deck");
		}
		/*
		else if (checkSource(cardBtn) == "Tableau1") {
			controller.getTableauList1().remove(cardBtn);
		}
		else if (checkSource(cardBtn) == "Tableau2") {
			tableauList2.remove(cardBtn);
		}
		else if (checkSource(cardBtn) == "Tableau3") {
			tableauList3.remove(cardBtn);
		}
		else if (checkSource(cardBtn) == "Tableau4") {
			tableauList4.remove(cardBtn);
		}
		else if (checkSource(cardBtn) == "Tableau5") {
			tableauList5.remove(cardBtn);
		}
		else if (checkSource(cardBtn) == "Tableau6") {
			tableauList6.remove(cardBtn);
		}
		else if (checkSource(cardBtn) == "Tableau7") {
			tableauList7.remove(cardBtn);
		}
		*/
	}
	
	private void moveCardToTableau(Tableau tableau) {
		Card firstCard = (Card)LastCardSelectedUtility.getFirstCardSelected();
		Card secondCard = (Card) LastCardSelectedUtility.getLastCardSelected();
		if (tableau.getCardIndexByObject(secondCard) != -1) {
			if (tableau.addCard(firstCard)) {
				checkFirstCardOrigin();
				System.out.println("Card has been added to tableau"); 
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		LastCardSelectedUtility.setCardSelected(this, LastCardSelectedUtility.indexNull);
		if (controller.getTableauList1().contains(LastCardSelectedUtility.getLastCardSelected())) {
			moveCardToTableau(tableau1);
			controller.redrawAll();
		}
		
	}

}
