package application;

import javax.swing.ImageIcon;

import controllers.Controller;
import controllers.ControllerConstants;
import models.GameBoard;
import views.CardButton;
import views.GameView;

public class Main {

	public static void main(String[] args) {
		
		ImageIcon deckIcon = new ImageIcon("ImageAssets/Backs/back_2.png");
		
		GameBoard gameBoard = new GameBoard();
		GameView gameView = new GameView();
		Controller controller = new Controller(gameBoard, gameView);
		gameView.addCardButton(new CardButton(deckIcon), (int)ControllerConstants.deckPoint.getX(), (int)ControllerConstants.deckPoint.getY());
		gameView.setViewVisible();

	}
}
