package application;

import javax.swing.ImageIcon;


import controllers.*;
import controllers.ControllerConstants;
import controllers.DeckActionListener;
import models.GameBoard;
import views.CardButton;
import views.DeckButton;
import views.GameView;

public class Main {

	public static void main(String[] args) {
		
		//ImageIcon deckIcon = new ImageIcon(models.Constants.backSideImg);
		
		GameBoard gameBoard = new GameBoard();
		GameView gameView = new GameView();
		Controller controller = new Controller(gameBoard, gameView);
		
		controller.createGui();
		
		CardButton deckButton = controller.getDeckBtn();
		CardButton wasteButton = controller.getWasteBtn();
		CardButton heartsFoundation = controller.getHeartsFoundation();
		controller.getDeckBtn().addActionListener(new DeckActionListener(deckButton, gameBoard.getCardDeck(), wasteButton, gameBoard.getWastePile()));
		controller.getWasteBtn().addActionListener(new WasteActionListener());
		//controller.testWasteButton.addActionListener(new WasteActionListener());
		controller.getHeartsFoundation().addActionListener(new FoundationActionListener(gameBoard.getFoundationHearts(), gameView, gameBoard.getWastePile(), controller, controller.getHeartsFoundation()));
		
		for (int i = 0; i < controller.getTableauList1().size(); i++) {
			controller.getTableauList1().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		for (int i = 0; i < controller.getTableauList2().size(); i++) {
			controller.getTableauList2().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		for (int i = 0; i < controller.getTableauList3().size(); i++) {
			controller.getTableauList3().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		for (int i = 0; i < controller.getTableauList4().size(); i++) {
			controller.getTableauList4().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		for (int i = 0; i < controller.getTableauList5().size(); i++) {
			controller.getTableauList5().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		for (int i = 0; i < controller.getTableauList6().size(); i++) {
			controller.getTableauList6().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		for (int i = 0; i < controller.getTableauList7().size(); i++) {
			controller.getTableauList7().get(i).addActionListener(new TableauActionListener(gameBoard, controller.getTableauLists(), wasteButton, deckButton, gameView));
		}
		
		
		
		
		gameView.setViewVisible();

	}
}
