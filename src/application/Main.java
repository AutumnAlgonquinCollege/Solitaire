package application;

import javax.swing.ImageIcon;


import controllers.*;
import controllers.ControllerConstants;
import controllers.DeckActionListener;
import models.GameBoard;
import views.CardButton;
import views.GameView;

public class Main {
	
	private static Controller controller;
	
	public static void main(String[] args) {
		newGame();
	}
	
	public static void newGame() {		
		GameBoard gameBoard = new GameBoard("STANDARD", "DRAW 1");
		GameView gameView = new GameView();
		controller = new Controller(gameBoard, gameView);
		
		controller.createGui();
		gameView.setViewVisible();
	}
	
	public static void restartGame(String gameMode, String drawMode) {
		GameBoard gameBoard = new GameBoard(gameMode, drawMode);
		controller.resetGame(gameBoard);
	}
	
}
