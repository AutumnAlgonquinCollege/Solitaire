package controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;

import models.GameBoard;
import models.Tableau;
import views.CardButton;
import views.GameView;

public class TableauActionListener implements ActionListener {
	
	private GameView gameView;
	private ButtonGroup tableauBtnGroup1;
	private ButtonGroup tableauBtnGroup2;
	private ButtonGroup tableauBtnGroup3;
	private ButtonGroup tableauBtnGroup4;
	private ButtonGroup tableauBtnGroup5;
	private ButtonGroup tableauBtnGroup6;
	private ButtonGroup tableauBtnGroup7;
	private CardButton deck;
	private CardButton wastePile;
	private List<List<CardButton>> tableauLists;
	private List<CardButton> tableauList1;
	private List<CardButton> tableauList2;
	private List<CardButton> tableauList3;
	private List<CardButton> tableauList4;
	private List<CardButton> tableauList5;
	private List<CardButton> tableauList6;
	private List<CardButton> tableauList7;
	private Tableau tableau1;
	private Tableau tableau2;
	private Tableau tableau3;
	private Tableau tableau4;
	private Tableau tableau5;
	private Tableau tableau6;
	private Tableau tableau7;
	

	public TableauActionListener(GameBoard gameBoard, List<List<CardButton>> tableauLists, CardButton deck, GameView gameView) {
		this.gameView = gameView;
		this.wastePile = wastePile;
		this.deck = deck;
		this.tableauLists = tableauLists;
		initTableauModels(gameBoard);	
		initBtnTableauLists(tableauLists);
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
	
	private void initBtnTableauLists(List<List<CardButton>> tableauLists) {
		//CardButton tableau lists
		tableauList1 = tableauLists.get(0);
		tableauList2 = tableauLists.get(1);
		tableauList3 = tableauLists.get(2);
		tableauList4 = tableauLists.get(3);
		tableauList5 = tableauLists.get(4);
		tableauList6 = tableauLists.get(5);
		tableauList7 = tableauLists.get(6);
	}
	
	/*
	private void initTableauButtonGroups(List<ButtonGroup> tableauBtnGList) {
		tableauBtnGroup1 = tableauBtnGList.get(0);
		tableauBtnGroup2 = tableauBtnGList.get(1);
		tableauBtnGroup3 = tableauBtnGList.get(2);
		tableauBtnGroup4 = tableauBtnGList.get(3);
		tableauBtnGroup5 = tableauBtnGList.get(4);
		tableauBtnGroup6 = tableauBtnGList.get(5);
		tableauBtnGroup7 = tableauBtnGList.get(6);
	}
	*/
	
	private boolean isLastElement(List<CardButton> tableauList, int index) {
		boolean lastButton = false;
		if (index == tableauList.size() - 1) {
			lastButton = true;
		}
		return lastButton;
	}
	
	private int getLastIndex(List<CardButton> tableauList) {
		return tableauList.size() - 1;
	}
	
	private CardButton getLastButton(List<CardButton> tableauList) {
		CardButton cardBtn = tableauList.get(tableauList.size() - 1);		
		return cardBtn;
	}
	
	private void disableHiddenButtons(List<CardButton> tableauList) {
		for (int i = 0; i < tableauList.size() - 1; i++) {
			if (!isLastElement(tableauList, i)) {
				tableauList.get(i).setEnabled(false);
			}
			else {
				tableauList.get(i).setEnabled(true);
			}
		}
	}
	
	private boolean checkWastePile(CardButton cardBtn) {
		boolean result = false;
		if (cardBtn == wastePile) {
			result = true;
		}
		return result;
	}
	
	private String checkSource(CardButton cardBtn) {
		String result = "";
		if (cardBtn == wastePile) {
			result = "Waste";
		}
		else if (tableauList1.contains(cardBtn)) {
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
	
	private void checkFirstCardOrigin() {
		CardButton cardBtn = LastCardSelectedUtility.getFirstCardSelected();
		if (checkWastePile(cardBtn)) {
			wastePile.remove(cardBtn);
			deck.remove(cardBtn);
			System.out.println("Deleted card from origin");
		}
		else if (checkSource(cardBtn) == "Tableau1") {
			tableauList1.remove(cardBtn);
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
	}
	
	// && firstCardBtn != getLastButton(tableauList)
	private void moveCardToTableau(List<CardButton> tableauList, Tableau tableau) {
		CardButton firstCardBtn = LastCardSelectedUtility.getFirstCardSelected();
		CardButton lastCardBtn = LastCardSelectedUtility.getLastCardSelected();
		if (lastCardBtn == getLastButton(tableauList)) {
			if (tableau.addCard(firstCardBtn.getCardModel())) {
				checkFirstCardOrigin();
				updateUI(tableauList);
				System.out.println("Card has been added to model"); 
			}
		}
	}
	
	private void displayTableauBtn(List<CardButton> btnList, int xAxis) {
		int yAxis = (int) ControllerConstants.tableau1Point.getY();
		for (int i = 0; i < btnList.size(); i++) {
			gameView.addTableauCardButton(btnList.get(i), xAxis, yAxis, Integer.valueOf(i));
			yAxis += 25;
		}
	}
	
	private void updateUI(List<CardButton> tableauList) {
		CardButton secondBtn = getLastButton(tableauList);
		CardButton firstBtn = LastCardSelectedUtility.getFirstCardSelected();
		if (checkSource(firstBtn) == "Waste") {
			
		}
		Point secondBtnPoint = secondBtn.getLocation();
		int xAxis = secondBtnPoint.x;
		int yAxis = secondBtnPoint.y;
		firstBtn.setLocation(xAxis, yAxis+25);
		
	}
	
	private void setUpDisabledButtons() {
		disableHiddenButtons(tableauList1);
		disableHiddenButtons(tableauList2);
		disableHiddenButtons(tableauList3);
		disableHiddenButtons(tableauList4);
		disableHiddenButtons(tableauList5);
		disableHiddenButtons(tableauList6);
		disableHiddenButtons(tableauList7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//setUpDisabledButtons();
		
		LastCardSelectedUtility.setCardSelected((CardButton)e.getSource());
		System.out.println(e.getSource());
		
		//Tableau 1
		moveCardToTableau(tableauList1, tableau1);
		
	}
	
}
