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
		GameBoard gameBoard = new GameBoard();
		GameView gameView = new GameView();
		controller = new Controller(gameBoard, gameView);
		
		controller.createGui();
		gameView.setViewVisible();
	}
	
	public static void restartGame() {
		GameBoard gameBoard = new GameBoard();
		controller.resetGame(gameBoard);
	}
	
}
