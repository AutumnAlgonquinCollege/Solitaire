package application;

import javax.swing.ImageIcon;


import controllers.*;
import controllers.ControllerConstants;
import controllers.DeckActionListener;
import models.GameBoard;
import views.CardButton;
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
		
		
//		controller.getHeartsFoundation().addActionListener(new FoundationActionListener(gameBoard.getFoundationHearts(), gameView, gameBoard.getWastePile(), controller, controller.getHeartsFoundation()));
		
		
		
		
		
		gameView.setViewVisible();

	}
}
