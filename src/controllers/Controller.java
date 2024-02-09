package controllers;



import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import models.*;
import views.*;

public class Controller {

	GameBoard gameBoard;
	GameView gameView;
	CardButton deckBtn;
	CardButton wasteBtn;
	List<ButtonGroup> tableauBtnGList;
	ButtonGroup tableauBtns1;
	ButtonGroup tableauBtns2;
	ButtonGroup tableauBtns3;
	ButtonGroup tableauBtns4;
	ButtonGroup tableauBtns5;
	ButtonGroup tableauBtns6;
	ButtonGroup tableauBtns7;
	List<List<CardButton>> tableauLists; 
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
	
	private int deckIndex;
	
	public Controller(GameBoard model, GameView view) {
		this.gameBoard = model;
		this.gameView = view;
		tableauLists = new ArrayList<List<CardButton>>();
		initTableauList();
		//initButtonGroup();
		tableauBtns1 = new ButtonGroup();
		tableauBtns2 = new ButtonGroup();
		tableauBtns3 = new ButtonGroup();
		tableauBtns4 = new ButtonGroup();
		tableauBtns5 = new ButtonGroup();
		tableauBtns6 = new ButtonGroup();
		tableauBtns7 = new ButtonGroup();
		
	}
	
	private List<CardButton> setUpTableauBtn(Tableau tableau){
		List<CardButton> cardBtnList = new ArrayList<CardButton>();
		for (int i = 0 ; i <= tableau.getTotalCards(); i++) {
			cardBtnList.add(new CardButton(tableau.getCardByIndex(i).getDisplayImage(), tableau.getCardByIndex(i), null));			
		}
		return cardBtnList;
	}
	
	private void displayTableauBtn(List<CardButton> btnList, int xAxis) {
		int yAxis = (int) ControllerConstants.tableau1Point.getY();
		for (int i = 0; i < btnList.size(); i++) {
			gameView.addTableauCardButton(btnList.get(i), xAxis, yAxis, Integer.valueOf(i));
			yAxis += 25;
		}
	}
	
	private ButtonGroup setUpButtonGroup(ButtonGroup tableauBtns, List<CardButton> tableauList) {
		for (int i = 0; i < tableauList.size() - 1; i++) {
			tableauBtns.add(tableauList.get(i));
		}
		return tableauBtns;
	}
	
	private void initTableauList() {
		
		//Create CardButtons for tableaus
		//Stores them in a list so that we can add action listeners... Maybe with event.getSource to make sure its only the last element
		tableauList1 = setUpTableauBtn(gameBoard.getTableau1());
		tableauList2 = setUpTableauBtn(gameBoard.getTableau2());
		tableauList3 = setUpTableauBtn(gameBoard.getTableau3());
		tableauList4 = setUpTableauBtn(gameBoard.getTableau4());
		tableauList5 = setUpTableauBtn(gameBoard.getTableau5());
		tableauList6 = setUpTableauBtn(gameBoard.getTableau6());
		tableauList7 = setUpTableauBtn(gameBoard.getTableau7());
	}
	
	private void initButtonGroup() {
		//Sets up ButtonGroups for tableaus
		setUpButtonGroup(tableauBtns1, tableauList1);
		setUpButtonGroup(tableauBtns2, tableauList2);
		setUpButtonGroup(tableauBtns3, tableauList3);
		setUpButtonGroup(tableauBtns4, tableauList4);
		setUpButtonGroup(tableauBtns5, tableauList5);
		setUpButtonGroup(tableauBtns6, tableauList6);
		setUpButtonGroup(tableauBtns7, tableauList7);
	}
	
	public CardButton testWasteButton;
	public void createGui() {
		
		//TEST WASTE BUTTONS
		testWasteButton = new CardButton(new ImageIcon(Constants.heartsImgPath[0]), null, null);
		gameView.addCardButton(testWasteButton,10, 500);
		
		//Instantiate card buttons
		deckBtn = new CardButton(Constants.backSideImg, null, gameBoard.getCardDeck().getCardList());
		wasteBtn = new CardButton(Constants.emptyCardImg, null, null);
		foundationSpadesBtn = new CardButton(Constants.spadesFoundationImg, null, null);
		foundationClubsBtn = new CardButton(Constants.clubsFoundationImg, null, null);
		foundationDiamondsBtn = new CardButton(Constants.diamondsFoundationImg, null, null);
		foundationHeartsBtn = new CardButton(Constants.heartsFoundationImg, null, null);
		
		//Create deck view
		gameView.addCardButton(deckBtn, (int)ControllerConstants.deckPoint.getX(), (int)ControllerConstants.deckPoint.getY());
		
		//Create waste view
		gameView.addCardButton(wasteBtn, (int)ControllerConstants.wastePoint.getX(), (int)ControllerConstants.wastePoint.getY());
		
		//Create foundation view
		gameView.addCardButton(foundationSpadesBtn, (int)ControllerConstants.foundationSpadesPoint.getX(), (int)ControllerConstants.foundationSpadesPoint.getY());
		gameView.addCardButton(foundationClubsBtn, (int)ControllerConstants.foundationClubsPoint.getX(), (int)ControllerConstants.foundationClubsPoint.getY());
		gameView.addCardButton(foundationDiamondsBtn, (int)ControllerConstants.foundationDiamondsPoint.getX(), (int)ControllerConstants.foundationDiamondsPoint.getY());
		gameView.addCardButton(foundationHeartsBtn, (int)ControllerConstants.foundationHeartsPoint.getX(), (int)ControllerConstants.foundationHeartsPoint.getY());
		
		
		//Create tableau view
		displayTableauBtn(tableauList1, (int)ControllerConstants.tableau1Point.getX());
		displayTableauBtn(tableauList2, (int)ControllerConstants.tableau2Point.getX());
		displayTableauBtn(tableauList3, (int)ControllerConstants.tableau3Point.getX());
		displayTableauBtn(tableauList4, (int)ControllerConstants.tableau4Point.getX());
		displayTableauBtn(tableauList5, (int)ControllerConstants.tableau5Point.getX());
		displayTableauBtn(tableauList6, (int)ControllerConstants.tableau6Point.getX());
		displayTableauBtn(tableauList7, (int)ControllerConstants.tableau7Point.getX());
	}
	
	public CardButton getDeckBtn() {
		return deckBtn;
	}
	
	public CardButton getWasteBtn() {
		return wasteBtn;
	}
	
	public CardButton getHeartsFoundation() {
		return foundationHeartsBtn;
	}
	
	
	public List<List <CardButton>> getTableauLists() {
		tableauLists.add(tableauList1);
		tableauLists.add(tableauList2);
		tableauLists.add(tableauList3);
		tableauLists.add(tableauList4);
		tableauLists.add(tableauList5);
		tableauLists.add(tableauList6);
		tableauLists.add(tableauList7);
		return tableauLists;
		}
	
	public List<CardButton> getTableauList1() { return tableauList1; }
	public List<CardButton> getTableauList2() { return tableauList2; }
	public List<CardButton> getTableauList3() { return tableauList3; }
	public List<CardButton> getTableauList4() { return tableauList4; }
	public List<CardButton> getTableauList5() { return tableauList5; }
	public List<CardButton> getTableauList6() { return tableauList6; }
	public List<CardButton> getTableauList7() { return tableauList7; }
	
	public List<ButtonGroup> getTableauBtnGList() {	return tableauBtnGList; }
	

	public boolean deckClicked() {
		gameBoard.getCardDeck().getCardByIndex(0);
		return false;
	}
	
	
}
