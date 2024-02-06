package application;

import javax.swing.ImageIcon;

import controllers.Controller;
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
		controller.getDeckBtn().addActionListener(new DeckActionListener(deckButton, gameBoard.getCardDeck(), wasteButton));
		
		//deckButton.addActionListener(new DeckActionListener(deckButton, gameBoard.getCardDeck()));
		
		//gameView.addCardButton(new CardButton(deckIcon), (int)ControllerConstants.deckPoint.getX(), (int)ControllerConstants.deckPoint.getY());
		
		
		
		gameView.setViewVisible();

	}
}
