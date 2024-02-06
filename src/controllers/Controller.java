package controllers;


import javax.swing.ImageIcon;

import models.*;
import views.*;

public class Controller {

	GameBoard gameBoard;
	GameView gameView;
	
	public Controller(GameBoard model, GameView view) {
		this.gameBoard = model;
		this.gameView = view;
	}
	
	
	public void createGui() {

	}

	public boolean deckClicked() {
		
		gameBoard.getCardDeck().drawCard(0);
		return false;
	}
	
}
