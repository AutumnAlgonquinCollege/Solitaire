package controllers;



import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import models.*;
import views.*;

public class Controller {

	GameBoard gameBoard;
	GameView gameView;
	CardButton deckBtn;
	CardButton wasteBtn;
	List<CardButton> tableauList1;
	List<CardButton> tableauList2;
	List<CardButton> tableauList3;
	List<CardButton> tableauList4;
	List<CardButton> tableauList5;
	List<CardButton> tableauList6;
	List<CardButton> tableauList7;
	CardButton foundationSpadesBtn;
	CardButton foundationClubsBtn;
	CardButton foundationDiamondsBtn;
	CardButton foundationHeartsBtn;
	List<Integer> cardIndexes = new ArrayList<Integer>(); 
	private int deckIndex;
	
	public Controller(GameBoard model, GameView view) {
		this.gameBoard = model;
		this.gameView = view;
	}
	
	private List<CardButton> setUpTableauBtn(Tableau tableau){
		List<CardButton> cardBtnList = new ArrayList<CardButton>();
		for (int i = 0 ; i <= tableau.getTotalCards(); i++) {
			cardBtnList.add(new CardButton(tableau.getCardByIndex(i).getDisplayImage()));
		}
		if (cardBtnList.isEmpty()) {
			cardBtnList.add(new CardButton(tableau.getEmptyDisplayImage()));
		}
		return cardBtnList;
	}
	
	private void displayTableauBtn(List<CardButton> btnList, int xAxis, Tableau tableau) {
		int yAxis = (int) ControllerConstants.tableau1Point.getY();
		for (int i = 0; i < btnList.size(); i++) {
			gameView.addTableauCardButton(btnList.get(i), xAxis, yAxis, Integer.valueOf(i));
			btnList.get(i).addActionListener(new TableauActionListener(this, tableau, i));
			yAxis += 25;
		}
		
	}
	
	
	public void createGui() {
		
		//Init buttons
		deckBtn = new CardButton(Constants.backSideImg);
		wasteBtn = new CardButton(gameBoard.getWastePile().getTopCardImage());
		foundationSpadesBtn = new CardButton(gameBoard.getFoundationSpades().getFoundationDisplayImage(Constants.spades));
		foundationClubsBtn = new CardButton(gameBoard.getFoundationClubs().getFoundationDisplayImage(Constants.clubs));
		foundationDiamondsBtn = new CardButton(gameBoard.getFoundationDiamonds().getFoundationDisplayImage(Constants.diamonds));
		foundationHeartsBtn = new CardButton(gameBoard.getFoundationHearts().getFoundationDisplayImage(Constants.hearts));
		
		//Adding listeners
		deckBtn.addActionListener(new DeckActionListener(this));
		wasteBtn.addActionListener(new WasteActionListener(this));
		foundationSpadesBtn.addActionListener(new FoundationActionListener(this, Constants.spades));
		foundationClubsBtn.addActionListener(new FoundationActionListener(this, Constants.clubs));
		foundationDiamondsBtn.addActionListener(new FoundationActionListener(this, Constants.diamonds));
		foundationHeartsBtn.addActionListener(new FoundationActionListener(this, Constants.hearts));
		
		
		
		//Create deck view
		gameView.addCardButton(deckBtn, (int)ControllerConstants.deckPoint.getX(), (int)ControllerConstants.deckPoint.getY());
		
		//Create waste view
		gameView.addCardButton(wasteBtn, (int)ControllerConstants.wastePoint.getX(), (int)ControllerConstants.wastePoint.getY());
		
		//Create foundation view
		gameView.addCardButton(foundationSpadesBtn, (int)ControllerConstants.foundationSpadesPoint.getX(), (int)ControllerConstants.foundationSpadesPoint.getY());
		gameView.addCardButton(foundationClubsBtn, (int)ControllerConstants.foundationClubsPoint.getX(), (int)ControllerConstants.foundationClubsPoint.getY());
		gameView.addCardButton(foundationDiamondsBtn, (int)ControllerConstants.foundationDiamondsPoint.getX(), (int)ControllerConstants.foundationDiamondsPoint.getY());
		gameView.addCardButton(foundationHeartsBtn, (int)ControllerConstants.foundationHeartsPoint.getX(), (int)ControllerConstants.foundationHeartsPoint.getY());
		
		//Create CardButtons for tableaus
		//Stores them in a list so that we can add action listeners... Maybe with event.getSource to make sure its only the last element
		tableauList1 = setUpTableauBtn(gameBoard.getTableau1());
		tableauList2 = setUpTableauBtn(gameBoard.getTableau2());
		tableauList3 = setUpTableauBtn(gameBoard.getTableau3());
		tableauList4 = setUpTableauBtn(gameBoard.getTableau4());
		tableauList5 = setUpTableauBtn(gameBoard.getTableau5());
		tableauList6 = setUpTableauBtn(gameBoard.getTableau6());
		tableauList7 = setUpTableauBtn(gameBoard.getTableau7());
		
		
		//Create tableau view
		displayTableauBtn(tableauList1, (int)ControllerConstants.tableau1Point.getX(), gameBoard.getTableau1());
		displayTableauBtn(tableauList2, (int)ControllerConstants.tableau2Point.getX(), gameBoard.getTableau2());
		displayTableauBtn(tableauList3, (int)ControllerConstants.tableau3Point.getX(), gameBoard.getTableau3());
		displayTableauBtn(tableauList4, (int)ControllerConstants.tableau4Point.getX(), gameBoard.getTableau4());
		displayTableauBtn(tableauList5, (int)ControllerConstants.tableau5Point.getX(), gameBoard.getTableau5());
		displayTableauBtn(tableauList6, (int)ControllerConstants.tableau6Point.getX(), gameBoard.getTableau6());
		displayTableauBtn(tableauList7, (int)ControllerConstants.tableau7Point.getX(), gameBoard.getTableau7());
	}
	
	public CardButton getDeckBtn() {
		return deckBtn;
	}
	
	public CardButton getWasteBtn() {
		return wasteBtn;
	}
	
	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public int getDeckIndex() {
		return deckIndex;
	}
	
	public void setDeckIndex(int deckIndex) {
		this.deckIndex = deckIndex;
	}
	
	public Foundation getFoundation(String suit) {
		switch(suit) {
		case Constants.spades:
			return gameBoard.getFoundationSpades();
		case Constants.clubs:
			return gameBoard.getFoundationClubs();
		case Constants.diamonds:
			return gameBoard.getFoundationDiamonds();
		case Constants.hearts:
			return gameBoard.getFoundationHearts();
		default:
			return gameBoard.getFoundationClubs();
		
		}
	}
	
	public void setCardIndexes(Integer cardIndex) {
		if (cardIndexes.size() >= 2) {
			cardIndexes.removeAll(cardIndexes);
		}
		cardIndexes.add(cardIndex);
	}
	
	public int getCardIndexes(int cardIndex) {
		return cardIndexes.get(cardIndex);
	}
	
	public List<CardButton> getTableauList1() {	return tableauList1; }
	public List<CardButton> getTableauList2() {	return tableauList2; }
	public List<CardButton> getTableauList3() {	return tableauList3; }
	public List<CardButton> getTableauList4() {	return tableauList4; }
	public List<CardButton> getTableauList5() {	return tableauList5; }
	public List<CardButton> getTableauList6() {	return tableauList6; }
	public List<CardButton> getTableauList7() {	return tableauList7; }
		
	
	public void redrawAll() {
		gameView.getPane().removeAll();
		gameView.getPane().repaint();
		createGui();
	}

	public boolean deckClicked() {
		gameBoard.getCardDeck().getCardByIndex(0);
		return false;
	}
	
}
