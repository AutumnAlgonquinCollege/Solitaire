package application;

import javax.swing.ImageIcon;


import controllers.*;
import controllers.ControllerConstants;
import controllers.DeckActionListener;
import models.Constants;
import models.GameBoard;
import views.CardButton;
import views.GameView;

public class Main {
	
	private static Controller controller;
	private static GameBoard gameBoard;
	private static boolean gameModeChanged;
	
	public static void main(String[] args) {
		newGame();
	}
	
	public static void newGame() {		
		gameBoard = new GameBoard("STANDARD", "DRAW 1");
		GameView gameView = new GameView();
		controller = new Controller(gameBoard, gameView);
		
		controller.createGui();
		gameView.setViewVisible();
	}
	
	public static void restartGame(String gameMode, String drawMode, boolean gameModeChanged) {
		int score = 0;
		if (gameMode == Constants.cumulativeVegasGameMode && !gameModeChanged) {
			score = gameBoard.getScore() + Constants.vegasScoreStart;
		}
		else if (gameMode == Constants.cumulativeVegasGameMode && gameModeChanged){
			score = Constants.vegasScoreStart;
		}
		if (gameMode == Constants.vegasGameMode) {
			score = Constants.vegasScoreStart;
		}
		gameBoard = new GameBoard(gameMode, drawMode);
		gameBoard.setScore(score);
		controller.resetGame(gameBoard);
	}
	
	public static void restartGame() {
		restartGame(gameBoard.getGameMode(), gameBoard.getDrawMode(), false);
	}
	
}
