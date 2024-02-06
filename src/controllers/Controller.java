package controllers;

import javax.swing.ImageIcon;

import models.*;
import views.*;

public class Controller {

	public static void main(String[] args) {
		
		ImageIcon deckIcon = new ImageIcon("ImageAssets/Backs/back_2.png");
		
		GameBoard gameBoard = new GameBoard();
		GameView gameView = new GameView();
		gameView.addCardButton(new CardButton(deckIcon), (int)ControllerConstants.deckPoint.getX(), (int)ControllerConstants.deckPoint.getY());
		gameView.setViewVisible();

	}
	
	public void createGui() {
		
	}

}
