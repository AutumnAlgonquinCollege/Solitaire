package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Card;
import models.GameBoard;
import models.Tableau;

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
	private Integer index;


	public TableauActionListener(Controller controller, Tableau tableau, int index) {
		this.controller = controller;
		gameBoard = controller.getGameBoard();
		this.tableau = tableau;
		this.index = Integer.valueOf(index);
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
		gameBoard.getCardDeck().removeCardByObject(card);
		card.setCardVisible(true);
		gameBoard.getTableau1().addCard(card);
	}
	
	
	private void moveCardFromTableauToTableau(Tableau tableauOrigin, int tableauDestinationNum, int tableauIndex) {
		Card card;
		switch (tableauDestinationNum) {
			
			case 0:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau1().addCard(card);
				break;
			case 1:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau2().addCard(card);
				break;
			case 2:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau3().addCard(card);
				break;
			case 3:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau4().addCard(card);
				break;
			case 4:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau5().addCard(card);
				break;
			case 5:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau6().addCard(card);
				break;
			case 6:
				card = tableauOrigin.getCardByIndex(tableauIndex);
				tableauOrigin.removeCard(card);
				gameBoard.getTableau7().addCard(card);
			default:
				break;		
		}
	}
	
	private int getCardIndexFromOriginTableau() {
		int tableauCardIndex = (int)LastCardSelectedUtility.lastIndex;
		
//		switch (originTableau) {
//		
//			case 0:
//				//HOWWWW
//				//tableauCardIndex = ;
//				break;
//			case 1:
//				//tableauCardIndex = ;
//				break;
//			case 2:
//				
//				//tableauCardIndex = ;
//				break;
//			case 3:
//				
//				//tableauCardIndex = ;
//				break;
//			case 4:
//				
//				//tableauCardIndex = ;
//				break;
//			case 5:
//				
//				//tableauCardIndex = ;
//				break;
//			case 6:
//				
//				//tableauCardIndex = ;
//			default:
//				break;
//		}
		return tableauCardIndex;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		LastCardSelectedUtility.setCardSelected(tableau, index);

		Object firstSelected = LastCardSelectedUtility.getLastCardSelected();
		Object secondSelected = LastCardSelectedUtility.getCurrentCardSelected();		
		int tableauDestination = LastCardSelectedUtility.getCurrentCardIndex();
		int tableauCardIndex;
		
		//Tableau 1		
		if (tableau1 == secondSelected) {
			
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau1, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 0){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau1, tableauDestination, tableauCardIndex);
			}
		}
		
		//Tableau 2
		if (tableau2 == secondSelected) {
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau2, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 1){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau2, tableauDestination, tableauCardIndex);
			}
		}
		
		
		//Tableau 3
		if (tableau3 == secondSelected) {
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau3, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 2){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau3, tableauDestination, tableauCardIndex);
			}
		}
		
		//Tableau 4
		if (tableau4 == secondSelected) {
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau4, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 3){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau4, tableauDestination, tableauCardIndex);
			}
		}
		
		//Tableau 5
		if (tableau5 == secondSelected) {
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau5, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 4){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau5, tableauDestination, tableauCardIndex);
			}
		}
		
		//Tableau 6
		if (tableau6 == secondSelected) {
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau6, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 5){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau6, tableauDestination, tableauCardIndex);
			}
		}
		
		//Tableau 7
		if (tableau7 == secondSelected) {
			if (gameBoard.getWastePile() == firstSelected) {
				moveCardFromDeckToTableau(tableau7, gameBoard.getWastePile().getLastCard());
			}
			else if (LastCardSelectedUtility.getLastIndexSelected() != 6){
				tableauCardIndex = getCardIndexFromOriginTableau();
				System.out.println(tableauCardIndex);
				moveCardFromTableauToTableau(tableau7, tableauDestination, tableauCardIndex);
			}
		}
		
		
		
		
		
		
		
		System.out.println(LastCardSelectedUtility.getLastCardSelected().toString());
		System.out.println(LastCardSelectedUtility.getLastIndexSelected().toString());
		
		System.out.println(LastCardSelectedUtility.getCurrentCardSelected().toString());
		System.out.println(LastCardSelectedUtility.getCurrentCardIndex().toString());
		
		controller.redrawAll();
		
		/*
		if (tableau1.getCardIndexByObject(LastCardSelectedUtility.getLastCardSelected()) {
			moveCardToTableau(tableau1);
			
		}
		*/
		
	}

}
