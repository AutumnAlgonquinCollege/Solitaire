package controllers;



import java.util.List;

import models.*;
import views.*;

public class Controller {

	GameBoard gameBoard;
	GameView gameView;
	CardButton deckBtn;
	CardButton wasteBtn;
	CardButton tableauBtn1;
	CardButton tableauBtn2;
	CardButton tableauBtn3;
	CardButton tableauBtn4;
	CardButton tableauBtn5;
	CardButton tableauBtn6;
	CardButton tableauBtn7;
	CardButton foundationSpadesBtn;
	CardButton foundationClubsBtn;
	CardButton foundationDiamondsBtn;
	CardButton foundationHeartsBtn;
	
	private int deckIndex;
	
	public Controller(GameBoard model, GameView view) {
		this.gameBoard = model;
		this.gameView = view;
	}
	
	private void setUpTableauBtn(Tableau tableau, int xAxis){
		int yAxis = (int) ControllerConstants.tableau1Point.getY();
		for (int i = 0 ; i <= tableau.getTotalCards(); i++) {
			gameView.addCardButton(new CardButton(tableau.getCardByIndex(i).getDisplayImage()), xAxis, yAxis);
			yAxis += 25;
		}
	}
	
	
	public void createGui() {
		//Instantiate card buttons
		deckBtn = new CardButton(Constants.backSideImg);
		wasteBtn = new CardButton(Constants.emptyCardImg);
		foundationSpadesBtn = new CardButton(Constants.spadesFoundationImg);
		foundationClubsBtn = new CardButton(Constants.clubsFoundationImg);
		foundationDiamondsBtn = new CardButton(Constants.diamondsFoundationImg);
		foundationHeartsBtn = new CardButton(Constants.heartsFoundationImg);
		
		//Create deck view
		gameView.addCardButton(deckBtn, (int)ControllerConstants.deckPoint.getX(), (int)ControllerConstants.deckPoint.getY());
		
		//Create waste point
		gameView.addCardButton(wasteBtn, (int)ControllerConstants.wastePoint.getX(), (int)ControllerConstants.wastePoint.getY());
		
		//Create foundation view
		gameView.addCardButton(foundationSpadesBtn, (int)ControllerConstants.foundationSpadesPoint.getX(), (int)ControllerConstants.foundationSpadesPoint.getY());
		gameView.addCardButton(foundationClubsBtn, (int)ControllerConstants.foundationClubsPoint.getX(), (int)ControllerConstants.foundationClubsPoint.getY());
		gameView.addCardButton(foundationDiamondsBtn, (int)ControllerConstants.foundationDiamondsPoint.getX(), (int)ControllerConstants.foundationDiamondsPoint.getY());
		gameView.addCardButton(foundationHeartsBtn, (int)ControllerConstants.foundationHeartsPoint.getX(), (int)ControllerConstants.foundationHeartsPoint.getY());
		
		//Create tableau view
		setUpTableauBtn(gameBoard.getTableau1(), (int)ControllerConstants.tableau1Point.getX());
		setUpTableauBtn(gameBoard.getTableau2(), (int)ControllerConstants.tableau2Point.getX());
		setUpTableauBtn(gameBoard.getTableau3(), (int)ControllerConstants.tableau3Point.getX());
		setUpTableauBtn(gameBoard.getTableau4(), (int)ControllerConstants.tableau4Point.getX());
		setUpTableauBtn(gameBoard.getTableau5(), (int)ControllerConstants.tableau5Point.getX());
		setUpTableauBtn(gameBoard.getTableau6(), (int)ControllerConstants.tableau6Point.getX());
		setUpTableauBtn(gameBoard.getTableau7(), (int)ControllerConstants.tableau7Point.getX());

	}
	
	
	public CardButton getDeckBtn() {
		return deckBtn;
	}
	
	public CardButton getWasteBtn() {
		return wasteBtn;
	}

	public boolean deckClicked() {
		gameBoard.getCardDeck().getCardByIndex(0);
		return false;
	}
	
}
