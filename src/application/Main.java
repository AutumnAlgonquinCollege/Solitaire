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
		
		GameBoard gameBoard = new GameBoard();
		GameView gameView = new GameView();
		Controller controller = new Controller(gameBoard, gameView);
		
		controller.createGui();		
		gameView.setViewVisible();

	}
}
