package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.*;
import views.*;

public class FoundationActionListener implements ActionListener{

	Controller controller;
	GameBoard gameBoard;
	
	
	
	public FoundationActionListener (Controller controller, GameBoard gameBoard) {
		this.controller = controller;
		this.gameBoard = gameBoard;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		gameBoard
		
	}

}
